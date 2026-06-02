public class MainCelular {
    public static void main(String[] args) {
        FabricanteCelular apple = Apple.getInstance();
        FabricanteCelular samsung = Samsung.getInstance();

        Celular meuIphoneX = apple.constroiCelular("IPhoneX");
        Celular meuGalaxy20 = samsung.constroiCelular("Galaxy20");

        System.out.println("--- Testando iPhone X ---");
        if (meuIphoneX != null) {
            meuIphoneX.fazLigacao();
            meuIphoneX.tiraFoto();
        }

        System.out.println("\n--- Testando Galaxy 20 ---");
        if (meuGalaxy20 != null) {
            meuGalaxy20.fazLigacao();
            meuGalaxy20.tiraFoto();
        }
    }
}
