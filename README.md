# auto-api-placeholder
> Automatización de API con Screenplay, Serenity, REST, Cucumber y Gradle. Pruebas automatizadas con informes completos y fácil mantenimiento.


## Requerimientos
- Java
- JDK 17
- Graddle

## Versiones

serenityCoreVersion = "3.3.10"

## Instalacion

```
gradle build
```

## Estructura del proyecto

Patron de diseño Screnplay usando serenity BDD

- StepdefinitionSetup: Configuracion inicial

```
src/test/java/stepdefinition/setupConfiguration.java
```
- Features: Escnarios de pruebas
````
src/test/resources/features
````
- Runners: Clases utilizadad para ejecutar los escenarios de pruebas utiliazando cucumber
````
src/test/java/runners
````
- Task: Logica del comportamiento
```
src/main/java/task
```

- Question: Logica de aserciones.
````
src/main/java/question
````
# Run Test

## Run Regression Testing


- Ejecucion de feature posts.
> 2 caso de prueba, duración aproximada de la ejecución ⏱️ 28 segundos.

**Env Testing**

````
gradle :regression --tests "runners.PostRunner" :aggregate -Denv=testing
````

````
gradle :regression --tests "runners.PostRunner" :reports -Denv=testing
````


## Ver reportes

> :report
```
/auto-api-testing/target/site/serenity/serenity-summary.html
```

> :aggregate
```
/auto-api-testing/target/site/serenity/index.html
```

