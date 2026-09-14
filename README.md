# Loja Design Patterns

Projeto desenvolvido para o desafio final do bootcamp de Padrões de Projeto (Design Patterns) da [Digital Innovation One](https://www.dio.me/), com base nos laboratórios:

- [lab-padroes-projeto-java](https://github.com/digitalinnovationone/lab-padroes-projeto-java)
- [lab-padroes-projeto-spring](https://github.com/digitalinnovationone/lab-padroes-projeto-spring)

Simula o checkout de uma loja virtual, aplicando os três padrões de projeto trabalhados no curso: **Strategy**, **Singleton** e **Facade**, em Java puro (sem framework).

## Padrões aplicados

### Strategy — formas de pagamento

A interface `FormaPagamento` define um contrato único (`calcularValorFinal`) implementado de formas diferentes por `PagamentoPix`, `PagamentoCartaoCredito` e `PagamentoBoleto`. Cada uma aplica sua própria regra de desconto, e o restante do sistema pode trocar de forma de pagamento sem precisar de `if/else` nem conhecer os detalhes de cada implementação.

```
com.vinicius.lojadesignpatterns.pagamento
├── FormaPagamento          (interface)
├── PagamentoPix             → 5% de desconto
├── PagamentoCartaoCredito   → sem desconto
└── PagamentoBoleto          → 3% de desconto
```

### Singleton — controle de estoque

`GerenciadorEstoque` garante uma única instância compartilhada por toda a aplicação, controlando a quantidade disponível de cada produto (`adicionaProduto`, `darBaixa`). O construtor é privado; o acesso acontece sempre via `GerenciadorEstoque.getInstancia()`.

### Facade — checkout

`LojaFacade` esconde a complexidade de orquestrar estoque + pagamento atrás de um único método: `finalizarCompra(nomeProduto, quantidade, precoUnitario, formaPagamento)`. Internamente, ele:

1. Consulta o `GerenciadorEstoque` (Singleton) e tenta dar baixa na quantidade pedida
2. Se não houver estoque suficiente, retorna `-1`
3. Se houver, calcula o subtotal e delega o cálculo final para a `FormaPagamento` escolhida (Strategy)

## Estrutura do projeto

```
com.vinicius.lojadesignpatterns
├── estoque
│   └── GerenciadorEstoque.java
├── facade
│   └── LojaFacade.java
├── pagamento
│   ├── FormaPagamento.java
│   ├── PagamentoPix.java
│   ├── PagamentoCartaoCredito.java
│   └── PagamentoBoleto.java
└── Main.java
```

## Como rodar

Projeto Java puro, sem dependências externas (Maven/Gradle não são necessários).

Pelo IntelliJ: abra o projeto e execute a classe `Main` (botão de play ao lado do método `main`).

Pela linha de comando, a partir da raiz do projeto:

```bash
javac -d out $(find src -name "*.java")
java -cp out Main
```

## Exemplo de saída

```
2375.0   // compra de 1 Notebook (R$ 2500,00) via Pix → 5% de desconto
-1.0     // segunda tentativa de compra excede o estoque disponível
```

## Aprendizados

Projeto construído como parte da minha transição para desenvolvimento back-end em Java, aplicando na prática os padrões de projeto vistos no bootcamp da DIO — reforçando conceitos como acoplamento, responsabilidade única e o valor de esconder complexidade atrás de interfaces simples.