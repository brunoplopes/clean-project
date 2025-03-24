package com.app.clean.infrastructure.adapter.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConvenioParceiroDTO {
    private String idCliente;
    private String codigoConvenio;
    private String nome;
    private String nomeProcessadora;
}
