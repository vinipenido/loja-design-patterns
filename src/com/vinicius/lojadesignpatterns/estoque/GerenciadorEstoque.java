package com.vinicius.lojadesignpatterns.estoque;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorEstoque {

    private static GerenciadorEstoque instancia;

    private GerenciadorEstoque() {

    }

    public static GerenciadorEstoque getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorEstoque();
        }
        return instancia;
    }

    private final Map<String, Integer> estoque = new HashMap<>();

    public void adicionaProduto(String nomeProduto, int quantidade) {
        estoque.put(nomeProduto, quantidade);
    }

    public boolean darBaixa(String nomeProduto, int quantidade) {

        Integer disponivel = estoque.get(nomeProduto);

        if (disponivel == null || disponivel < quantidade) {
            return false;
        }

        estoque.put(nomeProduto, disponivel - quantidade);
        return true;
    }

}
