package com.app.clean.infrastructure.config;

import com.app.clean.domain.port.in.NormalizaInputPort;
import com.app.clean.domain.port.out.ConsultaParceiroOutputPort;
import com.app.clean.domain.port.out.RegrasConfiguracaoOutputPort;
import com.app.clean.domain.usecase.NormalizaDadoUseCase;
import com.app.clean.infrastructure.adapter.client.ConsultaParceiroAdapter;
import com.app.clean.infrastructure.adapter.client.ConvenioClient;
import com.app.clean.infrastructure.adapter.database.dynamodb.RegrasConfiguracaoAdapter;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
public class Configuracao {

    @Bean
    public RegrasConfiguracaoOutputPort regrasConfiguracaoOutputPort() {
        return new RegrasConfiguracaoAdapter();
    }

    @Bean
    public ConsultaParceiroOutputPort consultaConvenioParceiroOutputPort(ConvenioClient convenioClient) {
        return new ConsultaParceiroAdapter(convenioClient);
    }

    @Bean
    public NormalizaInputPort normalizaInputPort(RegrasConfiguracaoOutputPort regrasConfiguracaoOutputPort, ConsultaParceiroOutputPort consultaConvenioParceiroOutputPort) {
        return new NormalizaDadoUseCase(regrasConfiguracaoOutputPort, consultaConvenioParceiroOutputPort);
    }

    @CacheEvict(value="codigoConvenio", allEntries=true)
    @Scheduled(fixedRate = 60000)
    public void limparCacheCodigoConvenio() {}
}
