package entregas.moraDaniel;

public class Carta {

    private String valor;
    private String palo;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public int getValorNumerico() {
        switch (valor) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11;
            default:
                return Integer.parseInt(valor);
        }
    }

    @Override
    public String toString() {
        return "[" + valor + palo + "]";
    }
}
