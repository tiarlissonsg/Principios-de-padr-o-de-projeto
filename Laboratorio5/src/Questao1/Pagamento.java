package questao1;

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

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
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
        System.out.println("Pagamento de R$ " + String.format("%.2f", valor) + " aprovado no Cartão de Crédito (" + numeroCartao + ").");
    }
}

class BoletoPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.println("Boleto bancário gerado no valor de R$ " + String.format("%.2f", valor) + ". Aguardando pagamento.");
    }
}

class CarrinhoCompras {
    private List<Item> itens;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionaItem(Item item) {
        itens.add(item);
        System.out.println(item.getNome() + " adicionado ao carrinho.");
    }

    public double calculaTotal() {
        double soma = 0;
        for (Item item : itens) {
            soma += item.getPreco();
        }
        return soma;
    }

    public void realizaPagamento(PagamentoStrategy estrategia) {
        double total = calculaTotal();
        if (total > 0) {
            estrategia.pagar(total);
        } else {
            System.out.println("O carrinho está vazio. Nada a pagar.");
        }
    }
}

public class Pagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoCompras carrinho = new CarrinhoCompras();

        carrinho.adicionaItem(new Item("Teclado Mecânico", 350.00));
        carrinho.adicionaItem(new Item("Mouse Gamer", 150.00));

        System.out.println("\nTotal do Carrinho: R$ " + String.format("%.2f", carrinho.calculaTotal()));

        System.out.println("\nFECHAMENTO DO PEDIDO");
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto Bancário");
        System.out.print("Digite a opção desejada: ");

        int opcao = scanner.nextInt();

        switch (opcao) {
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
                System.out.println("Opção inválida a compra será cancelada.");
                break;
        }

        scanner.close();
    }
}