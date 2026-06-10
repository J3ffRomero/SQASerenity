package com.automation.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import com.automation.interactions.MetodoDelete;
import net.thucydides.model.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarUsuarioTask implements Task {
    private final int usuarioID;
    private EnvironmentVariables enviromentVariables;

    public EliminarUsuarioTask(int usuarioID){
        this.usuarioID = usuarioID;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MetodoDelete.to("/users/" + usuarioID)
                        .with(request->request
                                .header("Authorization", "Bearer " + enviromentVariables.getProperty("token"))
                                .log().all())
        );
    }

    public static EliminarUsuarioTask eliminarUsuario(int usuarioID){
        return instrumented(EliminarUsuarioTask.class, usuarioID);
    }
}
