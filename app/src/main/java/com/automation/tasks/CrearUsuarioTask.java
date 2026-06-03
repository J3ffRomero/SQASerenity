package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.automation.model.request.PersonaRequest;
import com.automation.interactions.MetodoPost;


public class CrearUsuarioTask implements Task {
    private final PersonaRequest payload;

    public CrearUsuarioTask(PersonaRequest payload) {
        this.payload = payload;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoPost.to("/users")
                        .with(request->request
                                .header("Authorization", "Bearer ecf1c46e8359fbdbff14869ac8a7880b99d6b1564e9675843e6665d0061ba199")
                                .header("Content-Type", "application/json")
                                .body(payload)
                                .log().all())
        );
    }

    public static CrearUsuarioTask conDatos(PersonaRequest payload) {
        return instrumented(CrearUsuarioTask.class, payload);
    }
}