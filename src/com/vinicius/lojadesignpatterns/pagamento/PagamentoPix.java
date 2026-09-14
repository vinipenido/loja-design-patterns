package com.vinicius.lojadesignpatterns.pagamento;

public class PagamentoPix implements FormaPagamento {

    @Override
    public double calcularValorFinal(double subTotal) {
        return subTotal * 0.95;
    }

}
