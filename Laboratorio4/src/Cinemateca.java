//Pratica Laboratorio 4
class Amplificador {
    public void liga() {
        System.out.println("Amplificador ligado.");
    }
    public void desliga() {
        System.out.println("Amplificador desligado.");
    }
    public void ajusteDeVolume(int nivel) {
        System.out.println("Volume do amplificador ajustado para " + nivel + ".");
    }
}

class Luzes {
    public void liga() {
        System.out.println("Luzes ligadas.");
    }
    public void desliga() {
        System.out.println("Luzes desligadas.");
    }
}

class MaquinaDePipoca {
    public void liga() {
        System.out.println("Máquina de Pipoca ligada.");
    }
    public void desliga() {
        System.out.println("Máquina de Pipoca desligada.");
    }
    public void arrebentaPipoca() {
        System.out.println("Rebentando pipoca");
    }
}

class Projetor {
    public void liga() {
        System.out.println("Projetor ligado.");
    }
    public void desliga() {
        System.out.println("Projetor desligado.");
    }
}

class PlayerDeStreaming {
    public void liga() {
        System.out.println("Player de Streaming ligado.");
    }
    public void desliga() {
        System.out.println("Player de Streaming desligado.");
    }
    public void play(String filme) {
        System.out.println("Dando play no filme: " + filme);
    }
}

class Telao {
    public void abaixa() {
        System.out.println("Telão abaixado.");
    }
    public void sobe() {
        System.out.println("Telão recolhido.");
    }
}

class HomeTheaterFacade {
    private Amplificador amp;
    private Luzes luzes;
    private MaquinaDePipoca pipoqueira;
    private Projetor projetor;
    private PlayerDeStreaming player;
    private Telao telao;

    public HomeTheaterFacade(Amplificador amp, Luzes luzes, MaquinaDePipoca pipoqueira,
                             Projetor projetor, PlayerDeStreaming player, Telao telao) {
        this.amp = amp;
        this.luzes = luzes;
        this.pipoqueira = pipoqueira;
        this.projetor = projetor;
        this.player = player;
        this.telao = telao;
    }

    public void assistirFilme(String filme) {
        System.out.println("Preparando a sessão de cinema");
        pipoqueira.liga();
        pipoqueira.arrebentaPipoca();
        luzes.desliga();
        telao.abaixa();
        projetor.liga();
        amp.liga();
        amp.ajusteDeVolume(10);
        player.liga();
        player.play(filme);
        System.out.println("Sessão iniciada.\n");
    }

    public void fimDoFilme() {
        System.out.println("Finalizando a sessão de cinema");
        player.desliga();
        amp.desliga();
        projetor.desliga();
        telao.sobe();
        luzes.liga();
        pipoqueira.desliga();
        System.out.println("Sistema desligado");
    }
}

public class Cinemateca {
    public static void main(String[] args) {
        Amplificador amp = new Amplificador();
        Luzes luzes = new Luzes();
        MaquinaDePipoca pipoqueira = new MaquinaDePipoca();
        Projetor projetor = new Projetor();
        PlayerDeStreaming player = new PlayerDeStreaming();
        Telao telao = new Telao();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amp, luzes, pipoqueira, projetor, player, telao
        );

        homeTheater.assistirFilme("Piratas da informática");

        System.out.println("\nFinal do Filme \n");

        homeTheater.fimDoFilme();
    }
}