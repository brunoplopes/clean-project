package com.app.clean.infrastructure.adapter.client;

import com.app.clean.infrastructure.adapter.client.dto.ConvenioParceiroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.convenios.name}", url = "${feign.convenios.url}")
public interface ConvenioClient {
    @RequestMapping(method = RequestMethod.GET, value = "/convenios", consumes = "application/json")
    ConvenioParceiroDTO buscar(@RequestParam("id") String id);
}
