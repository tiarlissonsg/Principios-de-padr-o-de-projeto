public class Celular {
    class Galaxy8 implements Celular {
        @Override
        public void fazLigacao() { System.out.println("Galaxy 8: Fazendo ligação..."); }
        @Override
        public void tiraFoto() { System.out.println("Galaxy 8: Tirando foto..."); }
    }

    class Galaxy20 implements Celular {
        @Override
        public void fazLigacao() { System.out.println("Galaxy 20: Fazendo ligação..."); }
        @Override
        public void tiraFoto() { System.out.println("Galaxy 20: Tirando foto..."); }
    }

    class IPhoneX implements Celular {
        @Override
        public void fazLigacao() { System.out.println("iPhone X: Fazendo ligação..."); }
        @Override
        public void tiraFoto() { System.out.println("iPhone X: Tirando foto..."); }
    }

    class IPhoneS implements Celular {
        @Override
        public void fazLigacao() { System.out.println("iPhone S: Fazendo ligação..."); }
        @Override
        public void tiraFoto() { System.out.println("iPhone S: Tirando foto..."); }
    }
}
