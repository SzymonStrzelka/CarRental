package com.sstrzelka.jee.jaxrs.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private final int id;
    private String firstName;
    private String lastName;
}
