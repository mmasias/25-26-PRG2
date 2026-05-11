public class Blackjack {

    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Blackjack() {
        this.baraja = new Baraja();
        this.mano = new Mano();
        this.console = new Console();
    }

    public void jugar() {

        boolean salir = false;

        do {

            if (mano.estaVacia()) {
                this.repartirInicial();
            }

            this.mostrarMenu();

            int opcion = console.readInt();

            switch (opcion) {

                case 1:
                    this.pedirCarta();
                    break;

                case 2:
                    this.reiniciarPartida();
                    break;

                case 3:
                    salir = true;
                    break;
            }

        } while (!salir);
    }

    private void repartirInicial() {

        Carta primera = baraja.sacar();
        Carta segunda = baraja.sacar();

        primera.voltear();
        segunda.voltear();

        mano.añadir(primera);
        mano.añadir(segunda);
    }

    private void pedirCarta() {

        Carta nuevaCarta = baraja.sacar();

        nuevaCarta.voltear();

        mano.añadir(nuevaCarta);
    }

    private void reiniciarPartida() {

        mano.nuevaMano();
        baraja = new Baraja();
    }

    private void mostrarMenu() {

        console.writeln("--------------------");

        console.write("Mano: ");
        mano.mostrar();

        console.writeln(
                " - Puntaje: " +
                mano.getPuntuacion() +
                this.estadoPartida()
        );

        console.writeln("--------------------");
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        console.writeln("--------------------");
    }

    private String estadoPartida() {

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
        new Blackjack().jugar();
    }
}