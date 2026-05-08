public class Cliente {
    private static boolean jugando;
    private static Mano mano;
    private static Baraja baraja;
    private static final int NUMERO_MAXIMO_PUNTOS = 21;
    private static final Console console = new Console();

    public static void main(String[] args) {
        jugando = true;
        mano = new Mano(console);
        baraja = new Baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
        do {
            limpiarPantalla();
            mano.mostrarMano();
            menu();
            procesarFinal();
        } while (jugando);
    }

    private static void menu() {
        console.writeln("1.pedir carta");
        console.writeln("2.Reiniciar juego");
        console.writeln("3. Salir");
        int opcion = console.readInt();
        switch (opcion) {
            case 1 -> mano.agregarCarta(baraja.sacarCarta());
            case 2 -> reiniciarPartida();
            case 3 -> jugando = false;
        }
    }

    private static void reiniciarPartida() {
        mano = new Mano(console);
        baraja = new Baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
    }

    private static void procesarFinal() {
        int valorMano = mano.calcularValor();
        if (valorMano >= NUMERO_MAXIMO_PUNTOS) {
            mano.mostrarMano();
            String mensaje = valorMano == NUMERO_MAXIMO_PUNTOS
                    ? "¡Ganaste!"
                    : "Perdiste te has pasado de " + NUMERO_MAXIMO_PUNTOS;
            console.writeln(mensaje);
            jugando = false;
        }
    }

    private static void limpiarPantalla() {
        console.cleanScreen();
    }
}