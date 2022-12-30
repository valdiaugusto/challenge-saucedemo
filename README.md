# Instrucciones de uso
 * Tener instalado Java JDK 16 
 * Descargar gradle desde 
        <pre>https://gradle.org/install/ </pre>
 * Clonar el repositorio
 * En la carpeta del proyecto, ejecutar los comandos:
    ## Ejecucion
    ### Driver
    - Para tener actualizado el driver de chrome y firefox, descargar la version estable de la version de navegador desde
            <pre>
            https://chromedriver.chromium.org/
            https://github.com/mozilla/geckodriver/releases
            </pre>
    - Ubicar los drivers en la carpeta 'resources'        
    ### Web
    - Build del proyecto 
            <pre>
            ./gradlew build
            </pre>
    - Para la ejecucion de los tests por navegador agregar -DtipoNavegador con la opcion del navegador
            <pre>
            ./gradlew clean TestTask -DtipoNavegador="chrome"
            ./gradlew clean TestTask -DtipoNavegador="firefox"
            </pre>
    - Para la ejecucion de los tests por clase agregar --tests "Clase", tambien se puede especificar por ticket --tests "Clase.*Ticket"
            <pre>
            ./gradlew clean TestTask -DtipoNavegador="chrome" --tests "LoginTest" 
            ./gradlew clean TestTask -DtipoNavegador="chrome" --tests "ProductsTest" 
            ./gradlew clean TestTask -DtipoNavegador="chrome" --tests "LoginTest.*SDEMO_001"
            </pre>
    ### Servicios
    - Para la ejecucion del test de servicios 
            <pre>
            ./gradlew clean TestTask --tests "DepartamentosMercadoLibreTest"
            </pre>
    ## Reportes
    - Descargar allure
            <pre>
            ./gradlew downloadAllure
            </pre>
    - Luego, se ejecuta allureServe que abrira el reporte en el navegador web
            <pre>
            ./gradlew allureServe
            </pre>
    - Para detener la ejecucion de allure presionar Ctrl+C
 
**_NOTA:_** para limpiar la ejecucion se debe agregar 'clean' delante de TestTask
 
