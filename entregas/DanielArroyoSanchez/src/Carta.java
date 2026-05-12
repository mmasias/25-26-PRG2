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

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero + 1;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public int getValor() {
        if (esAs()) {
            return 11;
        }
        if (this.numero >= 9) {
            return 10;
        }
        return this.numero + 1;
    }

    

}
