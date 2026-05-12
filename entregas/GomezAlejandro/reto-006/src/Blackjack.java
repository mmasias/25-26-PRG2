public class Blackjack {
    private Baraja baraja;
    private Mano manoJugador;
    private Console console;

    public Blackjack() {
        baraja = new Baraja();
        manoJugador = new Mano();
        console = new Console();
    }

    private void jugar() {
        boolean partidaActiva = true;

        do {
            if (manoJugador.estaVacia()) {
                repartirInicio();
            }

            this.mostrarInterfaz(manoJugador.getPuntuacion(), this.obtenerEstado());
            int opcion = console.readInt("Elige una opcion: ");

            switch (opcion) {
                case 1:
                    pedirCarta();
                    break;
                case 2:
                    manoJugador.nuevaMano();
                    break;
                case 3:
                    partidaActiva = false;
                    break;
                default:
                    console.writeln("Opcion no valida.");
                    break;
            }
        } while (!manoJugador.haGanado() && partidaActiva);
    }

    private void repartirInicio() {
        pedirCarta();
        pedirCarta();
    }

    private void pedirCarta() {
        Carta nuevaCarta = baraja.sacar();
        nuevaCarta.voltear();
        manoJugador.agregarCarta(nuevaCarta);
    }

    private void mostrarInterfaz(int puntos, String estado) {
        console.writeln("--------------------");
        console.write("Mano: ");
        manoJugador.mostrar();
        console.writeln("- Puntos: " + puntos + estado);
        console.writeln("--------------------");
        console.writeln("1. Pedir");
        console.writeln("2. Nueva ronda");
        console.writeln("3. Salir");
        console.writeln("--------------------");
    }

    private String obtenerEstado() {
        int puntos = manoJugador.getPuntuacion();
        if (puntos == 21) {
            return " ==> Blackjack!";
        } else if (puntos > 21) {
            return " ==> Te pasaste";
        } else {
            return " ==> Puedes pedir otra";
        }
    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}