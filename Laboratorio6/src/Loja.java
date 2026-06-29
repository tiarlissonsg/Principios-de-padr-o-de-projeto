abstract class ProcessadorPedido {
    protected int quantidadeItens;
    protected double valorItem;
    protected String formaPagamento;

    public ProcessadorPedido(int quantidadeItens, double valorItem, String formaPagamento) {
        this.quantidadeItens = quantidadeItens;
        this.valorItem = valorItem;
        this.formaPagamento = formaPagamento;
    }

    public final void processarPedido() {
        double total = quantidadeItens * valorItem;
        System.out.println("Resumo: " + quantidadeItens + " itens de R$ " + valorItem + " (Total: R$ " + total + ")");

        processarPagamento(total);
        decidirEntrega();

        System.out.println("---");
    }

    protected abstract void processarPagamento(double total);
    protected abstract void decidirEntrega();
}

class PedidoOnline extends ProcessadorPedido {
    public PedidoOnline(int quantidadeItens, double valorItem, String formaPagamento) {
        super(quantidadeItens, valorItem, formaPagamento);
    }

    @Override
    protected void processarPagamento(double total) {
        System.out.println("PAGAMENTO Processando R$ " + total + " via sistema online com: " + formaPagamento);
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("ENTREGA: Pedido Online. Separando no estoque e enviando via transportadora.");
    }
}

class PedidoNaLoja extends ProcessadorPedido {
    public PedidoNaLoja(int quantidadeItens, double valorItem, String formaPagamento) {
        super(quantidadeItens, valorItem, formaPagamento);
    }

    @Override
    protected void processarPagamento(double total) {
        System.out.println("PAGAMENTO: Recebendo R$ " + total + " no caixa físico da loja em: " + formaPagamento);
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("ENTREGA: Pedido Físico. O cliente está levando a mercadoria. (Sem envio)");
    }
}

class PedidoCriptomoeda extends ProcessadorPedido {
    public PedidoCriptomoeda(int quantidadeItens, double valorItem) {
        super(quantidadeItens, valorItem, "Bitcoin");
    }

    @Override
    protected void processarPagamento(double total) {
        System.out.println("PAGAMENTO: Aguardando confirmações da rede Blockchain para o valor de R$ " + total + "...");
        System.out.println("PAGAMENTO: Transação validada com sucesso via " + formaPagamento + ".");
    }

    @Override
    protected void decidirEntrega() {
        System.out.println("ENTREGA: Produto digital associado a compra via Cripto.");
    }
}
public class Loja {
    public static void main(String[] args) {
        System.out.println("PROCESSANDO PEDIDO ONLINE");
        ProcessadorPedido pedido1 = new PedidoOnline(2, 150.00, "Cartão de Crédito");
        pedido1.processarPedido();

        System.out.println("PROCESSANDO PEDIDO NA LOJA");
        ProcessadorPedido pedido2 = new PedidoNaLoja(1, 45.00, "Dinheiro");
        pedido2.processarPedido();

        System.out.println("PROCESSANDO PEDIDO COM CRIPTO");
        ProcessadorPedido pedido3 = new PedidoCriptomoeda(5, 200.00);
        pedido3.processarPedido();
    }
}

//Resposta da Questão 2 B
//Qual a diferença entre o padrão de projeto Template e o Decorator ?
//Template é o padrão comportamental focado em herança e ele define o esqueleto estático de um algoritmo em um super classe abstrata obrigando as subclasses a implementarem apenas passos específicos.
//Decorator é um padrão estrutural focado em composição que permite adicionar novas funcionalidades e comportamentos a um objeto de forma dinâmica em tempo de execução.