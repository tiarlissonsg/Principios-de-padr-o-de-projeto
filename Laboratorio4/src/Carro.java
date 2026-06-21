//Pratica Laboratorio 4
class Motor {
    public void ligar() {
        System.out.println("Motor: Ligado.");
    }
    public void desligar() {
        System.out.println("Motor: Desligado.");
    }
}

class CintoDeSeguranca {
    public void travar() {
        System.out.println("Cinto de Segurança: Travado.");
    }
    public void destravar() {
        System.out.println("Cinto de Segurança: Destravado.");
    }
}

class Porta {
    public void trancar() {
        System.out.println("Portas: Trancadas.");
    }
    public void destrancar() {
        System.out.println("Portas: Destrancadas.");
    }
}

class Farol {
    public void acender() {
        System.out.println("Farol: Aceso.");
    }
    public void apagar() {
        System.out.println("Farol: Apagado.");
    }
}

class Radio {
    public void ligar() {
        System.out.println("Rádio: Ligado.");
    }
    public void desligar() {
        System.out.println("Rádio: Desligado.");
    }
    public void sintonizar(String estacao) {
        System.out.println("Rádio: Sintonizado na estação " + estacao);
    }
}

class FachadaCarro {
    private Motor motor;
    private CintoDeSeguranca cinto;
    private Porta porta;
    private Farol farol;
    private Radio radio;

    public FachadaCarro() {
        this.motor = new Motor();
        this.cinto = new CintoDeSeguranca();
        this.porta = new Porta();
        this.farol = new Farol();
        this.radio = new Radio();
    }

    public void iniciarCorrida() {
        System.out.println("Preparando para dirigir");
        motor.ligar();
        porta.trancar();
        cinto.travar();
        farol.acender();
        radio.ligar();
        radio.sintonizar("95.5 FM");
        System.out.println("Pronto para partir\n");
    }

    public void finalizarCorrida() {
        System.out.println("Finalizando a corrida");
        motor.desligar();
        porta.destrancar();
        cinto.destravar();
        farol.apagar();
        radio.desligar();
        System.out.println("Carro desligado");
    }
}

public class Carro {
    public static void main(String[] args) {

        FachadaCarro meuCarro = new FachadaCarro();
        meuCarro.iniciarCorrida();
        meuCarro.finalizarCorrida();
    }
}