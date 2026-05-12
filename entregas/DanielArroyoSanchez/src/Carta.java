public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
        console = new Console();
    }

    public void mostrar() {
        String numero = "?";
        String palo = "?";
        if (this.bocaArriba) {
            numero = NUMEROS[this.numero];
            palo = PALOS[this.palo];
        }
        console.write("[" + numero + " " + palo + " ]");
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }
