package com.vinicius.lojadesignpatterns.facade;

import com.vinicius.lojadesignpatterns.estoque.GerenciadorEstoque;
import com.vinicius.lojadesignpatterns.pagamento.FormaPagamento;

public class LojaFacade {

    public double finalizarCompra(String nomeProduto, int quantidade, double precoUnitario, FormaPagamento formaPagamento) {

        GerenciadorEstoque gerenciadorEstoque = GerenciadorEstoque.getInstancia();
        boolean conseguiuVender = gerenciadorEstoque.darBaixa(nomeProduto, quantidade);

        if (!conseguiuVender){
            return -1;
        }

        double subtotal = precoUnitario * quantidade;
        return formaPagamento.calcularValorFinal(subtotal);

    }
}
