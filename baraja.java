import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private List<Carta> cartas;

    public Baraja() {
        cartas = new ArrayList<>();
    }

    public Carta sacarCarta() {

        if (cartas.isEmpty()) {
            return null;
        }

        return cartas.remove(0);
    }
}