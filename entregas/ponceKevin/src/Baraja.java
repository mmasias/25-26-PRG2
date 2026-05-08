import java.util.Random;

public class Baraja {
    Carta[] cartas = new Carta[52];

    Baraja() {
        inicializarBaraja();
        mezclar();
    }

    public Carta sacarCarta() {
        return new Carta();
    }

    private void mezclar() {
        Random random = new java.util.Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    private void inicializarBaraja() {
        String[] palos = { "Corazones", "Diamantes", "Tréboles", "Picas" };
        String[] valores = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        int index = 0;
        for (String palo : palos) {
            for (String valor : valores) {
                cartas[index] = new Carta(palo, valor);
                index++;
            }
        }
    }
}