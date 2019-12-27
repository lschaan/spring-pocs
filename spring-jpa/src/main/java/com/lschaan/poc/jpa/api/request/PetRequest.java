package com.lschaan.poc.jpa.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetRequest {
    private String name;
    private Integer age;
    private String race;
}
