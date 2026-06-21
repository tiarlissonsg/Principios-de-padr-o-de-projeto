package Questao2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() { return preco; }
    public String getNome() { return nome; }
}

interface PagamentoStrategy {
    void pagar(double valor);
}

class PixPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " realizado com sucesso via PIX.");
    }
}

class CartaoPagamento implements PagamentoStrategy {
    private String nomeTitular;
    private String numeroCartao;

    public CartaoPagamento(String nomeTitular, String numeroCartao) {
        this.nomeTitular = nomeTitular;
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " aprovado no Cartão final " + numeroCartao.substring(15) + ".");
    }
}

class BoletoPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Boleto bancário gerado no valor de R$ " + String.format("%.2f", valor) + ". Aguardando pagamento.");
    }
}

interface FreteStrategy {
    double calcular();
}

class SedexFrete implements FreteStrategy {
    @Override
    public double calcular() {
        return 45.00;
    }
}

class NormalFrete implements FreteStrategy {
    @Override
    public double calcular() {
        return 15.00;
    }
}

class CarrinhoCompras {
    private List<Item> itens;
    private FreteStrategy freteStrategy;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionaItem(Item item) {
        itens.add(item);
        System.out.println(item.getNome() + " adicionado. (R$ " + String.format("%.2f", item.getPreco()) + ")");
    }

    public void setFreteStrategy(FreteStrategy freteStrategy) {
        this.freteStrategy = freteStrategy;
    }

    public double calculaFrete() {
        if (freteStrategy != null) {
            return freteStrategy.calcular();
        }
        return 0.0;
    }

    public double calculaTotal() {
        double somaItens = 0;
        for (Item item : itens) {
            somaItens += item.getPreco();
        }
        return somaItens + calculaFrete();
    }

    public void realizaPagamento(PagamentoStrategy estrategiaPagamento) {
        double total = calculaTotal();
        if (total > 0) {
            System.out.println("\nResumo: Itens + Frete = R$ " + String.format("%.2f", total));
            estrategiaPagamento.pagar(total);
        } else {
            System.out.println("O carrinho está vazio.");
        }
    }
}
public class Loja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoCompras carrinho = new CarrinhoCompras();

        System.out.println("ADICIONANDO ITENS AO CARRINHO");
        carrinho.adicionaItem(new Item("Teclado Mecanico", 350.00));
        carrinho.adicionaItem(new Item("Mause Gamer", 150.00));

        System.out.println("\n ESCOLHA O TIPO DE FRETE");
        System.out.println("1 - Sedex (R$ 45,00 - Entrega Rápida)");
        System.out.println("2 - Normal (R$ 15,00 - Entrega Padrão)");
        System.out.print("Digite a opção de frete: ");
        int opFrete = scanner.nextInt();

        if (opFrete == 1) {
            carrinho.setFreteStrategy(new SedexFrete());
        } else {
            carrinho.setFreteStrategy(new NormalFrete());
        }

        System.out.println("\n FORMA DE PAGAMENTO");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto Bancário");
        System.out.print("Digite a opção de pagamento: ");
        int opPagamento = scanner.nextInt();

        System.out.println("\nPROCESSANDO SEU PEDIDO");
        switch (opPagamento) {
            case 1:
                carrinho.realizaPagamento(new PixPagamento());
                break;
            case 2:
                carrinho.realizaPagamento(new CartaoPagamento("Fulano", "1234-5678-9876-5432"));
                break;
            case 3:
                carrinho.realizaPagamento(new BoletoPagamento());
                break;
            default:
                System.out.println("Opção inválida. Compra cancelada.");
                break;
        }

        scanner.close();
    }
}