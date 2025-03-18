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

        private static string UltimoReporteHtml = "";

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

            try
            {
                var ArbolSintactico = Parser.program();
                var PatronVisitor = new InterpreteVisitor();
                PatronVisitor.Visit(ArbolSintactico);

                UltimoReporteHtml = PatronVisitor.EntornoActual.ExportarTablaHtml();

                return Ok(new { result = PatronVisitor.Salida });
            }
            catch (ParseCanceledException ex)
            {
                return BadRequest(new { error = ex.Message });
            }
            catch (ErrorSemantico ex)
            {
                return BadRequest(new { error = ex.Message });
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }
        }

        [HttpGet("DescargarReporteTabla")]
        public IActionResult DescargarReporteHtml()
        {
            if (string.IsNullOrEmpty(UltimoReporteHtml))
            {
                return BadRequest(new { error = "No hay un reporte disponible. Compila primero." });
            }
            string NombreArchivo = "TablaSimbolos.html";
            byte[] NombreEnBytes = System.Text.Encoding.UTF8.GetBytes(UltimoReporteHtml);
            return File(NombreEnBytes, "text/html", NombreArchivo);
        }

    }
}
