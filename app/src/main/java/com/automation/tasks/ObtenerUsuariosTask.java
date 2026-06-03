package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.automation.interactions.MetodoGet;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ObtenerUsuariosTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoGet.to("/users")
                        .with(request -> request
                                .header("Authorization",
                                        "Bearer ecf1c46e8359fbdbff14869ac8a7880b99d6b1564e9675843e6665d0061ba199")
                                .header("Content-Type", "application/json")
                                .log().all()));
    }

    public static ObtenerUsuariosTask lista() {
        return instrumented(ObtenerUsuariosTask.class);
    }
}
