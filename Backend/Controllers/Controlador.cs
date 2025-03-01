using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using Antlr4.Runtime;
using Analizador;
using System.Diagnostics;

namespace Backend.Controllers
{
    [Route("[controller]")]
    public class Controlador : Controller
    {
        private readonly ILogger<Controlador> _logger;

        public Controlador(ILogger<Controlador> logger)
        {
            _logger = logger;
        }

        public class CompileRequest
        {
            [Required]
            public required string code { get; set; }
        }

        //Endpoint para Compilar Código Normalmente
        [HttpPost("Compilar")]
        public IActionResult Compilar([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Petición Incorrecta" });
            }
            try
            {
                var CadenaEntrada = new AntlrInputStream(request.code);
                var Lexemas = new LanguageLexer(CadenaEntrada);
                var Tokens = new CommonTokenStream(Lexemas);
                var Parser = new LanguageParser(Tokens);
                var ArbolSintactico = Parser.program();
                var PatronVisitor = new InterpreteVisitor();
                PatronVisitor.Visit(ArbolSintactico);
                return Ok(new { result = PatronVisitor.Salida });
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }
        }

        // Endpoint para Generar la Gráfica del AST
        [HttpPost("Graficar")]
        public IActionResult Graficar([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Petición Incorrecta" });
            }
            try
            {
                var CadenaEntrada = new AntlrInputStream(request.code);
                var Lexemas = new LanguageLexer(CadenaEntrada);
                var Tokens = new CommonTokenStream(Lexemas);
                var Parser = new LanguageParser(Tokens);
                var ArbolSintactico = Parser.program();
                
                // Crear Visitor para generar el AST en formato DOT
                var astVisitor = new ASTVisitor();
                astVisitor.Visit(ArbolSintactico);
                string dotCode = astVisitor.GetDotRepresentation();

                // Guardar el código DOT en un archivo temporal
                string dotFilePath = Path.Combine(Path.GetTempPath(), "ast.dot");
                System.IO.File.WriteAllText(dotFilePath, dotCode);

                // Generar la imagen usando Graphviz
                string imagePath = Path.Combine(Path.GetTempPath(), "ast.png");
                ProcessStartInfo startInfo = new ProcessStartInfo
                {
                    FileName = "dot",
                    Arguments = $"-Tpng \"{dotFilePath}\" -o \"{imagePath}\"",
                    RedirectStandardOutput = true,
                    RedirectStandardError = true,
                    UseShellExecute = false,
                    CreateNoWindow = true
                };

                using (Process process = new Process { StartInfo = startInfo })
                {
                    process.Start();
                    process.WaitForExit();
                }

                // Leer la imagen y devolverla en la respuesta
                byte[] imageBytes = System.IO.File.ReadAllBytes(imagePath);
                return File(imageBytes, "image/png");
            }
            catch (Exception ex)
            {
                return BadRequest(new { error = ex.Message });
            }
        }
    }
}
