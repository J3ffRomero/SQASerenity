package com.automation.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //Si la API responde con mas data no genera errores
public class PersonaResponse {

    @JsonProperty("id")
    private Integer personID;

    @JsonProperty("name")
    private String personName;

    @JsonProperty("email")
    private String personEmail;

    @JsonProperty("gender")
    private String personGender;

    @JsonProperty("status")
    private String personStatus;

}
