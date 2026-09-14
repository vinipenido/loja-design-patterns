package com.vinicius.lojadesignpatterns.pagamento;

public class PagamentoBoleto implements FormaPagamento {

    @Override
    public double calcularValorFinal(double subTotal) {
        return subTotal * 0.97;
    }
}
