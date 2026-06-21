import java.util.ArrayList;
import java.util.List;

interface Observer {
    void atualizar(double temperatura, double umidade, double ventos);
}

interface Subject {
    void registrarObservador(Observer o);
    void removerObservador(Observer o);
    void notificarObservadores();
}

class CET implements Subject {
    private List<Observer> observadores;
    private double temperatura;
    private double umidade;
    private double ventos;

    public CET() {
        observadores = new ArrayList<>();
    }

    @Override
    public void registrarObservador(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removerObservador(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observer o : observadores) {
            o.atualizar(temperatura, umidade, ventos);
        }
    }

    public void setMedicoes(double temperatura, double umidade, double ventos) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.ventos = ventos;
        notificarObservadores();
    }
}

class PrefeituraUberlandia implements Observer {
    @Override
    public void atualizar(double temperatura, double umidade, double ventos) {
        if (umidade < 30.0) {
            System.out.println("Prefeitura: Umidade critica! Atual: " + umidade + "%");
        } else {
            System.out.println("Prefeitura: Umidade em niveis bom (" + umidade + "%).");
        }
    }
}

class AeroportoUberlandia implements Observer {
    @Override
    public void atualizar(double temperatura, double umidade, double ventos) {
        if (ventos > 50.0) {
            System.out.println("[ALERTA AEROPORTO] Rajadas de vento fortes! Atual: " + ventos + " km/h");
        } else {
            System.out.println(" Aeroporto: Condicoes de vento normais (" + ventos + " km/h).");
        }
    }
}

public class SistemaCET {
    public static void main(String[] args) {
        CET cet = new CET();

        PrefeituraUberlandia prefeitura = new PrefeituraUberlandia();
        AeroportoUberlandia aeroporto = new AeroportoUberlandia();

        cet.registrarObservador(prefeitura);
        cet.registrarObservador(aeroporto);

        System.out.println("Atualizacao Climatica 1");
        cet.setMedicoes(32.0, 25.0, 20.0);

        System.out.println("\nAtualizacao Climatica 2");
        cet.setMedicoes(28.0, 60.0, 65.0);

        System.out.println("\nAtualizacao Climatica 3");
        cet.setMedicoes(25.0, 80.0, 15.0);
    }
}