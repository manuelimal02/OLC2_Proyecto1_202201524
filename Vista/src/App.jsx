import { useState } from 'react';
import './App.css';
import { Editor } from "@monaco-editor/react";


function App() {
  const [Entrada, setEntrada] = useState('');
  const [Salida, setSalida] = useState('');

  const handleExecute = () => {
    setSalida('');
    fetch("http://localhost:5077/Controlador/Compilar", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ code: Entrada }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Respuesta:", data);
        setSalida(data?.result || data?.error);
      })
      .catch((error) => {
        console.error("Error:", error);
        setSalida(`Error: ${error.message}`);
      });
  };

  const handleDownloadTablaSimbolos = async () => {
    try {
      const response = await fetch("http://localhost:5077/Controlador/DescargarReporteTabla");
  
      if (!response.ok) {
        const errorData = await response.json();
        setSalida(`Error Al Descargar La Tabla De Símbolos: ${errorData?.error}`);
        return;
      }
  
      const blob = await response.blob();
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement("a");
      a.href = url;
      a.download = "TablaSimbolos.html";
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
    } catch (error) {
      alert("Error al descargar la tabla de símbolos.");
    }
  };

  const handleDownloadTablaErrores = async () => {
    try {
      const response = await fetch("http://localhost:5077/Controlador/DescargarReporteErrores");
      if (!response.ok) {
        const errorData = await response.json();
        setSalida(`Error Al Descargar La Tabla De Errores: ${errorData?.error}`);
        return;
      }
  
      const blob = await response.blob();
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement("a");
      a.href = url;
      a.download = "TablaErrores.html";
      document.body.appendChild(a);
      a.click();
      document.body.removeChild(a);
    } catch (error) {
      alert("Error al descargar la tabla de errores.");
    }
  };

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
              <button id="TablaErrores" onClick={handleDownloadTablaErrores}>Tabla De Errores</button>
              <button id="TablaSimbolos" onClick={handleDownloadTablaSimbolos}>Tabla De Símbolos</button>
              <button id="ReporteAST">Reporte de AST</button>
            </div>
          </div>

          <div className="nav-button">
            <button id="analizaEntrada" onClick={handleExecute}>Ejecutar</button>
          </div>
        </div>
      </div>
      
      <div style={{ flex: 1, display: 'flex', flexDirection: 'column' }}>
        {}
        <div className="container-entrada">
          <Editor 
            height="500px" 
            defaultLanguage="go" 
            theme='vs-dark'
            value={Entrada}
            onChange={(value) => setEntrada(value || '')}
          />
        </div>
        
        {}
        <div className="container-salida">
          <textarea 
            id="txtAreaSalida" 
            readOnly 
            placeholder="Salida"
            value={Salida}
          ></textarea>
        </div>
      </div>
    </div>
  );
}

export default App;