package com.app.clean.domain.port.out;

import com.app.clean.domain.model.ConfiguracaoProcessamentoDado;

public interface RegrasConfiguracaoOutputPort {
    ConfiguracaoProcessamentoDado get(String codigoConvenio);
}
