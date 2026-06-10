package com.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.automation.interactions.MetodoPut;
import net.thucydides.model.util.EnvironmentVariables;


public class ActualizarUsuarioTask implements Task {
    private final int usuarioID;
    private final Object usuario;
    private EnvironmentVariables enviromentVariables;

    public ActualizarUsuarioTask(int usuarioID, Object usuario) {
        this.usuarioID = usuarioID;
        this.usuario = usuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.attemptsTo(
                MetodoPut.to("/users/"+usuarioID)
                        .with(request->request
                                .header("Authorization", "Bearer "+ enviromentVariables.getProperty("token"))
                                .header("Content-Type", "application/json")
                                .body(usuario)
                                .log().all())
        );
    }

    public static ActualizarUsuarioTask actualizar(Object usuario, int usuarioID){
        return instrumented(ActualizarUsuarioTask.class, usuarioID, usuario);
    }
}
