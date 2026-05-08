public class Blackjack {

    private Baraja baraja;
    private Descarte descarte;
    private Mano mano;
    private Menu menu;
    private Console console;

    public Blackjack() {
        baraja = new Baraja();
        descarte = new Descarte();
        mano = new Mano();
        menu = new Menu();
        console = new Console();
    }
}
