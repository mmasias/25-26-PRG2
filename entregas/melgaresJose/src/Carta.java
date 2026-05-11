public class Carta {

    private int palo;
    private int numero;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        console = new Console();
    }

    public void mostrar() {
        String numero = NUMEROS[this.numero];
        String palo = PALOS[this.palo];
        console.write("[" + numero + " " + palo + " ]");
    }

    public int obtenerValor() {
        if(esAs()){
            return 11;
        }
        else if (esRey()) {
            return 10;
        }
        else {
            return numero +1;
        }
    }

    private boolean esRey() {
        return numero >= 9;
    }
    public boolean esAs() {
        return numero==0;
    }


    public boolean igualPalo(Carta carta) {
        return this.palo == carta.palo;
    }    

}