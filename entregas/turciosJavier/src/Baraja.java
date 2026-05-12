import java.util.ArrayList;
import java.util.Collections;

class Baraja {
    private ArrayList<Carta> cartas;

    public Baraja() {
        crearBaraja();
    }

    private void crearBaraja() {
        cartas = new ArrayList<>();
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] palos = {"♥", "♣", "♦", "♠"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }

        Collections.shuffle(cartas);
    }

    public Carta repartir() {
        if (cartas.isEmpty()) {
            crearBaraja();
        }
        return cartas.remove(0);
    }
}