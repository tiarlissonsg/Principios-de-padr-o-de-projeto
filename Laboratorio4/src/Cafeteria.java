interface Bebida {
    double calculaCusto();
    String getDescricao();
}

class Espresso implements Bebida {
    @Override
    public double calculaCusto() {
        return 5.00;
    }

    @Override
    public String getDescricao() {
        return "Café Espresso";
    }
}

class Decaf implements Bebida {
    @Override
    public double calculaCusto() {
        return 4.50;
    }

    @Override
    public String getDescricao() {
        return "Café Descafeinado";
    }
}

abstract class BebidaDecorator implements Bebida {
    protected Bebida bebida;

    public BebidaDecorator(Bebida bebida) {
        this.bebida = bebida;
    }
}

class Leite extends BebidaDecorator {
    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 1.50;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Leite";
    }
}

class Canela extends BebidaDecorator {
    public Canela(Bebida bebida) {
        super(bebida);
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 0.50;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + " e Canela";
    }
}

class Chocolate extends BebidaDecorator {
    public Chocolate(Bebida bebida) {
        super(bebida);
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 2.00;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", com Chocolate";
    }
}

public class Cafeteria {
    public static void main(String[] args) {
        Bebida bebida1 = new Espresso();
        System.out.println(bebida1.getDescricao() + " -> R$ " + bebida1.calculaCusto());

        Bebida bebida2 = new Decaf();
        bebida2 = new Leite(bebida2);
        bebida2 = new Canela(bebida2);
        System.out.println(bebida2.getDescricao() + " -> R$ " + bebida2.calculaCusto());

        Bebida bebida3 = new Espresso();
        bebida3 = new Chocolate(bebida3);
        bebida3 = new Leite(bebida3);
        System.out.println(bebida3.getDescricao() + " -> R$ " + bebida3.calculaCusto());
    }
}