using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using Antlr4.Runtime;
using Analizador;
using System.Diagnostics;
using Antlr4.Runtime.Misc;
using System.Text.Json;
using System.Text;

namespace Backend.Controllers
{
    [Route("[controller]")]
    public class Controlador : Controller
    {
        private readonly ILogger<Controlador> _logger;

        private static string UltimoReporteTabla = "";
        private static string UltimoReporteErrores = "";

        public Controlador(ILogger<Controlador> logger)
        {
            _logger = logger;
        }

        public class CompileRequest
        {
            [Required]
            public required string code { get; set; }
        }

        [HttpPost("Compilar")]
        public IActionResult Compilar([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Petición Incorrecta" });
            }

            var CadenaEntrada = new AntlrInputStream(request.code);
            var Lexemas = new LanguageLexer(CadenaEntrada);

            Lexemas.RemoveErrorListeners();
            Lexemas.AddErrorListener(new ErrorLexico());

            var Tokens = new CommonTokenStream(Lexemas);
            var Parser = new LanguageParser(Tokens);

            Parser.RemoveErrorListeners();
            Parser.AddErrorListener(new ErrorSintactico());

            Entorno.TablaGlobalSimbolos.Clear();
            Error.TablaGlobalErrores.Clear();

            try
            {
                var ArbolSintactico = Parser.program();
                var PatronVisitor = new InterpreteVisitor();
                PatronVisitor.Visit(ArbolSintactico);

                UltimoReporteTabla = PatronVisitor.EntornoActual.ExportarTablaHtml();

                return Ok(new { result = PatronVisitor.Salida });
            }
            catch (ParseCanceledException ex)
            {
               UltimoReporteErrores = new Error().ExportarTablaErrores();
                return BadRequest(new { error = ex.Message });
            }
            catch (ErrorSemantico ex)
            {
                UltimoReporteErrores = new Error().ExportarTablaErrores();
                return BadRequest(new { error = ex.Message });
            }
            catch (Exception ex)
            {
                UltimoReporteErrores = new Error().ExportarTablaErrores();
                return BadRequest(new { error = ex.Message });
            }
        }

        [HttpGet("DescargarReporteTabla")]
        public IActionResult DescargarReporteHtml()
        {
            if (string.IsNullOrEmpty(UltimoReporteTabla))
            {
                return BadRequest(new { error = "No hay un reporte disponible." });
            }
            string NombreArchivo = "TablaSimbolos.html";
            byte[] NombreEnBytes = System.Text.Encoding.UTF8.GetBytes(UltimoReporteTabla);
            return File(NombreEnBytes, "text/html", NombreArchivo);
        }

        [HttpGet("DescargarReporteErrores")]
        public IActionResult DescargarReporteErrores()
        {
            if (string.IsNullOrEmpty(UltimoReporteErrores))
            {
                return BadRequest(new { error = "No hay un reporte disponible" });
            }
            string NombreArchivo = "TablaErrores.html";
            byte[] NombreEnBytes = System.Text.Encoding.UTF8.GetBytes(UltimoReporteErrores);
            return File(NombreEnBytes, "text/html", NombreArchivo);
        }
        
        [HttpPost("DescargarReporteAST")]
        public async Task<IActionResult> DescargarReporteAST ([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Petición Incorrecta" });
            }
            string grammarPath = Path.Combine(Directory.GetCurrentDirectory(), "./Gramatica/Language.g4");
            var grammar ="";
            try
            {
                if (System.IO.File.Exists(grammarPath)){
                    grammar = await System.IO.File.ReadAllTextAsync(grammarPath);
                } else {
                    return BadRequest(new { error = "No se encontro el archivo de gramatica" });
                }
               
            }
            catch (System.Exception)
            {
                return BadRequest(new { error = "Error al leer el archivo de gramatica" });
            }
            
            var payload = new { 
                grammar,
                lexgrammar = "",
                input = request.code,
                start = "program" 
            };

            var JsonPayLoad = JsonSerializer.Serialize(payload);
            var context = new StringContent(JsonPayLoad, Encoding.UTF8, "application/json");
            using (var client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.PostAsync("http://lab.antlr.org/parse/", context);
                    response.EnsureSuccessStatusCode();

                    string result = await response.Content.ReadAsStringAsync();

                    using var doc = JsonDocument.Parse(result);
                    var root = doc.RootElement;

                    if (root.TryGetProperty("result", out JsonElement resultElement) && resultElement.TryGetProperty("svgtree", out JsonElement svgTreeElement))
                    {
                        string svgtree = svgTreeElement.GetString() ?? string.Empty;
                        return Content(svgtree, "image/svg+xml");
                    }
                    return BadRequest(new { error = "Error al obtener el reporte AST SVG" });
                }
                catch (System.Exception)
                {
                    return BadRequest(new { error = "Error al obtener el reporte AST" });
                }
            }
        }
    }
}
