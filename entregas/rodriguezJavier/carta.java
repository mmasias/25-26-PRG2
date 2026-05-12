public class Carta {
    private String valor;

    private String palo;
    
    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }
    
    public int getValorNumerico() {
    }
    
    public String toString() {
        return "[" + this.valor + " " + this.palo + "]";
    }
}