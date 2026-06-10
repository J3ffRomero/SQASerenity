package com.automation.features;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.automation.questions.RespuestaCode;
import com.automation.tasks.EliminarUsuarioTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import net.thucydides.model.util.EnvironmentVariables;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

@ExtendWith(SerenityJUnit5Extension.class)
public class EliminarUsuarioTest extends BaseTest{
    private EnvironmentVariables enviromentVariables;
    private Actor david = new Actor("David");

    @BeforeEach
    public void setup(){
        String baseURL = EnvironmentSpecificConfiguration.from(enviromentVariables).getProperty("webdriver.base.url");
        david.can(CallAnApi.at(baseURL));
    }

    @Test
    public void eliminarUsuario(){
        david.attemptsTo(EliminarUsuarioTask.eliminarUsuario(8499443));
        david.should(seeThat("El código resultante fue 204", RespuestaCode.es(), is(204)));
    }
}
