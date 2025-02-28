grammar Language;

program: declaraciones*;

declaraciones: declaracion_arreglo 
	| declaracion_variable
	| sentencia
	;

declaracion_variable: 'var' IDENTIFICADOR TIPO '=' expresion (';')? # DeclaracionExplicita
	| 'var' IDENTIFICADOR TIPO (';')?                               # DeclaracionPorDefecto
	| IDENTIFICADOR ':=' expresion (';')?                           # DeclaracionImplicita
	;

declaracion_arreglo: IDENTIFICADOR ':=' '[' ']' TIPO '{' (expresion (',' expresion)*) '}' (';')? 	# DeclaracionArregloExplicita
	| 'var' IDENTIFICADOR '[' ']' TIPO  (';')? 														# DeclaracionArregloPorDefecto
	;

sentencia: expresion (';')? 																				# ExpresionSentencia
	| 'fmt.Println(' expresion (',' expresion)* ')' (';')?  												# FuncionEmbebidaPrintln
	| '{' declaraciones* '}' 																				# Bloque
	| 'if' ('(' condicion=expresion ')' | condicion=expresion) sentencia ('else' sentencia)? 				# SentenciaIf
	| 'switch' ('(' condicion=expresion ')' | condicion=expresion) '{' casos_switch* (default_switch)? '}' 	# SentenciaSwitch
	;

casos_switch: 'case' expresion ':' declaraciones*; 														
default_switch: 'default' ':' declaraciones*; 														

expresion:
	'append(' IDENTIFICADOR ',' expresion ')' (';')?      							# FuncionEmbebidaAppend
 	| 'strconv.Atoi(' expresion ')' (';')?                  						# FuncionEmbebidaAtoi
	| 'strconv.ParseFloat(' expresion ')'(';')?             						# FuncionEmbebidaParseFloat
	| 'reflect.TypeOf(' expresion ')' (';')?                						# FuncionEmbebidaReflectTypeOf
	| 'slices.Index(' IDENTIFICADOR ',' expresion ')' (';')?                 		# FuncionEmbebidaSlicesIndex
	| 'strings.Join(' IDENTIFICADOR ',' expresion ')' (';')?   						# FuncionEmbebidaStringsJoin
	| 'len(' IDENTIFICADOR ')' (';')?                      							# FuncionEmbebidaLen
	| operador='-' izquierda=expresion                                         		# NegacionUnaria
	| operador='!' izquierda=expresion                                       		# NegacionLogica
	| izquierda=expresion operador=('*' | '/' | '%') derecha=expresion              # MultiplicacionDivisionModulo
	| izquierda=expresion operador=('+' | '-') derecha=expresion                    # SumaResta
	| izquierda=expresion operador=('<' | '<=' | '>' | '>=') derecha=expresion      # Relacional
	| izquierda=expresion operador=('==' | '!=') derecha=expresion                  # IgualdadDesigualdad
	| izquierda=expresion operador='&&' derecha=expresion                           # LogicoAnd
	| izquierda=expresion operador='||' derecha=expresion                           # LogicoOr
	| IDENTIFICADOR '[' expresion ']'                    							# AccesoArreglo
	| IDENTIFICADOR '[' indice=expresion ']' '=' valornuevo=expresion       		# AsignacionArreglo
	| IDENTIFICADOR '=' expresion                        							# AsignacionVariable
	| IDENTIFICADOR '+=' expresion                       							# AsignacionVariableSuma
	| IDENTIFICADOR '-=' expresion                       							# AsignacionVariableResta
	| BOOLEANO                                           							# Booleano
	| DECIMAL                                            							# Decimal
	| CARACTER                                           							# Caracter
	| CADENA                                             							# Cadena
	| ENTERO                                             							# Entero
	| IDENTIFICADOR                                      							# Identificador
	| '(' expresion ')'                                  							# Parentesis
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
CARACTER: '\'' . '\'';

IDENTIFICADOR: [_a-zA-Z][_a-zA-Z0-9]*;

WS: [ \t\r\n]+ -> skip;
COMENTARIOL: '//' ~[\r\n]* -> skip;
COMENTARIOLN: '/*' .*? '*/' -> skip;