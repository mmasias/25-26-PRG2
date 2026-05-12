package blackjack;

public class Carta {
    private final String valor;
    private final String palo;

    public Carta(String valor, String palo) {
        validarCarta(valor, palo);
        this.valor = valor;
        this.palo = palo;
    }

    private void validarCarta(String valor, String palo) {
        // Validación de valores y palos válidos
    }

    public String getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    public int obtenerValor() {
        if (valor.equals("A")) {
            return 11;
        } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(valor);
        }
    }

    public String obtenerSimbolo() {
        return obtenerSimboloPalo(palo);
    }

    private String obtenerSimboloPalo(String nombrePalo) {
        return switch (nombrePalo) {
            case "CORAZONES" -> "♥";
            case "DIAMANTES" -> "♦";
            case "TREBOLES" -> "♣";
            case "PICAS" -> "♠";
            default -> "";
        };
    }

    public String obtenerRepresentacion() {
        return "[" + valor + " " + obtenerSimbolo() + "]";
    }
}
