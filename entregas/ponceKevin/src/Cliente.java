import java.util.Scanner;

public class Cliente {
    private static boolean jugando;
    private static Mano mano;
    private static Baraja baraja;

    public static void main(String[] args) {
        jugando = true;
        mano = new Mano();
        baraja = new baraja();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
        do {
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
        if (mano.calcularValor() > 21) {
            System.out.println("Perdiste");
            jugando = false;
        } else if (mano.calcularValor() == 21) {
            System.out.println("Ganaste");
            jugando = false;
        }
    }
}