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
        rondaBlackjack();
    }

    private void rondaBlackjack() {
        mano.limpiar();
        mano.agregarCarta(baraja.repartir());
        mano.agregarCarta(baraja.repartir());
        System.out.println(mano);

        boolean sigue = true;

        while (sigue && mano.estaBuena()) {
            System.out.println("1. Pedir");
            System.out.println("2. Plantarse");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                mano.agregarCarta(baraja.repartir());
                System.out.println(mano);
            } else {
                sigue = false;
            }
        }

        if (mano.calcularPuntos() == 21) {
            System.out.println("¡Ganó! BLACKJACK");
        } else if (mano.estaBuena()) {
            System.out.println("Se plantó con " + mano.calcularPuntos());
        } else {
            System.out.println("Perdió (se pasó de 21)");
        }
    }
}