import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    ArrayList<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        String[] palos = {"♥", "♣", "♦", "♠"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String p : palos) {
            for (String v : valores) {
                cartas.add(new Carta(v, p));
            }
        }
        Collections.shuffle(cartas); 
    }

    public Carta darCarta() {
        
        return cartas.remove(cartas.size() - 1);
    }
}
