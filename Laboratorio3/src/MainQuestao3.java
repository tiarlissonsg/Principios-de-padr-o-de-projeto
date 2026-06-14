/*
Problema proposto:
Um hospital adquiriu um sistema moderno de monitoramento que trabalha com temperaturas em graus Celsius.
Porém, alguns sensores antigos dos Estados Unidos fornecem leituras em Fahrenheit.
O padrão Adapter é utilizado para permitir que os sensores legados continuem sendo utilizados sem modificar o sistema moderno.
*/

interface SensorTemperatura {
    double lerTemperaturaCelsius();
}

class SensorAmericano {

    public double getTemperaturaFahrenheit() {
        return 98.6;
    }
}

class SensorAdapter implements SensorTemperatura {

    private SensorAmericano sensorLegado;
    public SensorAdapter(SensorAmericano sensorLegado) {
        this.sensorLegado = sensorLegado;
    }

    @Override
    public double lerTemperaturaCelsius() {
        double fahrenheit = sensorLegado.getTemperaturaFahrenheit();
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class MainQuestao3 {

    public static void main(String[] args) {
        SensorAmericano sensorVelho = new SensorAmericano();
        SensorTemperatura sensorModerno =
                new SensorAdapter(sensorVelho);
        System.out.println("Temperatura do sensor antigo: "
                + sensorVelho.getTemperaturaFahrenheit()
                + " °F");
        System.out.println("Leitura convertida: "
                + sensorModerno.lerTemperaturaCelsius()
                + " °C");
    }
}