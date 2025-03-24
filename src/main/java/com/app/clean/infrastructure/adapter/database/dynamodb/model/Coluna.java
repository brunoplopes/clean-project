package com.app.clean.infrastructure.adapter.database.dynamodb.model;

import com.app.clean.domain.model.ConfiguracaoDado;
import lombok.Data;

@Data
public class Coluna {
    private ConfiguracaoDado colunaIdentificadorPessoa;
    private ConfiguracaoDado colunaValorDesconto;
    private ConfiguracaoDado colunaMotivoNaoDesconto;
}
