public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;
    private final int MIN_PARA_VALOR_DIEZ = 9;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

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

    public boolean esRey() {
        return numero == 12;
    }

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() || this.negro() && carta.rojo();
    }

    private boolean rojo() {
        return !this.negro();
    }

    private boolean negro() {
        return this.palo == 0 || this.palo == 1;
    }

    public boolean esAs() {
        return this.numero == 0;
    }

    public int valor21() {
        if (this.esAs()) {
            return 1;
        }
        if (this.numero >= MIN_PARA_VALOR_DIEZ) {
            return 10;
        }
        return this.numero + 1;
    }
}