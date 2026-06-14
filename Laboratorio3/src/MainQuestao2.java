class CalculadoraBinaria {

    public String somar(String a, String b) {
        int valA = Integer.parseInt(a,2);
        int valB = Integer.parseInt(b, 2);
        return Integer.toBinaryString(valA + valB);
    }

    public String subtrair(String a, String b) {
        int valA = Integer.parseInt(a, 2);
        int valB = Integer.parseInt(b, 2);
        return Integer.toBinaryString(valA - valB);
    }
}

interface CalculadoraDecimal {
    int somar(int a, int b);
    int subtrair(int a, int b);
    int multiplicar(int a, int b);
}

class CalculadoraAdapter implements CalculadoraDecimal {

    private CalculadoraBinaria calcBinaria;
    public CalculadoraAdapter(CalculadoraBinaria calcBinaria) {
        this.calcBinaria = calcBinaria;
    }

    @Override
    public int somar(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBin = calcBinaria.somar(binA, binB);
        return Integer.parseInt(resultadoBin, 2);
    }

    @Override
    public int subtrair(int a, int b) {
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        String resultadoBin = calcBinaria.subtrair(binA, binB);
        return Integer.parseInt(resultadoBin, 2);
    }

    @Override
    public int multiplicar(int a, int b) {
        int resultado = 0;

        for (int i = 0; i < Math.abs(b); i++) {
            resultado = somar(resultado, Math.abs(a));
        }

        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            resultado = subtrair(0, resultado);
        }

        return resultado;
    }
}

public class MainQuestao2 {

    public static void main(String[] args) {

        CalculadoraBinaria calcBin = new CalculadoraBinaria();
        CalculadoraDecimal calc = new CalculadoraAdapter(calcBin);
        System.out.println("10 + 5 = " + calc.somar(10, 5));
        System.out.println("20 - 8 = " + calc.subtrair(20, 8));
        System.out.println("4 * 3 = " + calc.multiplicar(4, 3));
        System.out.println("10 + 5 = " + calc.somar(10, 5));
        System.out.println("20 - 8 = " + calc.subtrair(20, 8));
        System.out.println("4 * 3 = " + calc.multiplicar(4, 3));
        System.out.println("\nOperações binárias:");
        System.out.println("1010 + 0101 = " +
                calcBin.somar("1010", "0101"));
        System.out.println("10100 - 1000 = " +
                calcBin.subtrair("10100", "1000"));
    }
}