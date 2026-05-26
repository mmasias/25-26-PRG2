import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private int siguienteCarta;

    public Baraja() {
        this.cartas = new Carta[52];
        this.siguienteCarta = 0;

        int index = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 0; numero < 13; numero++) {
                cartas[index] = new Carta(palo, numero);
                index++;
            }
        }
        this.mezclar();
    }

    public void mezclar() {
        Random random = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int j = random.nextInt(cartas.length);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        this.siguienteCarta = 0;
    }

    public Carta extraerCarta() {
        if (siguienteCarta < cartas.length) {
            return cartas[siguienteCarta++];
        } else {
            this.mezclar();
            return extraerCarta();
        }
    }

    public void mostrarContenido() {
        for (Carta carta : cartas) {
            carta.mostrar();
        }
    }
}