interface Ave {
    void voar();
    void emitirSom();
}

class PatoDomestico implements Ave {
    @Override
    public void voar() {
        System.out.println("Pato doméstico voando!");
    }

    @Override
    public void emitirSom() {
        System.out.println("Quack (Grasnando)");
    }
}

class PavaoAzul {
    public void cantar() {
        System.out.println("Pavão azul cantando!");
    }
}

class PavaoAdapter implements Ave {
    private PavaoAzul pavao;
    public PavaoAdapter(PavaoAzul pavao) {
        this.pavao = pavao;
    }

    @Override
    public void voar() {
        System.out.println("O pavão não consegue voar.");
    }

    @Override
    public void emitirSom() {
        pavao.cantar();
    }
}

public class MainQuestao1 {

    public static void main(String[] args) {

        Ave pato = new PatoDomestico();

        PavaoAzul pavaoAzul = new PavaoAzul();
        Ave pavaoAdaptado = new PavaoAdapter(pavaoAzul);

        System.out.println("Comportamento do Pato");
        pato.emitirSom();
        pato.voar();

        System.out.println("\nComportamento do Pavão Adaptado");
        pavaoAdaptado.emitirSom();
        pavaoAdaptado.voar();
    }
}