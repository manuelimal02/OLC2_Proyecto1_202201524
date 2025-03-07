grammar Language;

program: declaraciones*;

declaraciones: declaracion_funciones
	| declaracion_matriz
	| declaracion_arreglo 
	| declaracion_variable
	| declaracion_struct
	| sentencia
	;

declaracion_variable: 'var' IDENTIFICADOR TIPO '=' expresion (';')? # DeclaracionExplicita
	| 'var' IDENTIFICADOR TIPO (';')?                               # DeclaracionPorDefecto
	| IDENTIFICADOR ':=' expresion (';')?                           # DeclaracionImplicita
	;

declaracion_arreglo: IDENTIFICADOR ':=' '[' ']' TIPO '{' (expresion (',' expresion)*) '}' (';')? 	# DeclaracionArregloExplicita
	| 'var' IDENTIFICADOR '[' ']' TIPO  (';')? 														# DeclaracionArregloPorDefecto
	;

declaracion_matriz : IDENTIFICADOR ':=' dimensiones TIPO contenido_matriz (';')?  # DeclaracionMatrizExplicita
    ;

dimensiones : '[' ']' dimensiones?
    ;

contenido_matriz : '{' elementos_matriz? '}'
    ;

elementos_matriz : elemento_matriz (',' elemento_matriz)* ','?
    ;

elemento_matriz: contenido_matriz 
    | lista_valores
    ;

lista_valores
    : '{' (expresion (',' expresion)* ','?)? '}'
    ;

declaracion_funciones: 'func' IDENTIFICADOR '(' parametros? ')' TIPO? '{' declaraciones* '}' 				# DeclaracionFuncion
	;

parametros: IDENTIFICADOR ('[' ']')? TIPO (',' IDENTIFICADOR ('[' ']')? TIPO)*
	;

declaracion_struct: 'struct' IDENTIFICADOR '{' atributos* '}'											# DeclaracionStruct
	;

atributos: tipo_struct IDENTIFICADOR (';')? (tipo_struct IDENTIFICADOR (';')? )*													
	;

tipo_struct: TIPO
	| IDENTIFICADOR
	;

sentencia: expresion (';')? 																				# ExpresionSentencia
	| 'fmt.Println(' (expresion (',' expresion)*)? ')' (';')?   											# FuncionEmbebidaPrintln
	| '{' declaraciones* '}' 																				# Bloque
	| 'if' ('(' condicion=expresion ')' | condicion=expresion) sentencia ('else' sentencia)? 				# SentenciaIf
	| 'switch' ('(' condicion=expresion ')' | condicion=expresion) '{' casos_switch* (default_switch)? '}' 	# SentenciaSwitch
	| 'for' ('(' condicion=expresion ')' | condicion=expresion) sentencia 									# SentenciaForSimple
	| 'for' for_init condicion=expresion ';' incremento=expresion sentencia 								# SentenciaForCompuesta
	| 'for' indice=IDENTIFICADOR ',' valor=IDENTIFICADOR ':=' 'range' slice=IDENTIFICADOR sentencia 		# SentenciaForRange
	| 'break' (';')? 																						# SentenciaBreak
	| 'continue' (';')? 																					# SentenciaContinue
	| 'return' expresion? (';')? 																			# SentenciaReturn
	;

casos_switch: 'case' expresion ':' declaraciones*; 														
default_switch: 'default' ':' declaraciones*; 	

for_init: declaracion_variable 
	| expresion
	;

expresion:
	'append(' IDENTIFICADOR ',' expresion ')' (';')?      							# FuncionEmbebidaAppend
 	| 'strconv.Atoi(' expresion ')' (';')?                  						# FuncionEmbebidaAtoi
	| 'strconv.ParseFloat(' expresion ')'(';')?             						# FuncionEmbebidaParseFloat
	| 'reflect.TypeOf(' expresion ')' (';')?                						# FuncionEmbebidaReflectTypeOf
	| 'slices.Index(' IDENTIFICADOR ',' expresion ')' (';')?                 		# FuncionEmbebidaSlicesIndex
	| 'strings.Join(' IDENTIFICADOR ',' expresion ')' (';')?   						# FuncionEmbebidaStringsJoin
	| 'len(' IDENTIFICADOR ')' (';')?                      							# FuncionEmbebidaLen
	| operador='-' izquierda=expresion                                         		# NegacionUnaria
	| expresion llamada+ (';')?                                                     # LlamadaFuncion
	| operador='!' izquierda=expresion                                       		# NegacionLogica
	| izquierda=expresion operador=('*' | '/' | '%') derecha=expresion              # MultiplicacionDivisionModulo
	| izquierda=expresion operador=('+' | '-') derecha=expresion                    # SumaResta
	| izquierda=expresion operador=('<' | '<=' | '>' | '>=') derecha=expresion      # Relacional
	| izquierda=expresion operador=('==' | '!=') derecha=expresion                  # IgualdadDesigualdad
	| izquierda=expresion operador='&&' derecha=expresion                           # LogicoAnd
	| izquierda=expresion operador='||' derecha=expresion                           # LogicoOr
	| IDENTIFICADOR ('[' expresion ']')+                                            # AccesoMatriz
	| IDENTIFICADOR '[' expresion ']'                    							# AccesoArreglo
	| IDENTIFICADOR ('.' IDENTIFICADOR)+                   							# AccesoStruct
	| IDENTIFICADOR '[' indice=expresion ']' '=' valornuevo=expresion       		# AsignacionArreglo
	| IDENTIFICADOR ('[' expresion ']')+ '=' valornuevo=expresion  					# AsignacionMatriz
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
	| IDENTIFICADOR  '{' atributos_instancia '}'	(';')?							# AsignacionInstancia
	;

atributos_instancia: IDENTIFICADOR ':' expresion (',' IDENTIFICADOR ':' expresion)* 
	;

llamada: '(' argumento? ')';

argumento: expresion (',' expresion)*;

TIPO: 'int' 	
	| 'float64' 
	| 'string' 
	| 'bool' 
	| 'rune'
	;	

ENTERO: [0-9]+;
DECIMAL: [0-9]+ '.' [0-9]+;
CADENA: '"' (ESCAPE | ~["\\])* '"';
ESCAPE: '\\' ["\\nrt];
BOOLEANO: 'true' | 'false';
CARACTER: '\'' . '\'';

IDENTIFICADOR: [_a-zA-Z][_a-zA-Z0-9]*;

WS: [ \t\r\n]+ -> skip;
COMENTARIOL: '//' ~[\r\n]* -> skip;
COMENTARIOLN: '/*' .*? '*/' -> skip;