public class Carta {

    private int palo;
    private int numero;
    private boolean estaVolteada;

    public Carta(int palo, int numero) {
        this.numero = numero;
        this.palo = palo;
        this.estaVolteada = true;

    }

    public void mostrar() {
        if (estaVolteada) {
            System.out.print("[ X ]");
        } else {
            System.out.print("[" + queNumeroEs() + ", " + quePaloEs() + "]");
        }
    }

    private String quePaloEs() {

        String[] simbolos = { "P", "C", "T", "D" };
        return simbolos[palo];

    }

    public void voltearCarta() {
        estaVolteada = !estaVolteada;
    }

    public int getPalo() {
        return this.palo;
    }

    public int getNumero() {
        return this.numero;
    }

    public boolean esRoja() {
        return getPalo() == 1 || getPalo() == 3;
    }

    public boolean estaBocaAbajo() {
        return this.estaVolteada;
    }

    private String queNumeroEs() {
        String[] caras = { "As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        return caras[numero];
    }

    public int puntajeDeLaCarta() {
        int puntaje = this.numero + 1;
        if (puntaje > 9) {
            puntaje = 10;
        }
        return puntaje;
    }

    public boolean esAs() {
        return this.numero == 0;
    }

}
