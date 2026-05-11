import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> cartas;

    public Baraja() {
        this.cartas = new ArrayList<>();
        String[] palos = {"Corazon", "Diamante", "Trebol", "Espada"};
        String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String p : palos) {
            for (String r : rangos) {
                this.cartas.add(new Carta(p, r));
            }
        }
        barajear();
    }

    public Carta repartir() {
        if (cartas.isEmpty()) {
            return null;
        }

        return this.cartas.remove(this.cartas.size() - 1);
    }
}