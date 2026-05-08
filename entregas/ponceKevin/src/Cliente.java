public class Cliente {
    private static final String SEPARADOR = "--------------------";
    private static final String ESTADO_SIGA = "Sigue jugando";
    private static final String ESTADO_GANO = "Ganó";
    private static final String ESTADO_PERDIO = "Perdió";
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
            String estado = procesarFinal();
            imprimirSeparador();
            mano.mostrarMano(estado);
            imprimirSeparador();
            menu(estado);
            imprimirSeparador();
        } while (jugando);
    }

    private static void menu(String estado) {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        int opcion = console.readInt();
        switch (opcion) {
            case 1 -> {
                if (ESTADO_SIGA.equals(estado)) {
                    mano.agregarCarta(baraja.sacarCarta());
                }
            }
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

    private static String procesarFinal() {
        int valorMano = mano.calcularValor();
        if (valorMano > NUMERO_MAXIMO_PUNTOS) {
            return ESTADO_PERDIO;
        }
        if (valorMano == NUMERO_MAXIMO_PUNTOS) {
            return ESTADO_GANO;
        }
        return ESTADO_SIGA;
    }

    private static void imprimirSeparador() {
        console.writeln(SEPARADOR);
    }
}