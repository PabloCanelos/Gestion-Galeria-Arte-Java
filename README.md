# Gestion-Galeria-Arte-Java

Sistema profesional de gestión para galerías de arte, diseñado con un enfoque en arquitectura robusta, patrones de diseño y persistencia de datos relacional.

## Características Técnicas
* **Arquitectura:** Basada en Programación Orientada a Objetos (POO) avanzada.
* **Patrones de Diseño:** * **Singleton:** Implementado para la gestión de la conexión a la base de datos MySQL.
    * **Singleton de Validación:** Estándar profesional para la validación de integridad de clases completas antes de la persistencia.
* **Base de Datos:** MySQL con integridad referencial completa (PK/FK).
* **Seguridad:** Encapsulamiento total mediante atributos privados y acceso controlado.

##  Estructura del Proyecto
* `src/model`: Clases de entidad (Galeria, Cuadro, Critico, Evaluacion).
* `src/database`: Lógica de conexión mediante patrón Singleton.
* `src/validation`: Validadores de negocio centralizados.
* `sql/`: Scripts de creación y migración de la base de datos.

##  Diseño de Base de Datos
El sistema utiliza un esquema relacional normalizado que garantiza la consistencia de la información entre las galerías, las obras de arte y las evaluaciones de los críticos.

---
*Proyecto en desarrollo como parte de mi formación académica en Ingeniería y preparación para Machine Learning.*
