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

    public String getValor() {
        return valor;
    }

    public String toString() {
        return "[" + valor + " " + simboloPalo() + "]";
    }

    private char simboloPalo() {
        if (palo.equals("Corazones")) {
            return '♥';
        }
        if (palo.equals("Diamantes")) {
            return '♦';
        }
        if (palo.equals("Tréboles")) {
            return '♣';
        }
        return '♠';
    }
}