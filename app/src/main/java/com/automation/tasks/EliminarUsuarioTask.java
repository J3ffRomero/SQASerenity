package com.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.automation.interactions.MetodoDelete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuarioTask implements Task {
    private final int usuarioID;

    public EliminarUsuarioTask(int usuarioID){
        this.usuarioID = usuarioID;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoDelete.to("/users/" + usuarioID)
                        .with(request->request
                                .header("Authorization", "Bearer " + "ecf1c46e8359fbdbff14869ac8a7880b99d6b1564e9675843e6665d0061ba199")
                                .log().all())
        );
    }

    public static EliminarUsuarioTask eliminarUsuario(int usuarioID){
        return instrumented(EliminarUsuarioTask.class, usuarioID);
    }
}
