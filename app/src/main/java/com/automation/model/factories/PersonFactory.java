package com.automation.model.factories;

import com.automation.model.request.PersonaRequest;
import com.github.javafaker.Faker;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFactory {

    private static final Faker fakerData = new Faker();
    
    public static PersonaRequest crearPersona() {
        return PersonaRequest.builder()
                .name(fakerData.name().firstName())
                .email(fakerData.internet().emailAddress())
                .gender(fakerData.options().option("Male", "Female"))
                .status(fakerData.options().option("active", "inactive"))
                .build();
    }

    public static PersonaRequest personaSinDatos(){
        return PersonaRequest.builder()
                .name("")
                .email("")
                .gender("")
                .status("")
                .build();
    }
}
