public class Carta {
    private int palo;
    private int numero;
    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        console = new Console();
    }

    public void mostrar() {
        console.write("[" + NUMEROS[this.numero] + " " + PALOS[this.palo] + "]");
    }

    public int obtenerValor() {
        if (esAs()) return 11;
        if (esFigura()) return 10;
        return numero + 1;
    }

    private boolean esFigura() {
        return numero >= 9;
    }

    public boolean esAs() {
        return numero == 0;
    }
}
