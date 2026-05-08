public class Carta {
    private String palo;
    private String valor;
    Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public boolean esAs() {
        return valor.equals("A");
    }

    public int getValor() {
        return valor;
    }
}