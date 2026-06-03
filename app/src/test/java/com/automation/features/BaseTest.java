package com.automation.features;

import net.serenitybdd.rest.SerenityRest;

public class BaseTest {
    static {
        SerenityRest.useRelaxedHTTPSValidation();
    }
}
