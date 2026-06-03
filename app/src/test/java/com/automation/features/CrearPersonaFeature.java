package com.automation.features;

import org.junit.jupiter.api.extension.ExtendWith;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.automation.tasks.CrearUsuarioTask;
import com.automation.questions.RespuestaCode;
import com.automation.model.request.PersonaRequest;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.is;
import com.automation.model.factories.PersonFactory;

import static org.hamcrest.Matchers.equalTo;
import com.automation.questions.RespuestaBody;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

@ExtendWith(SerenityJUnit5Extension.class)

public class CrearPersonaFeature extends BaseTest {

    private EnvironmentVariables enviromentVariables;
    private Actor david = new Actor("David");

    @BeforeEach
    public void setup() {
        String baseURL = EnvironmentSpecificConfiguration.from(enviromentVariables).getProperty("webdriver.base.url");
        david.can(CallAnApi.at(baseURL));
    }

    @Test
    public void crearPersona() {
        PersonaRequest infoPersona = PersonFactory.crearPersona();

        david.attemptsTo(CrearUsuarioTask.conDatos(infoPersona));

        // Asercion
        david.should(
                seeThat("El código de respuesta es 201", RespuestaCode.es(), is(201)),
                seeThat("El nombre en la respuesta es correcto",
                        actor -> RespuestaBody.es().answeredBy(actor).getPersonName(), equalTo(infoPersona.getName())));
    }
}