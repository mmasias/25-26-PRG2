import java.util.Scanner;

class Juego {
    private final Baraja baraja;
    private final Mano mano;
    private final Scanner scanner;

    public Juego() {
        baraja = new Baraja();
        mano = new Mano();
        scanner = new Scanner(System.in);
    }

    public void jugar() {
        boolean jugando = true;

        while (jugando) {
            mano.limpiar();
            rondaBlackjack();

            System.out.println("1. Empezar de nuevo");
            System.out.println("2. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 2) {
                jugando = false;
                System.out.println("¡Hasta luego!");
            }
        }
    }

    private void rondaBlackjack() {
        mano.agregarCarta(baraja.repartir());
        mano.agregarCarta(baraja.repartir());

        boolean sigue = true;

        while (sigue && mano.estaBuena()) {
            System.out.println("--------------------");
            System.out.println(mano);
            System.out.println("==> Sigue jugando");
            System.out.println("--------------------");
            System.out.println("1. Pedir");
            System.out.println("2. Plantarse");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                mano.agregarCarta(baraja.repartir());
            } else {
                sigue = false;
            }
        }

        System.out.println("--------------------");
        System.out.println(mano);
        if (mano.calcularPuntos() == 21) {
            System.out.println("==> ¡Ganó! BLACKJACK");
        } else if (mano.estaBuena()) {
            System.out.println("==> Se plantó con " + mano.calcularPuntos());
        } else {
            System.out.println("==> Perdió (se pasó de 21)");
        }
        System.out.println("--------------------");
    }
}