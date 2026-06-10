package com.automation.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.automation.model.factories.PersonFactory;
import com.automation.model.request.PersonaRequest;
import com.automation.questions.RespuestaCode;
import com.automation.questions.RespuestaBody;
import com.automation.tasks.ActualizarUsuarioTask;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

@ExtendWith(SerenityJUnit5Extension.class)

public class ActualizarUsuarioFeature extends BaseTest {
    private EnvironmentVariables enviromentVariables;
    private Actor david = new Actor("David");

    @BeforeEach
    public void setup() {
        String baseURL = EnvironmentSpecificConfiguration.from(enviromentVariables).getProperty("webdriver.base.url");
        david.can(CallAnApi.at(baseURL));
    }

    @Test
    public void actualizarUsuarioMethod() {
        PersonaRequest persona = PersonFactory.crearPersona();
        david.attemptsTo(ActualizarUsuarioTask.actualizar(persona, 8499444));

        david.should(seeThat("El codigo fue 200", RespuestaCode.es(), is(200)),
                seeThat("El nombre nuevo del usuario es: ",
                        actor -> RespuestaBody.es().answeredBy(actor).getPersonName(), equalTo(persona.getName())));
    }
}
