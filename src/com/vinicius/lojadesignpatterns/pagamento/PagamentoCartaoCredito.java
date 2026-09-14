package com.vinicius.lojadesignpatterns.pagamento;

public class PagamentoCartaoCredito implements FormaPagamento {

    @Override
    public double calcularValorFinal(double subTotal) {
        return subTotal;
    }
}
