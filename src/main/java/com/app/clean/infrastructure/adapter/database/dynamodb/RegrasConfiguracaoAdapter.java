package com.app.clean.infrastructure.adapter.database.dynamodb;

import com.app.clean.domain.model.ConfiguracaoProcessamentoDado;
import com.app.clean.domain.port.out.RegrasConfiguracaoOutputPort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class RegrasConfiguracaoAdapter implements RegrasConfiguracaoOutputPort {

    @Override
    public ConfiguracaoProcessamentoDado get(String codigoConvenio) {
        var jsonSeparador = """
                  {
                  "tipoFormatacaoDado": "DELIMITADOR",
                  "delimitador": ";"
                }
                """;

        ObjectMapper mapper = new ObjectMapper();
        try {
            ConfiguracaoProcessamentoDado arquivoConfiguracao = mapper.readValue(jsonSeparador, ConfiguracaoProcessamentoDado.class);
            return arquivoConfiguracao;
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());;
        }

        return null;
    }
}
