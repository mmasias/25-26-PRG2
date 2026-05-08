public class Cliente {
    private static final String SEPARADOR = "--------------------";
    private static boolean jugando;
    private static Mano mano;
    private static Baraja baraja;
    private static final int NUMERO_MAXIMO_PUNTOS = 21;
    private static final Console console = new Console();

    private enum Estado {
        SIGUE("Sigue jugando"),
        GANO("Ganó"),
        PERDIO("Perdió");

        private final String etiqueta;

        Estado(String etiqueta) {
            this.etiqueta = etiqueta;
        }

        public String etiqueta() {
            return etiqueta;
        }
    }

    public static void main(String[] args) {
        mano = new Mano(console);
        baraja = new Baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
        jugando = true;
        do {
            Estado estado = procesarFinal();
            imprimirSeparador();
            mano.mostrarMano(estado.etiqueta());
            imprimirSeparador();
            menu(estado);
            imprimirSeparador();
        } while (jugando);
    }

    private static void menu(Estado estado) {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        int opcion = console.readInt();
        switch (opcion) {
            case 1 -> {
                if (estado == Estado.SIGUE) {
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

    private static Estado procesarFinal() {
        int valorMano = mano.calcularValor();
        if (valorMano >= NUMERO_MAXIMO_PUNTOS) {
            jugando = false;
        }
        return valorMano >= NUMERO_MAXIMO_PUNTOS
                ? (valorMano == NUMERO_MAXIMO_PUNTOS ? Estado.GANO : Estado.PERDIO)
                : Estado.SIGUE;
    }

    private static void imprimirSeparador() {
        console.writeln(SEPARADOR);
    }
}