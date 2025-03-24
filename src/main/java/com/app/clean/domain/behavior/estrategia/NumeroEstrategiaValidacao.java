package com.app.clean.domain.behavior.estrategia;

public class NumeroEstrategiaValidacao implements EstrategiaValidacao {
    @Override
    public boolean valido(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
