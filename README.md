# 🚀 Módulo CRUD con TDD
Implementación de operaciones CRUD en Java aplicando el enfoque **TDD (Test Driven Development)**. 
Incluye pruebas unitarias, uso de mocks y medición de cobertura de código superior al 80%.

## 📋 Características principales
- ✅ Operaciones CRUD: Crear, Leer, Actualizar y Eliminar
- 🔍 Validaciones robustas: nulos, duplicados, reglas de negocio
- 🧪 Pruebas unitarias con JUnit 5
- 🧩 Simulación de dependencias con Mockito
- 📊 Cobertura de código con JaCoCo: **84%**
- 🧼 Diseño limpio basado en principios SOLID

## 🛠 Tecnologías utilizadas
- **Java 17**
- **JUnit 5** – pruebas unitarias
- **Mockito** – mocking de dependencias
- **JaCoCo** – cobertura de código
- **Maven** – gestión de dependencias

## ▶️ Cómo ejecutar el proyecto

### Prerrequisitos

- IDE recomendado: **IntelliJ IDEA**
- **JDK 17** instalado
### Pasos para ejecución:

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA
3. Ejecutar las pruebas desde:
   - La clase `PersonaDAOTest.java`
   - O usando los iconos ▶️ en cada método de prueba


✅ **Métricas cumplidas**

| Requisito             | Mínimo | Implementado |
|-----------------------|--------|--------------|
| Cobertura (JaCoCo)    | 80%    | 84%          |
| Pruebas unitarias     | 8–16   | 16           |
| Ciclos TDD completos  | 12     | 12+          |
| Refactorizaciones     | 3      | 4            |
| Mocking (Mockito)     | 1      | 1            |


## 📂 Estructura del proyecto

- proyecto-tdd/
  - src/
    - main/java/com/renata/tdd/
      - Persona.java
      - PersonaDAO.java
      - PersonaRepository.java
      - PersonaListRepository.java
    - test/java/com/renata/tdd/
      - PersonaDAOTest.java
  - target/site/jacoco/
    - index.html
    - jacoco.xml
  - pom.xml

