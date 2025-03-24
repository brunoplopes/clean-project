//package com.app.clean.domain.behavior.orquestrador;
//
//
//import com.app.clean.domain.model.ConvenioParceiro;
//import com.app.clean.domain.model.DadoEntrada;
//import com.app.clean.domain.model.TipoIdentificaoParceiro;
//import com.app.clean.domain.port.out.ConsultaParceiroOutputPort;
//
//public class ConsultaParceiroOrquestrador {
//    private final ConsultaParceiroOutputPort consultaParceiroOutputPort;
//
//    public ConsultaParceiroOrquestrador(ConsultaParceiroOutputPort consultaParceiroOutputPort) {
//        this.consultaParceiroOutputPort = consultaParceiroOutputPort;
//    }
//
//    public ConvenioParceiro buscar(DadoEntrada dadoEntrada) {
//        var convenioParceiro = new ConvenioParceiro();
//        var tipo = dadoEntrada.getTipoIdentificaoParceiro();
//        var identificador = dadoEntrada.getIdentificadorParceiro();
//        if (TipoIdentificaoParceiro.CNPJ == tipo) {
//            var parceiro = consultaParceiroOutputPort.buscar(tipo, identificador, null);
//            convenioParceiro = buscarPorIdCliente(parceiro.getIdCliente(), dadoEntrada.getCodigoIF());
//        }a
//        if (TipoIdentificaoParceiro.CADASTRO_UNICO == tipo) {
//            convenioParceiro = buscarPorIdCliente(identificador, dadoEntrada.getCodigoIF());
//        }
//        var processadora = consultaParceiroOutputPort.buscar(convenioParceiro.getCodigoConvenio());
//        convenioParceiro.setNomeProcessadora(processadora.getNomeProcessadora());
//        return convenioParceiro;
//    }
//
//    private ConvenioParceiro buscarPorIdCliente(String identificador, String codigoIF) {
//        return consultaParceiroOutputPort.buscar(TipoIdentificaoParceiro.CADASTRO_UNICO, identificador, codigoIF);
//    }
//}
