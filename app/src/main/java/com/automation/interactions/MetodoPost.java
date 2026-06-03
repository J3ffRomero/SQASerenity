package com.automation.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;



public class MetodoPost extends RestInteraction{

    private final String resource;

    public MetodoPost(String resource) {
        this.resource = resource;
    }


    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().post(as(actor).resolve(this.resource)).then().log().all();
    }


    public static MetodoPost to(String resource) {
        return instrumented(MetodoPost.class, resource);
    }
}
