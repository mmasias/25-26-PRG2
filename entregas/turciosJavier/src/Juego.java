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
    }
}