package org.kimbs.jwt.model;

import lombok.Data;

@Data
public class AuthenticationBody {

    private String email;

    private String password;
}
