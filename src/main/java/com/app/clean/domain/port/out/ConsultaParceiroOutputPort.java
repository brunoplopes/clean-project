package com.app.clean.domain.port.out;


import com.app.clean.domain.model.ConvenioParceiro;

public interface ConsultaParceiroOutputPort {
    ConvenioParceiro buscar(String codigoConvenio);
}
