
# Manual de Usuario

## 1. Introducción

Este manual de usuario proporciona una guía para utilizar el entorno de desarrollo de GoLight, que permite escribir, editar y ejecutar código en el lenguaje GoLight.

## 2. Instalación

### 2.1. Requisitos del Sistema

- **Sistema Operativo**: Linux.
- **Dependencias**: .NET Core, ANTLR.

### 2.2. Pasos de Instalación

1. Clonar el repositorio del proyecto desde GitHub.
2. Instalar las dependencias necesarias.
3. Compilar el proyecto utilizando .NET Core.

## 3. Uso del Entorno de Desarrollo

### 3.1. Editor de Código

- **Crear un Nuevo Archivo**: Seleccione "Nuevo Archivo" desde el menú principal.
- **Abrir un Archivo Existente**: Seleccione "Abrir Archivo" y elija un archivo `.git`.
- **Guardar Archivo**: Seleccione "Guardar" para guardar el archivo actual.

### 3.2. Ejecución del Código

1. Escriba o cargue el código en el editor.
2. Haga clic en el botón "Ejecutar" para iniciar el análisis y ejecución del código.
3. Los resultados se mostrarán en la consola.

### 3.3. Consola

La consola muestra:
- Resultados de la ejecución.
- Errores y advertencias.
- Mensajes de depuración.

### 3.4. Reportes

- **Reporte de Errores**: Muestra los errores encontrados durante el análisis.
- **Reporte de Tabla de Símbolos**: Muestra las variables y funciones declaradas.
- **Reporte de AST**: Muestra el Árbol de Sintaxis Abstracta generado.

## 4. Ejemplos de Código

### 4.1. Hola Mundo

```go
func main() {
    fmt.Println("Hola, Mundo!")
}
```

### 4.2. Suma de Dos Números

```go
func main() {
    a := 5
    b := 10
    resultado := a + b
    fmt.Println("La suma es:", resultado)
}
```

## 5. Solución de Problemas

### 5.1. Errores Comunes

- **Error Léxico**: Caracteres no válidos en el código.
- **Error Sintáctico**: Estructura del código incorrecta.
- **Error Semántico**: Uso incorrecto de tipos o variables no declaradas.

### 5.2. Cómo Reportar Errores

Si encuentra un error, revise el **Reporte de Errores** para obtener más detalles sobre la causa y la ubicación del error.
