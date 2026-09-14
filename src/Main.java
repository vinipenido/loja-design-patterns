import com.vinicius.lojadesignpatterns.estoque.GerenciadorEstoque;
import com.vinicius.lojadesignpatterns.facade.LojaFacade;
import com.vinicius.lojadesignpatterns.pagamento.PagamentoPix;

public class Main {

    public static void main(String[] args) {

        GerenciadorEstoque gerenciadorEstoque = GerenciadorEstoque.getInstancia();
        gerenciadorEstoque.adicionaProduto("Notebook", 10);

        LojaFacade loja = new LojaFacade();
        double valorTotal = loja.finalizarCompra("Notebook", 1, 2500.0, new PagamentoPix());

        double segundaCompra = loja.finalizarCompra("Notebook", 20, 2500.0, new PagamentoPix());
        System.out.println(segundaCompra);

        System.out.println(valorTotal);
    }
}