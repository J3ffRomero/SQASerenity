package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.thucydides.model.util.EnvironmentVariables;
import com.automation.interactions.MetodoPut;

public class ActualizarUsuarioTask implements Task {
    private final Integer usuarioID;
    private final Object usuario;
    private EnvironmentVariables enviromentVariables;

    public ActualizarUsuarioTask(Integer usuarioID, Object usuario) {
        this.usuarioID = usuarioID;
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoPut.to("/users/" + usuarioID)
                        .with(request -> request
                                .header("Authorization", "Bearer " + enviromentVariables.getProperty("token"))
                                .header("Content-Type", "application/json")
                                .body(usuario)));
    }

    public static ActualizarUsuarioTask actualizar(Object usuario, Integer usuarioID) {
        return instrumented(ActualizarUsuarioTask.class, usuarioID, usuario);
    }
}
