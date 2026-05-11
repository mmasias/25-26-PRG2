public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

    private final String[] PALOS = {"♥", "♣", "♦", "♠"};
    private final String[] NUMEROS = {"A", "2", "3", "4", "5", "6","7", "8", "9", "10", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        this.bocaArriba = false;

        console = new Console();
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public int getValor() {

        if (numero == 0) {
            return 11;
        }

        if (numero >= 10) {
            return 10;
        }

        return numero + 1;
    }

    public void mostrar() {

        String numeroMostrar = "?";
        String paloMostrar = "?";

        if (bocaArriba) {
            numeroMostrar = NUMEROS[numero];
            paloMostrar = PALOS[palo];
        }

        console.write("[" + numeroMostrar + " " + paloMostrar + "]");
    }
}