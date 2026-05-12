public class Blackjack {

    private Console console = new Console();
    private Mano mano;
    private Menu menu;
    private Dealer dealer;

    public Blackjack() {
        mano = new Mano();
        menu = new Menu();
        dealer = new Dealer();

    }
