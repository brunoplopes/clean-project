package com.app.clean.domain.port.in;


import com.app.clean.domain.model.DadoEntrada;

public interface NormalizaInputPort {
    void executar(DadoEntrada dadoEntrada);
}
