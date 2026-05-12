public class Carta {

    private int palo;
    private int rango;
    private boolean bocaArriba;

    private static final String[] PALOS = { "Picas", "Corazones", "Diamantes", "Treboles" };
    private static final String[] RANGOS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int rango) {
        this.palo = palo;
        this.rango = rango;
        bocaArriba = false;
        console = new Console();
    }

    public void mostrar() {
        String textoRango = "?";
        String textoPalo = "?";

        if (this.bocaArriba) {
            textoRango = RANGOS[this.rango];
            textoPalo = PALOS[this.palo];
        }
        console.write("[" + textoRango + " de " + textoPalo + "] ");
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return rango == 0;
    }

    public int getValor() {
        if (rango >= 9) {
            return 10;
        } else if (rango == 0) {
            return 11;
        } else {
            return rango + 1;
        }
    }
}
