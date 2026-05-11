public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

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

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero + 1;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() || this.negro() && carta.rojo();
    }

    private boolean negro() {
        return this.palo==0 || this.palo==1;
    }

    private boolean rojo() {
        return !this.negro();
    }

    public boolean esAs() {
        return numero==0;
    }

    public boolean igualPalo(Carta carta) {
        return this.palo == carta.palo;
    }    

    public int getNumero() {
        return this.numero;
    }
}