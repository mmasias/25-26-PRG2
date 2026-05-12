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
                carta1.voltear();
                carta2.voltear();
                mano.añadir(carta1);
                mano.añadir(carta2);
            }
            this.mostrarInterfaz(mano.getPuntuacion(), this.obtenerEstado());
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

            mano.getPuntuacion();
        } while (!hayaGanado && estaJugando);
    }

    private void mostrarInterfaz(int puntos, String estado) {
        console.writeln("--------------------");
        console.write("Mano: ");
        mano.mostrar();
        console.writeln(" - Puntaje: " + puntos + estado);
        console.writeln("--------------------");
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        console.writeln("--------------------");

    }

    private String obtenerEstado() {
        int puntos = mano.getPuntuacion();
        if (puntos == 21) {
            return " ==> ¡Ganó!";
        } else if (puntos > 21) {
            return " ==> Perdió";
        } else {
            return " ==> Sigue jugando";
        }
    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}