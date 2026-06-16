package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.automation.interactions.MetodoGet;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.thucydides.model.util.EnvironmentVariables;

public class ObtenerUsuariosTask implements Task {

    private EnvironmentVariables enviromentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoGet.to("/users")
                        .with(request -> request
                                .header("Authorization",
                                        "Bearer " + enviromentVariables.getProperty("token"))
                                .header("Content-Type", "application/json")));
    }

    public static ObtenerUsuariosTask obtenerUsuarios() {
        return instrumented(ObtenerUsuariosTask.class);
    }
}
