QASerenity

Este proyecto basado en JAVA, tiene como finalidad ejecutar pruebas de SQA a un CRUD (CREATE, READ, UPDATE, DELETE), más específicamente a una API, para poder empezar a entender el mundo de la automatización de pruebas de software.

Tecnologías
Lenguaje: Java JDK21
Herramientas: GitHub, Gradle, Serenity, JUnit, ScreenPlay y goRest para el API
IDE: Intellij y Antigravity


Instalación

1. Clonar el repositorio: "git clone https://github.com/J3ffRomero/SQASerenity"
2. Abrir el IDE deseado (Antigravity)
3. Asegurarse de estar haciendo uso de la misma API
4. Asegurarse de cambiar el token Bearer de la API
5. Ejecutar las pruebas (Tener en cuenta el ID de los usuarios para la eliminación y actualización, ya que esto puede generar errores).

Ejecución de pruebas
* Para ejecutar las pruebas, se debe usar el comando "./gradlew clean test" para obtener un reporte detallado de la ejecución de las pruebas sin generar el index

* Para ejecutar las pruebas y generar el informe index, ejecutar el comando "./gradlew clean test aggregate"

* Para ejecutar las pruebas en un ambiente diferente al predeterminado utiliza el siguente comando " ./gradlew test aggregate -Denvironment=qa "

* Si hay casos fallidos, el reporte generado será en la ruta "../app/build/reports/tests/test/index.html"

* El informe general del index, será generado en la ruta "..app/target/site/serenity/index.html"