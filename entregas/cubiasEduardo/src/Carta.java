public class Carta {

    private int palo;
    private int numero;

    private final String[] PALOS = { "♠", "♣", "♦", "♥" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        console = new Console();
    }

    public void mostrar() {
        console.write("[" + NUMEROS[numero] + " " + PALOS[palo] + "]");
    }

    public boolean esAs() {
        return numero == 0;
    }

    public boolean esFigura() {
        return numero >= 10;
    }

    public int getValor() {
        return numero + 1;
    }
}