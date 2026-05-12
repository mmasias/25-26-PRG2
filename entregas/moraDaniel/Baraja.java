package entregas.moraDaniel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    private List<Carta> cartas;
    private int indiceActual;

    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = { "♥", "♦", "♣", "♠" };
        String[] valores = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }

        Collections.shuffle(cartas);
        indiceActual = 0;
    }

    public Carta sacarCarta() {
        if (indiceActual < cartas.size()) {
            return cartas.get(indiceActual++);
        }
        return null;
    }
}
