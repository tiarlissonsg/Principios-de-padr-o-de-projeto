public class Fabricante class Apple implements FabricanteCelular {
    private static Apple instance;
    private Apple() {}

    public static Apple getInstance() {
        if (instance == null) {
            instance = new Apple();
        }
        return instance;
    }

    @Override
    public Celular constroiCelular(String modelo) {
        if (modelo.equalsIgnoreCase("IPhoneX")) return new IPhoneX();
        if (modelo.equalsIgnoreCase("IPhoneS")) return new IPhoneS();
        System.out.println("Modelo da Apple não encontrado.");
        return null;
    }
}

class Samsung implements FabricanteCelular {
    private static Samsung instance;

    private Samsung() {}

    public static Samsung getInstance() {
        if (instance == null) {
            instance = new Samsung();
        }
        return instance;
    }

    @Override
    public Celular constroiCelular(String modelo) {
        if (modelo.equalsIgnoreCase("Galaxy8")) return new Galaxy8();
        if (modelo.equalsIgnoreCase("Galaxy20")) return new Galaxy20();
        System.out.println("Modelo da Samsung não encontrado.");
        return null;
    }
}
