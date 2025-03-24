package com.app.clean.infrastructure.adapter.client;

import com.app.clean.domain.model.ConvenioParceiro;
import com.app.clean.domain.port.out.ConsultaParceiroOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConsultaParceiroAdapter implements ConsultaParceiroOutputPort {

    private final ConvenioClient convenioClient;

    @Autowired
    public ConsultaParceiroAdapter(ConvenioClient convenioClient) {
        this.convenioClient = convenioClient;
    }


    @Override
    @Cacheable(cacheNames = "codigoConvenio", key = "#codigoConvenio")
    public ConvenioParceiro buscar(String codigoConvenio) {
        var resposta = convenioClient.buscar(codigoConvenio);
        var convenio = new ConvenioParceiro();
        convenio.setCodigoConvenio(resposta.getCodigoConvenio());
        return convenio;
    }
}
