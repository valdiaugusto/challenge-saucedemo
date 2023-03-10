package servicesTests;

import io.qameta.allure.*;

import static io.restassured.RestAssured.*;

import listeners.StepReporterEventListener;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Epic("Departamentos Mercado Libre")
@Feature("Departamentos - Tecnologia - Mercado Libre")
public class DepartamentosMercadoLibreTest {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(StepReporterEventListener.class));
    private List<String> listaDepartamentos  = new ArrayList<>();
    private List<String> validacionDepartamentos = new ArrayList<>();

    @Test(description = "Servicios Mercado Libre - Departamentos")
    @Description("Se prueba la respuesta del servicio web de Mercado Libre de Departamentos.")
    public void meliDepartamentosTecnologia() {
        listaDepartamentosTecnologia();
        baseURI = "https://www.mercadolibre.com.ar/menu";
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            String resultado =
                    given()
                            .when()
                                .get(baseURI + "/departments")
                            .then()
                                .statusCode(HttpStatus.SC_OK)
                                .extract()
                                .path("departments[0].categories[" + i + "].name");
            validacionDepartamentos.add(resultado);
            reporteDepartamento(listaDepartamentos.get(i), resultado);
            LOGGER.info("El departamento obtenido '" + resultado + "' coincide con el designado a validar : " + listaDepartamentos.get(i));
        }
        Assert.assertEquals(listaDepartamentos.size(), validacionDepartamentos.size(), "La cantidad de departamentos '" + listaDepartamentos.size() + "' no coincide con los validados '" + validacionDepartamentos.size() + "'");
    }

    public void listaDepartamentosTecnologia() {
        listaDepartamentos.add("Celulares y Tel??fonos");
        listaDepartamentos.add("Computaci??n");
        listaDepartamentos.add("C??maras y Accesorios");
        listaDepartamentos.add("Electr??nica, Audio y Video");
        listaDepartamentos.add("Consolas y Videojuegos");
        listaDepartamentos.add("Televisores");
    }

    @Step("Se prueba la respuesta del departamento {dpto} con el resultado obtenido {resultado}")
    private void reporteDepartamento(String dpto, String resultado) {
        Assert.assertEquals(dpto, resultado, "El resultado del departamento '" + resultado + "' no coincide con '" + dpto + "' de la validaci??n");
    }
}
