package com.app.clean.application.rest;

import com.app.clean.domain.model.DadoEntrada;
import com.app.clean.domain.model.TipoIdentificaoParceiro;
import com.app.clean.domain.port.in.NormalizaInputPort;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/normaliza")
public class NormalizacaoController {

    private final NormalizaInputPort normalizaInputPort;

    private final MeterRegistry meterRegistry;

    @Autowired
    public NormalizacaoController(NormalizaInputPort normalizaInputPort, MeterRegistry meterRegistry) {
        this.normalizaInputPort = normalizaInputPort;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/meter")
    public ResponseEntity meterRegistryGet(@RequestParam(value = "id") String id){

        var request = new DadoEntrada();
        request.setOrigem("WEB");
        request.setTipoIdentificaoParceiro(TipoIdentificaoParceiro.CODIGO_CONVENIO);
        request.setIdentificadorParceiro(id);
        request.setRegistro("");
        normalizaInputPort.executar(request);
        meterRegistry.counter("transaction.count",
                "status", "APPROVED",
                "customerId", "423"
        ).increment();
//        meterRegistry.counter("transaction.count",
//                "status", "PENDING",
//                "customerId", "4334"
//        ).increment();
//        meterRegistry.counter("transaction.count",
//                "status", "ERRO",
//                "customerId", "5454"
//        ).increment();
        return ResponseEntity.ok().build();
    }
}
