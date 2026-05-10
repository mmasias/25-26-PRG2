import java.util.*;

public class Baraja {
    private List<Carta> cartas;


    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = {"♥", "♦", "♣", "♠"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);
    }
}
