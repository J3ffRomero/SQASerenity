package com.automation.features;

import net.serenitybdd.rest.SerenityRest;

public class BaseTest {
    static {
        SerenityRest.useRelaxedHTTPSValidation();
    }
    //Ayuda a saltar el error de certificado SSL, permitiendo la ejecución de pruebas en sitios no seguros
}
