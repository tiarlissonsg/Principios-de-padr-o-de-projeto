
interface Pizza {
    String getDescricao();
    double calculaCusto();
}

class MassaFinaPizza implements Pizza {

    @Override
    public String getDescricao() {
        return "Pizza de massa fina";
    }

    @Override
    public double calculaCusto() {
        return 20.00;
    }
}

class MassaEspessaPizza implements Pizza {

    @Override
    public String getDescricao() {
        return "Pizza de massa espessa";
    }

    @Override
    public double calculaCusto() {
        return 25.00;
    }
}
abstract class ToppingDecorator implements Pizza {

    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Queijo extends ToppingDecorator {

    public Queijo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", queijo";
    }

    @Override
    public double calculaCusto() {
        return pizza.calculaCusto() + 5.00;
    }
}

class Tomate extends ToppingDecorator {

    public Tomate(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", tomate";
    }

    @Override
    public double calculaCusto() {
        return pizza.calculaCusto() + 3.00;
    }
}

class Ovo extends ToppingDecorator {

    public Ovo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", ovo";
    }

    @Override
    public double calculaCusto() {
        return pizza.calculaCusto() + 4.00;
    }
}

class Presunto extends ToppingDecorator {

    public Presunto(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        return pizza.getDescricao() + ", presunto";
    }

    @Override
    public double calculaCusto() {
        return pizza.calculaCusto() + 6.00;
    }
}

public class Pizzaria {

    public static void main(String[] args) {

        Pizza marguerita = new MassaFinaPizza();
        marguerita = new Queijo(marguerita);
        marguerita = new Tomate(marguerita);

        System.out.println("PIZZA MARGUERITA");
        System.out.println("Descrição: " + marguerita.getDescricao());
        System.out.println("Custo: R$ " + marguerita.calculaCusto());

        System.out.println("---");

        Pizza portuguesa = new MassaEspessaPizza();
        portuguesa = new Queijo(portuguesa);
        portuguesa = new Ovo(portuguesa);
        portuguesa = new Tomate(portuguesa);

        System.out.println("PIZZA PORTUGUESA");
        System.out.println("Descrição: " + portuguesa.getDescricao());
        System.out.println("Custo: R$ " + portuguesa.calculaCusto());
    }
}