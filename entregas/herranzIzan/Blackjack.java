public class Blackjack {
    private Console console;
    private int puntaje;
    private Baraja baraja;
    private Mano mano;
    private Menu menu;
    private final int CANTIDAD_INICIAL = 2;

    public Blackjack() {
        console = new Console();
        menu = new Menu();
        reiniciar();
    }

    private void jugar() {
        boolean estaJugando = true;
        boolean haPerdido = false;
        do {
            mostrarTapete();
            menu.mostrar();
            switch (menu.pedirOpcion()) {
                case 1 -> mano.pedirCarta(baraja);
                case 2 -> reiniciar();
                case 3 -> estaJugando = false;
            }
            puntaje = mano.contarPuntos();
            haPerdido = puntaje > 21;
        } while (estaJugando && !haPerdido);

        if (haPerdido) {
            mostrarTapete();
            console.writeln("NO GANASTE");
        } else {
            console.writeln("GANASTE");
        }
    }

    private void repartir() {
        for (int i = 0; i < CANTIDAD_INICIAL; i++) {
            mano.pedirCarta(baraja);
        }
    }

    private void reiniciar() {
        puntaje = 0;
        baraja = new Baraja();
        mano = new Mano();
        repartir();
    }

    private void mostrarTapete() {
        console.cleanScreen();
        linea();
        console.write("Mano: ");
        mano.mostrar();
        console.writeln();
        linea();
        console.writeln("Puntaje: " + puntaje);
        linea();
    }

    private void linea() {
        console.writeln("-".repeat(30));
    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}
