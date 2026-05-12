public class Dealer {

    private Baraja baraja;
    private Console console;
    private Mano mano;

    public Dealer() {
        this.console = new Console();
        this.reiniciar();
    }
