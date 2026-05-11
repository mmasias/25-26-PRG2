public class Carta {
    private int palo;
    private int numero;
    private boolean bocaArriba;
    private final String[] PALOS = { "P", "C", "D", "T" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        this.bocaArriba = false;
    }

    public void mostrar() {
        if (this.bocaArriba) {
            System.out.print("[" + NUMEROS[this.numero] + " " + PALOS[this.palo] + "]");
        } else {
            System.out.print("[? ?]");
        }
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public int getValor() {
        if (numero >= 9) { // J, Q, K
            return 10;
        } else if (numero == 0) { // As
            return 11;
        } else {
            return numero + 1;
        }
    }
}