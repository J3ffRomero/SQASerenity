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

    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(this.resource)).then().log().all();
    }

    public static MetodoGet to(String resource) {
        return instrumented(MetodoGet.class, resource);
    }

}
