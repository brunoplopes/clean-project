package com.app.clean.domain.behavior.estrategia;

public class CPFEstrategiaValidacao implements EstrategiaValidacao {
    @Override
    public boolean valido(String value) {
        return value != null && value.matches("\\d{11}");
    }
}
