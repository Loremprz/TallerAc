Agenda - Tabla de contenido.
- [Resumen ejecutivo](#resumen-ejecutivo)
- [Descripción](#descripción)
- [Problema identificado y solución](#problema-identificado-y-solución)
- [Arquitectura](#arquitectura)
- [Requerimientos](#requerimientos)
    - [Servidor de aplicación](#servidor-de-aplicación)
    - [Paquetes adicionales](#paquetes-adicionales)
    - [Versión de java](#versión-de-java)
- [Instalación](#instalación)
    - [¿Cómo ejecutar el archivo Jar?](#cómo-ejecutar-el-archivo-jar)
    - [¿Cómo instalar el ambiente de desarrollo?](#cómo-instalar-el-ambiente-de-desarrollo)
    - [¿Cómo ejecutar pruebas manualmente?](#cómo-ejecutar-pruebas-manualmente)
- [Configuración](#configuración)
- [Uso](#uso)
- [Contribución](#contribución)
- [Roadmap](#roadmap)


Descripción.
El proyecto consiste en el desarrollo de una aplicación en java para la gestión de datos de una tienda pequeña, que permite al usuario agendar y gestionar detalles sobre sus clientes y proveedores.

Problema identificado y solución.
Se desarrollo una aplicación de escritorio con java para que empresas pequeñas puedan gestionar los datos de sus clientes y proveedores de manera local, esto con el fin de reemplazar una agenda tradicional y ofrecer portabilidad.

Arquitectura.
La aplicación se desarrollo en Java 1.7 utilizando el IDE Eclipse además de la gestión de dependencias de Maven. Se integró una base de datos local con el uso de SQLite mientras que la interfaz se construyo con JFrames.

Requerimientos.
 - Servidor de aplicación:
    - Base de datos: SQLite 3.45.3.0
    - No se requiere un servidor ya que la aplicación es de escritorio.
 - Paquetes adicionales:
    - Maven 3.8.1
    - SQLite JDBC Driver 3.45.3.0
 - Versión de java
    -Java Development Kit (JDK) 1.7

Instalación.

 -¿Cómo ejecutar el archivo Jar?
  1.	Tener instalado java, mínimo 1.7
  2.	Abrir el archivo como se haría con un programa normal.
     
¿Cómo instalar el ambiente de desarrollo?
  1.	Descarga los archivos del branch develop.
  2.	Abre Eclipse e importa el proyecto.
  3.	Agrega en tus librerías los archivos .jar de la carpeta lib.
     
¿Cómo ejecutar pruebas manualmente?
  1.	Abrir el proyecto en Eclipse.
  2.	Ejecutar las pruebas necesarias.

Configuración.
  - Tener descargadas e importadas las librerías de la carpeta jar en el proyecto o copiar las dependencias de Maven en tu archivo ‘pom.xml’
  - Tener instalado JKD 1.7 (mínimo) en tu sistema.

Uso.
  - El usuario final puede descargar el archivo jar del Branch main.
  - El administrador puede descargar los archivos del proyecto en el Branch develop y seguir las instrucciones de instalación y Configuración.

Contribución.
  1.	Clonar el repositorio a tu máquina local.
     `git clone [URL]`
  2.	Crear un nuevo branch.
    - Crea un branch para trabajar sin afectar a la rama principal con el siguiente comando.
     `git checkout -b nombre-del-nuevo-branch`
  3.	Enviar el Pull Request.
    - Después de hacer los cambios en el branch haz el commit y envía un Pull Request.
  4.	Esperar el merge.
    - Una vez enviado el Pull Request se revisarán los cambios.

Roadmap.
  - Mejora en la interfaz de usuario.
  - Integración de gestión de productos y reportes de pedidos.
