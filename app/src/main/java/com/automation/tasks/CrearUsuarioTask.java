package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.automation.model.request.PersonaRequest;
import com.automation.interactions.MetodoPost;

public class CrearUsuarioTask implements Task {
    private final PersonaRequest payload;
    private EnvironmentVariables enviromentVariables;

    public CrearUsuarioTask(PersonaRequest payload) {
        this.payload = payload;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoPost.to("/users")
                        .with(request -> request
                                .header("Authorization", "Bearer " + enviromentVariables.getProperty("token"))
                                .header("Content-Type", "application/json")
                                .body(payload)));
    }

    public static CrearUsuarioTask conDatos(PersonaRequest payload) {
        return instrumented(CrearUsuarioTask.class, payload);
    }
}