import java.util.ArrayList;
import java.util.List;

interface ObserverMercado {
    void atualizar(Acao acao);
}

interface SubjectMercado {
    void registrar(ObserverMercado o);
    void remover(ObserverMercado o);
    void notificar();
}

class AcaoBroker {
    private String nomeCorretora;

    public AcaoBroker(String nomeCorretora) {
        this.nomeCorretora = nomeCorretora;
    }

    public void vender(String acao, double preco, String investidor) {
        System.out.println("Broker " + nomeCorretora + ": ORDEM DE VENDA de " + acao + " executada para " + investidor + " a R$ " + preco);
    }

    public void comprar(String acao, double preco, String investidor) {
        System.out.println("Broker " + nomeCorretora + ": ORDEM DE COMPRA de " + acao + " executada para " + investidor + " a R$ " + preco);
    }
}

class Investidor implements ObserverMercado {
    private String nome;
    private double limiteMinimo;
    private double limiteMaximo;
    private AcaoBroker broker;

    public Investidor(String nome, double limiteMinimo, double limiteMaximo, AcaoBroker broker) {
        this.nome = nome;
        this.limiteMinimo = limiteMinimo;
        this.limiteMaximo = limiteMaximo;
        this.broker = broker;
    }

    @Override
    public void atualizar(Acao acao) {
        double precoAtual = acao.getPreco();

        if (precoAtual >= limiteMaximo) {
            broker.vender(acao.getNome(), precoAtual, nome);
        } else if (precoAtual <= limiteMinimo) {
            broker.comprar(acao.getNome(), precoAtual, nome);
        }
    }
}

class Acao implements SubjectMercado {
    private String nome;
    private double preco;
    private List<ObserverMercado> investidores;

    public Acao(String nome, double precoInicial) {
        this.nome = nome;
        this.preco = precoInicial;
        this.investidores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        System.out.println("\n[MERCADO] Variacao na acao " + nome + ": Preco alterado para R$ " + preco);
        this.preco = preco;
        notificar();
    }

    @Override
    public void registrar(ObserverMercado o) {
        investidores.add(o);
    }

    @Override
    public void remover(ObserverMercado o) {
        investidores.remove(o);
    }

    @Override
    public void notificar() {
        for (ObserverMercado o : investidores) {
            o.atualizar(this);
        }
    }
}

public class MercadoFinanceiro {
    public static void main(String[] args) {
        AcaoBroker brokerX = new AcaoBroker("InvestX");
        AcaoBroker brokerY = new AcaoBroker("TradeY");

        Investidor inv1 = new Investidor("Carlos", 20.0, 30.0, brokerX);
        Investidor inv2 = new Investidor("Marina", 22.0, 28.0, brokerY);

        Acao petr4 = new Acao("PETR4", 25.0);

        petr4.registrar(inv1);
        petr4.registrar(inv2);

        petr4.setPreco(27.0);
        petr4.setPreco(28.5);
        petr4.setPreco(31.0);
        petr4.setPreco(19.5);
    }
}