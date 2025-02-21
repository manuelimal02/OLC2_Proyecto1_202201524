using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using Antlr4.Runtime;
using Analizador;

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

        public IActionResult Index()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        [HttpPost]
        public IActionResult Post([FromBody] CompileRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(new { error = "Petición Incorrecta" });
            }
            var CadenaEntrada = new AntlrInputStream(request.code);
            var Lexemas = new LanguageLexer(CadenaEntrada);
            var Tokens = new CommonTokenStream(Lexemas);
            var Parser = new LanguageParser(Tokens);
            var ArbolSintactico = Parser.program();
            var PatronVisitor = new InterpreteVisitor();
            PatronVisitor.Visit(ArbolSintactico);
            return Ok(new { result = PatronVisitor.Salida});
        }
    }
}