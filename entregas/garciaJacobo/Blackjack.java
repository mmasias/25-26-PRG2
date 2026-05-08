
public class Blackjack {
    private Baraja baraja;
    private Mano mano;

    public Blackjack() {
        baraja = new Baraja();
        mano = new Mano();
    }

    private void jugar() {

    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}
