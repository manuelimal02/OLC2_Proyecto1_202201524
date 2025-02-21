grammar Language;

program: declaraciones*;

declaraciones: declaracion_variable 
			| sentencia;

declaracion_variable: 'var' IDENTIFICADOR TIPO '=' expresion (';')? # DeclaracionExplicita
	| 'var' IDENTIFICADOR TIPO (';')?                               # DeclaracionPorDefecto
	| IDENTIFICADOR ':=' expresion (';')?                           # DeclaracionImplicita
	;

sentencia: expresion ';' # ExprStmt 
		;

expresion:
	'-' expresion						# RestaUnaria
	| expresion ('*' | '/') expresion	# MulDiv
	| expresion ('+' | '-') expresion	# AddSub
	| BOOLEANO							# Booleano
	| DECIMAL							# Decimal
	| CARACTER							# Caracter
	| CADENA							# Cadena
	| ENTERO							# Entero
	| IDENTIFICADOR						# Identificador
	| '(' expresion ')'					# Parentesis
	;

TIPO: 'int' 	
	| 'float64' 
	| 'string' 
	| 'bool' 
	| 'rune'
	;	

ENTERO: [0-9]+;
DECIMAL: [0-9]+ '.' [0-9]+;
CADENA: '"' ~["]* '"';
BOOLEANO: 'true' | 'false';
CARACTER: '\'' ~["]* '\'';

IDENTIFICADOR: [_a-zA-Z][_a-zA-Z0-9]*;

WS: [ \t\r\n]+ -> skip;
COMENTARIO: COMENTARIOL | COMENTARIOLN;
COMENTARIOL: '//' ~[\n\r]* -> skip;
COMENTARIOLN: '/*' .*? '*/'-> skip;