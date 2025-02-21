import { useState } from 'react'
import './App.css'
import { Editor } from "@monaco-editor/react";

function App() {
  return (
    <div className="container">
      <div className="navbar">
        <div className="title">
          <h1>GoLight - Proyecto 1</h1>
        </div>
        
        <div className="nav-section">
          <div className="nav-item">
            <h2>Archivo</h2>
            <div className="dropdown-content">
              <button id="AbrirArchivo">Abrir Archivo</button>
              <button id="CrearArchivo">Crear Archivo</button>
              <button id="GuardarArchivo">Guardar Archivo</button>
            </div>
          </div>

          <div className="nav-item">
            <h2>Reportes</h2>
            <div className="dropdown-content">
              <button id="TablaErrores">Tabla De Errores</button>
              <button id="TablaSimbolos">Tabla de Símbolos</button>
              <button id="ReporteAST">Reporte de AST</button>
            </div>
          </div>

          <div className="nav-button">
            <button id="analizaEntrada">Ejecutar</button>
          </div>
        </div>
      </div>
      
      {}
      <div style={{ flex: 1, display: 'flex', flexDirection: 'column' }}>
        <div className="container-entrada">
          <Editor height="500px" defaultLanguage="golang" />
        </div>
        
        <div className="container-salida">
          <textarea id="txtAreaSalida" readOnly placeholder="Salida"></textarea>
        </div>
      </div>
    </div>
  );
}

export default App
