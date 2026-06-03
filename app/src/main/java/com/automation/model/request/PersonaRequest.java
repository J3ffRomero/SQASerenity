package com.automation.model.request;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@Builder
@JsonInclude(Include.NON_NULL) //Sirve para no enviar data en null, limpiar la data enviada
public class PersonaRequest {
    
    private String name;
    
    private String email;
    
    private String gender;
    
    private String status;
}