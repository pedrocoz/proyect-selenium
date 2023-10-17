# Proyecto con Selenium WebDriver y Cucumber

## Pre-requisitos
1. Instalar el Java 8 y configurar la variable de entorno.
2. Instalar el Maven > 3.8... y configurar la variable de entorno.
3. Descargar el chromeDriver de acuerdo a tu browser, enlace [chromeDriver](https://googlechromelabs.github.io/chrome-for-testing/).
4. En la carpeta resources agregar la carpeta drivers, dentro de ella agregar el driver a usar (preferencia ChromeDriver).
![Imagen referencial](https://github.com/carlosqaautomation/template-selenium/blob/proyecto-curso/img/driver.png)

## Comandos
1. Comando inicial para descargar las dependencias del proyecto
```
mvn clean package
```
2. Comando para ejecutar los test Case mediante tags
```
mvn test '-Dcucumber.filter.tags="@tags"'
```

