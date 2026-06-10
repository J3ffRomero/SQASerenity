package com.automation.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class MetodoGet extends RestInteraction {

    private final String resource;


    public MetodoGet(String resource) {
        this.resource = resource;
    }

    @Step("{0} executes a GET on the resource #resource") //Ayuda a generar el reporte de serenity
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(this.resource)).then().log().all();
    }
    //crea la peticion con base a los datos enviados, crea los logs y también crea los logs de la respuesa

    //Ayuda a instanciar la clase, hacer la inyención de dependencias y hacer el seguimiento de Serenity
    public static MetodoGet to(String resource) {
        return instrumented(MetodoGet.class, resource);
    }

}
