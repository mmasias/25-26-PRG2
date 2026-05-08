import java.util.Scanner;

public class Cliente {
    private static boolean jugando;
    private static Mano mano;
    private static Baraja baraja;
    private static final int NUMERO_MAXIMO_PUNTOS = 21;

    public static void main(String[] args) {
        jugando = true;
        mano = new Mano();
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
        System.out.println("1.pedir carta");
        System.out.println("2.Reiniciar juego");
        System.out.println("3. Salir");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> mano.agregarCarta(baraja.sacarCarta());
            case 2 -> reiniciarPartida();
            case 3 -> jugando = false;
        }
    }

    private static void reiniciarPartida() {
        mano = new Mano();
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
            System.out.println(mensaje);
            jugando = false;
        }
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}