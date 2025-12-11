package com.app.clean.example.middleware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName(TipoValidador.ROLE)
public class RoleCheckMiddleware extends Middleware {
    private int roleCheck;

    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            return true;
        }
        return checkNext(email, password);
    }
}
