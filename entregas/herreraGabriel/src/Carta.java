public class Carta {
    private int palo;
    private int numero;
    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        this.console = new Console();
    }

    public int obtenerValorNumerico() {
        if (numero == 0) return 11;
        if (numero >= 9) return 10;
        return numero + 1;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public void mostrar() {
        String[] palosStr = {"♥", "♦", "♣", "♠"};
        String[] numerosStr = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        console.write("[" + numerosStr[numero] + " " + palosStr[palo] + "]");
    }
}