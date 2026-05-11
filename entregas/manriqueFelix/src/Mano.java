import java.util.ArrayList;
import java.util.List;

public class Mano {
    private final List<Carta> cartas = new ArrayList<>();

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public void limpiar() {
        cartas.clear();
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public int obtenerPuntaje() {
        int puntaje = 0;
        int cantidadAses = 0;

        for (Carta carta : cartas) {
            puntaje += carta.getRango().valor;
            if (carta.getRango() == Rango.AS) {
                cantidadAses++;
            }
        }
        while (puntaje > 21 && cantidadAses > 0) {
            puntaje -= 10;
            cantidadAses--;
        }

        return puntaje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta.toString());
        }
        return sb.toString();
    }
}