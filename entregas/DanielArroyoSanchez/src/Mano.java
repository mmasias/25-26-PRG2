public class Mano {

    private Carta[] cartas;
    private Console console;
    private int ultima;

    public Mano() {
        this.cartas = new Carta[20];
        this.ultima = 0;
        this.console = new Console();
    }
