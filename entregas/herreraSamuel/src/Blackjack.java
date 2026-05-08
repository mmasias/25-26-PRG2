public class Blackjack {
    private Baraja baraja;
    private Mano mano;
    private Menu menu;

    public Blackjack() {
        this.baraja = new Baraja();
        this.menu = new Menu();
        this.mano = new Mano();
    }

}
