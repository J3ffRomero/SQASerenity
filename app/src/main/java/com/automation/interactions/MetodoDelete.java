package com.automation.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class MetodoDelete extends RestInteraction {

    private final String resource;

    public MetodoDelete(String resource) {
        this.resource = resource;
    }


    @Step("{0} executes a DELETE on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().delete(as(actor).resolve(this.resource)).then().log().all();
    }


    public static MetodoDelete to(String resource) {
        return instrumented(MetodoDelete.class, resource);
    }
}
