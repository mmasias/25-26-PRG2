public class Blackjack {

    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Blackjack() {

        baraja = new Baraja();
        mano = new Mano();
        console = new Console();
    }

    public void iniciar() {

        boolean jugando = true;

        while (jugando) {

            if (mano.estaVacia()) {

                repartirInicial();
            }

            mostrarMenu();

            int opcion = console.readInt();

            switch (opcion) {

                case 1:

                    pedirCarta();

                    if (mano.getPuntuacion() >= 21) {

                        mostrarMenu();
                    }

                    break;

                case 2:

                    reiniciarPartida();
                    break;

                case 3:

                    jugando = false;
                    break;

                default:

                    console.writeln("Opción no válida");
            }
        }

        console.writeln("Fin del juego");
    }

    private void repartirInicial() {

        Carta primera = baraja.robarCarta();
        Carta segunda = baraja.robarCarta();

        primera.voltear();
        segunda.voltear();

        mano.añadir(primera);
        mano.añadir(segunda);
    }

    private void pedirCarta() {

        Carta carta = baraja.robarCarta();

        carta.voltear();

        mano.añadir(carta);
    }

    private void reiniciarPartida() {

        baraja = new Baraja();
        mano = new Mano();
    }

    private void mostrarMenu() {

        console.writeln("--------------------");
        console.write("Mano: ");

        mano.mostrar();

        console.writeln(" - Puntaje: "+ mano.getPuntuacion()+ obtenerEstado());

        console.writeln("--------------------");
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        console.writeln("--------------------");
    }

    private String obtenerEstado() {

        int puntos = mano.getPuntuacion();

        if (puntos == 21) {

            return " ==> Ganó";
        }

        if (puntos > 21) {

            return " ==> Perdió";
        }

        return " ==> Sigue jugando";
    }

    public static void main(String[] args) {

        Blackjack blackjack = new Blackjack();
        blackjack.iniciar();
    }
}