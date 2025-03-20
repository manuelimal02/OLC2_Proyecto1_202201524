```json
    grammar Language;
```

##  ======= PROGRAMA =======
```json
program: declaraciones*;

declaraciones: 
      declaracion_funciones
    | declaracion_matriz
    | declaracion_arreglo 
    | declaracion_variable
    | declaracion_struct
    | sentencia
    ;
```
## ======= DECLARACIONES =======

### --- Variables ---
```json
declaracion_variable: 
      'var' IDENTIFICADOR TIPO '=' expresion (';')?
    | 'var' IDENTIFICADOR TIPO (';')?
    | IDENTIFICADOR ':=' expresion (';')?
    ;
```
### --- Arreglos ---
```json
declaracion_arreglo: 
      IDENTIFICADOR ':=' expresion
    | 'var' IDENTIFICADOR '[' ']' TIPO  (';')?
    ;
```
### --- Matrices ---
```json
declaracion_matriz : 
      IDENTIFICADOR ':=' dimensiones TIPO contenido_matriz (';')?
    ;

dimensiones : '[' ']' dimensiones?;

contenido_matriz : '{' elementos_matriz? '}';

elementos_matriz : elemento_matriz (',' elemento_matriz)* ','?;

elemento_matriz: 
      contenido_matriz 
    | lista_valores
    ;

lista_valores: '{' (expresion (',' expresion)* ','?)? '}';
```
### --- Funciones ---
```json
declaracion_funciones: 
    'func' IDENTIFICADOR '(' parametros? ')' TIPO? '{' declaraciones* '}';

parametros: IDENTIFICADOR ('[' ']')? tipo_funcion (',' IDENTIFICADOR ('[' ']')? tipo_funcion)*;

tipo_funcion: 
      TIPO
    | IDENTIFICADOR
    ;
```
### --- Structs ---
```json
declaracion_struct: 
    'type' IDENTIFICADOR 'struct' '{' atributos* '}';

atributos: IDENTIFICADOR tipo_struct (';')? (IDENTIFICADOR tipo_struct (';')?)*;

tipo_struct: 
      TIPO
    | IDENTIFICADOR
    ;
```
## ======= SENTENCIAS =======
```json
sentencia: 
      expresion (';')?
    | 'fmt.Println(' (expresion (',' expresion)*)? ')' (';')?
    | '{' declaraciones* '}'
    | 'if' ('(' condicion=expresion ')' | condicion=expresion) sentencia ('else' sentencia)?
    | 'switch' ('(' condicion=expresion ')' | condicion=expresion) '{' casos_switch* default_switch? '}'
    | 'for' ('(' condicion=expresion ')' | condicion=expresion) sentencia
    | 'for' for_init condicion=expresion ';' incremento=expresion sentencia
    | 'for' indice=IDENTIFICADOR ',' valor=IDENTIFICADOR ':=' 'range' slice=IDENTIFICADOR sentencia
    | 'break' (';')?
    | 'continue' (';')?
    | 'return' expresion? (';')?
    ;

casos_switch: 'case' expresion ':' declaraciones*;

default_switch: 'default' ':' declaraciones*;

for_init: 
      declaracion_variable 
    | expresion
    ;
```
## ======= EXPRESIONES =======
```json
expresion:
      'append(' IDENTIFICADOR ',' expresion ')' (';')?
    | 'strconv.Atoi(' expresion ')' (';')?
    | 'strconv.ParseFloat(' expresion ')' (';')?
    | 'reflect.TypeOf(' expresion ')' (';')?
    | 'slices.Index(' IDENTIFICADOR ',' expresion ')' (';')?
    | 'strings.Join(' IDENTIFICADOR ',' expresion ')' (';')?
    | 'len(' IDENTIFICADOR (('[' expresion ']')*) ')' (';')?
    | operador='-' izquierda=expresion
    | expresion llamada+ (';')?
    | operador='!' izquierda=expresion
    | izquierda=expresion operador=('*' | '/' | '%') derecha=expresion
    | izquierda=expresion operador=('+' | '-') derecha=expresion
    | izquierda=expresion operador=('<' | '<=' | '>' | '>=') derecha=expresion
    | izquierda=expresion operador=('==' | '!=') derecha=expresion
    | izquierda=expresion operador='&&' derecha=expresion
    | izquierda=expresion operador='||' derecha=expresion
    | IDENTIFICADOR ('[' expresion ']')+
    | IDENTIFICADOR '[' expresion ']'
    | IDENTIFICADOR ('.' IDENTIFICADOR)+
    | IDENTIFICADOR ('.' IDENTIFICADOR)+ '=' expresion
    | IDENTIFICADOR '[' indice=expresion ']' '=' valornuevo=expresion
    | IDENTIFICADOR ('[' expresion ']')+ '=' valornuevo=expresion
    | IDENTIFICADOR '=' expresion
    | IDENTIFICADOR '++'
    | IDENTIFICADOR '--'
    | IDENTIFICADOR '+=' expresion
    | IDENTIFICADOR '-=' expresion
    | BOOLEANO
    | DECIMAL
    | CARACTER
    | CADENA
    | ENTERO
    | 'nil'
    | IDENTIFICADOR
    | '(' expresion ')'
    | IDENTIFICADOR '{' atributos_instancia '}' (';')?
    | '[' ']' TIPO '{' (expresion (',' expresion)*) '}' (';')?
    ;

atributos_instancia: IDENTIFICADOR ':' expresion (',' IDENTIFICADOR ':' expresion)*;

llamada: '(' argumento? ')';

argumento: expresion (',' expresion)*;
```
## ======= TOKENS =======
```json
TIPO: 'int' | 'float64' | 'string' | 'bool' | 'rune';

ENTERO: [0-9]+;

DECIMAL: [0-9]+ '.' [0-9]+;

CADENA: '"' (ESCAPE | ~["\\])* '"';

ESCAPE: '\\' ["\\nrt];

BOOLEANO: 'true' | 'false';

CARACTER: '\'' . '\'';

IDENTIFICADOR: [_a-zA-Z][_a-zA-Z0-9]*;
```
## ======= ESPACIOS Y COMENTARIOS =======
```json
WS: [ \t\r\n]+ -> skip;

COMENTARIOL: '//' ~[\r\n]* -> skip;

COMENTARIOLN: '/*' .*? '*/' -> skip;
```