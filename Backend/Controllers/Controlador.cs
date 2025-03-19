using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using Antlr4.Runtime;
using Analizador;
using System.Diagnostics;
using Antlr4.Runtime.Misc;

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
                return BadRequest(new { error = "No hay un reporte disponible. Compila primero." });
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
                return BadRequest(new { error = "No hay un reporte disponible. Compila primero." });
            }
            string NombreArchivo = "TablaErrores.html";
            byte[] NombreEnBytes = System.Text.Encoding.UTF8.GetBytes(UltimoReporteErrores);
            return File(NombreEnBytes, "text/html", NombreArchivo);
        }

    }
}
