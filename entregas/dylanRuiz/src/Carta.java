public class Carta {
    String valor;
    String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }
    
    @Override
    public String toString() {
        return "[" + valor + " " + palo + "]";
    }
}
