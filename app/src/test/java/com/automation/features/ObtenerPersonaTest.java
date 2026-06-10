package com.automation.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.automation.questions.RespuestaCode;
import com.automation.tasks.ObtenerUsuariosTask;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import net.thucydides.model.util.EnvironmentVariables;

@ExtendWith(SerenityJUnit5Extension.class) //Extensión de Serenity para JUnit 5 que permite ejecutar pruebas de Serenity

public class ObtenerPersonaTest extends BaseTest {
    private EnvironmentVariables enviromentVariables;
    private Actor david = new Actor("David");

    @BeforeEach
    public void setup() {
        String baseURL = EnvironmentSpecificConfiguration.from(enviromentVariables).getProperty("webdriver.base.url");
        david.can(CallAnApi.at(baseURL));
    }

    @Test
    public void obtenerPersonas() {
        david.attemptsTo(ObtenerUsuariosTask.obtenerUsuarios());
        david.should(seeThat("El código de respuesta es 200", RespuestaCode.es(), is(200)));

        List<String> listaPersonas = SerenityRest.lastResponse().jsonPath().getList("id");
        System.out.println("Cantidad Usuarios encontrados: " + listaPersonas.size());
    }
}