package com.app.clean.domain.model;


public class DadoEntrada {
    private TipoIdentificaoParceiro tipoIdentificaoParceiro;
    private String identificadorParceiro;
    private String origem;
    private String codigoIF;
    private String registro;

    public DadoEntrada() {
    }

    public DadoEntrada(TipoIdentificaoParceiro tipoIdentificaoParceiro, String identificadorParceiro, String origem, String codigoIF, String registro) {
        this.tipoIdentificaoParceiro = tipoIdentificaoParceiro;
        this.identificadorParceiro = identificadorParceiro;
        this.origem = origem;
        this.codigoIF = codigoIF;
        this.registro = registro;
    }

    public TipoIdentificaoParceiro getTipoIdentificaoParceiro() {
        return tipoIdentificaoParceiro;
    }

    public void setTipoIdentificaoParceiro(TipoIdentificaoParceiro tipoIdentificaoParceiro) {
        this.tipoIdentificaoParceiro = tipoIdentificaoParceiro;
    }

    public String getIdentificadorParceiro() {
        return identificadorParceiro;
    }

    public void setIdentificadorParceiro(String identificadorParceiro) {
        this.identificadorParceiro = identificadorParceiro;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getCodigoIF() {
        return codigoIF;
    }

    public void setCodigoIF(String codigoIF) {
        this.codigoIF = codigoIF;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
