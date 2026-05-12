package entregas.moraDaniel;

import java.io.Console;

public class Blackjack {
    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Blackjack() {
        console = new Console();
    }

    public void jugar() {
        do {
            baraja = new Baraja();
            mano = new Mano();

            mano.agregarCarta(baraja.sacarCarta());
            mano.agregarCarta(baraja.sacarCarta());

            while (true) {
                console.writeln();
                console.writeln("--------------------");
                mano.mostrar();

                int puntaje = mano.calcularPuntaje();
                if (puntaje > 21) {
                    console.writeln("Perdió");
                    break;
                } else if (puntaje == 21) {
                    console.writeln("Ganó");
                    break;
                } else {
                    console.writeln("Sigue jugando");
                }

                console.writeln("--------------------");
                console.writeln("1. Pedir");
                console.writeln("2. Empezar de nuevo");
                console.writeln("3. Salir");
                console.writeln("--------------------");

                int opcion = console.readInt();

                if (opcion == 1) {
                    mano.agregarCarta(baraja.sacarCarta());
                } else if (opcion == 2) {
                    break;
                } else if (opcion == 3) {
                    return;
                }
            }
        } while (true);
    }
}
