package entregas.moraDaniel;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;
    private Console console;

    public Mano() {
        cartas = new ArrayList<>();
        console = new Console();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int calcularPuntaje() {
        int puntaje = 0;
        int ases = 0;

        for (Carta carta : cartas) {
            puntaje += carta.getValorNumerico();
            if (carta.getValor().equals("A")) {
                ases++;
            }
        }

        while (puntaje > 21 && ases > 0) {
            puntaje -= 10;
            ases--;
        }

        return puntaje;
    }

    public void mostrar() {
        console.write("Mano: ");
        for (Carta carta : cartas) {
            console.write(carta.toString());
        }
        console.writeln(" - Puntaje: " + calcularPuntaje());
    }
}
