package com.app.clean.example.middleware;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ThrottlingMiddleware.class, name = TipoValidador.THRO),
        @JsonSubTypes.Type(value = UserExistsMiddleware.class, name = TipoValidador.USER),
        @JsonSubTypes.Type(value = RoleCheckMiddleware.class, name = TipoValidador.ROLE)
})
public abstract class Middleware {
    private Middleware next;

    public Middleware() {
    }

    public static Middleware link(final Middleware first, final Middleware... chain) {
        Middleware head = first;
        var listaChain = List.of(chain);
        for (Middleware nextInChain : listaChain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }


    public abstract boolean check(String email, String password);


    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
