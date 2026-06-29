abstract class ReceitaBebida {
    public final void prepararReceita() {
        aqueceAgua();
        preparaBebida();
        colocaNaXicara();
        adicionaCondimentos();
        System.out.println("---");
    }


    private void aqueceAgua() {
        System.out.println("Aquecendo a água");
    }

    private void colocaNaXicara() {
        System.out.println("Colocando a bebida na xícara");
    }

    protected abstract void preparaBebida();
    protected abstract void adicionaCondimentos();
}
class Cafe extends ReceitaBebida {
    @Override
    protected void preparaBebida() {
        System.out.println("Coando o café");
    }

    @Override
    protected void adicionaCondimentos() {
        System.out.println("Adicionando adoçante");
    }
}

class Capuccino extends ReceitaBebida {
    @Override
    protected void preparaBebida() {
        System.out.println("Fazendo o café expresso");
    }

    @Override
    protected void adicionaCondimentos() {
        System.out.println("Adicionando leite, espuma e canela em pó");
    }
}

class Cha extends ReceitaBebida {
    @Override
    protected void preparaBebida() {
        System.out.println("Fazendo o chá de sache");
    }

    @Override
    protected void adicionaCondimentos() {
        System.out.println("Adicionando gotas de limão");
    }
}

public class Cafeteria {
    public static void main(String[] args) {
        System.out.println("PREPARANDO CAFÉ");
        ReceitaBebida meuCafe = new Cafe();
        meuCafe.prepararReceita();

        System.out.println("PREPARANDO CAPUCCINO");
        ReceitaBebida meuCapuccino = new Capuccino();
        meuCapuccino.prepararReceita();

        System.out.println("PREPARANDO CHÁ");
        ReceitaBebida meuCha = new Cha();
        meuCha.prepararReceita();
    }
}