package com.app.clean.domain.model;

public class ConvenioParceiro {
    private String idCliente;
    private String codigoConvenio;
    private String nome;
    private String nomeProcessadora;

    public ConvenioParceiro() {
    }

    public ConvenioParceiro(String idCliente, String codigoConvenio, String nome, String nomeProcessadora) {
        this.idCliente = idCliente;
        this.codigoConvenio = codigoConvenio;
        this.nome = nome;
        this.nomeProcessadora = nomeProcessadora;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(String codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeProcessadora() {
        return nomeProcessadora;
    }

    public void setNomeProcessadora(String nomeProcessadora) {
        this.nomeProcessadora = nomeProcessadora;
    }
}
