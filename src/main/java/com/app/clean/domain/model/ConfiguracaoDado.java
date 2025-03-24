package com.app.clean.domain.model;

import com.app.clean.domain.behavior.estrategia.EstrategiaValidacao;
import com.app.clean.domain.behavior.transformation.TransformationStrategy;

import java.util.List;

public class ConfiguracaoDado {
    private String valor;
    private Integer coluna;
    private Integer posicaoInicial;
    private Integer posicaoFinal;
    private List<TransformationStrategy> transformations;
    private List<EstrategiaValidacao> validacoesDadoPreTransformation;
    private List<EstrategiaValidacao> validacoesDadoPosTransformation;

    public ConfiguracaoDado() {
    }

    public ConfiguracaoDado(String valor, Integer coluna, Integer posicaoInicial, Integer posicaoFinal, List<TransformationStrategy> transformations, List<EstrategiaValidacao> validacoesDadoPreTransformation, List<EstrategiaValidacao> validacoesDadoPosTransformation) {
        this.valor = valor;
        this.coluna = coluna;
        this.posicaoInicial = posicaoInicial;
        this.posicaoFinal = posicaoFinal;
        this.transformations = transformations;
        this.validacoesDadoPreTransformation = validacoesDadoPreTransformation;
        this.validacoesDadoPosTransformation = validacoesDadoPosTransformation;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getColuna() {
        return coluna;
    }

    public void setColuna(Integer coluna) {
        this.coluna = coluna;
    }

    public Integer getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Integer posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public Integer getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(Integer posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }

    public List<TransformationStrategy> getTransformations() {
        return transformations;
    }

    public void setTransformations(List<TransformationStrategy> transformations) {
        this.transformations = transformations;
    }

    public List<EstrategiaValidacao> getValidacoesDadoPreTransformation() {
        return validacoesDadoPreTransformation;
    }

    public void setValidacoesDadoPreTransformation(List<EstrategiaValidacao> validacoesDadoPreTransformation) {
        this.validacoesDadoPreTransformation = validacoesDadoPreTransformation;
    }

    public List<EstrategiaValidacao> getValidacoesDadoPosTransformation() {
        return validacoesDadoPosTransformation;
    }

    public void setValidacoesDadoPosTransformation(List<EstrategiaValidacao> validacoesDadoPosTransformation) {
        this.validacoesDadoPosTransformation = validacoesDadoPosTransformation;
    }
}
