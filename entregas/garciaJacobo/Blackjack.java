
public class Blackjack {
    private Baraja baraja;
    private Mano mano;
    private Console console;

    public Blackjack() {
        baraja = new Baraja();
        mano = new Mano();
        console = new Console();
    }

    private void jugar() {
        boolean hayaGanado;
        boolean estaJugando = true;

        do {
            if (mano.estaVacia()) {
                Carta carta1 = baraja.sacar();
                Carta carta2 = baraja.sacar();
                mano.añadir(carta1);
                mano.añadir(carta2);
            }
            int opcion = console.readInt();
            switch (opcion) {
                case 1 -> {
                    Carta nueva = baraja.sacar();
                    nueva.voltear();
                    mano.añadir(nueva);
                }

                case 2 -> mano.nuevaMano();
                case 3 -> estaJugando = false;
            }
            hayaGanado = mano.haGanado();
            mano.mostrar();
            mano.getPuntuacion();
        } while (!hayaGanado && estaJugando);

    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}
