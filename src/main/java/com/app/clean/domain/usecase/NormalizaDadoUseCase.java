package com.app.clean.domain.usecase;

import com.app.clean.domain.model.DadoEntrada;
import com.app.clean.domain.port.in.NormalizaInputPort;
import com.app.clean.domain.port.out.ConsultaParceiroOutputPort;
import com.app.clean.domain.port.out.RegrasConfiguracaoOutputPort;

public class NormalizaDadoUseCase implements NormalizaInputPort {
    private final RegrasConfiguracaoOutputPort regrasConfiguracaoOutputPort;
    private final ConsultaParceiroOutputPort consultaParceiroOutputPort;

    public NormalizaDadoUseCase(RegrasConfiguracaoOutputPort regrasConfiguracaoOutputPort, ConsultaParceiroOutputPort consultaParceiroOutputPort) {
        this.regrasConfiguracaoOutputPort = regrasConfiguracaoOutputPort;
        this.consultaParceiroOutputPort = consultaParceiroOutputPort;
    }


    @Override
    public void executar(DadoEntrada dadosEntrada) {
        var parceiro = consultaParceiroOutputPort.buscar(dadosEntrada.getIdentificadorParceiro());

        var configuracoes = regrasConfiguracaoOutputPort.get(parceiro.getCodigoConvenio());
    }
}
