import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private final List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
        for (Palo palo : Palo.values()) {
            for (Rango rango : Rango.values()) {
                cartas.add(new Carta(rango, palo));
            }
        }
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) {
            throw new IllegalStateException("No quedan cartas en la baraja.");
        }
        return cartas.remove(cartas.size() - 1);
    }
}