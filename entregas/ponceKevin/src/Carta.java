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

    private String simboloPalo() {
        return switch (palo) {
            case "Corazones" -> "♥";
            case "Diamantes" -> "♦";
            case "Tréboles" -> "♣";
            case "Picas" -> "♠";
            default -> palo.substring(0, 1);
        };
    }
}