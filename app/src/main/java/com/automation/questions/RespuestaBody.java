package com.automation.questions;

import net.serenitybdd.screenplay.Question;
import com.automation.model.response.PersonaResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;


public class RespuestaBody implements Question<PersonaResponse>{
    
    @Override
    public PersonaResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(PersonaResponse.class);
    }
    
    public static RespuestaBody es(){
        return new RespuestaBody();
    }
}
