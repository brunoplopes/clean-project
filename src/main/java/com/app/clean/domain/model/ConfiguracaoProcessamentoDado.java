package com.app.clean.domain.model;


import java.util.List;


public class ConfiguracaoProcessamentoDado {
    private TipoFormatacaoDado tipoFormatacaoDado;
    private String delimitador;
    private List<ConfiguracaoDado> configuracoesDado;

    public ConfiguracaoProcessamentoDado() {
    }

    public ConfiguracaoProcessamentoDado(TipoFormatacaoDado tipoFormatacaoDado, String delimitador, List<ConfiguracaoDado> configuracoesDado) {
        this.tipoFormatacaoDado = tipoFormatacaoDado;
        this.delimitador = delimitador;
        this.configuracoesDado = configuracoesDado;
    }

    public TipoFormatacaoDado getTipoFormatacaoDado() {
        return tipoFormatacaoDado;
    }

    public void setTipoFormatacaoDado(TipoFormatacaoDado tipoFormatacaoDado) {
        this.tipoFormatacaoDado = tipoFormatacaoDado;
    }

    public String getDelimitador() {
        return delimitador;
    }

    public void setDelimitador(String delimitador) {
        this.delimitador = delimitador;
    }

    public List<ConfiguracaoDado> getConfiguracoesDado() {
        return configuracoesDado;
    }

    public void setConfiguracoesDado(List<ConfiguracaoDado> configuracoesDado) {
        this.configuracoesDado = configuracoesDado;
    }
}
