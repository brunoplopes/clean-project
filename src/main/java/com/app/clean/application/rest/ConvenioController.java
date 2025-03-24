package com.app.clean.application.rest;

import com.app.clean.infrastructure.adapter.client.dto.ConvenioParceiroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convenios")
public class ConvenioController {


    @GetMapping
    public ResponseEntity get(@RequestParam(value = "id") String id){

        var request = new ConvenioParceiroDTO();
        request.setCodigoConvenio(id);
        return ResponseEntity.ok().body(request);
    }

}
