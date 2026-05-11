public class Carta {

    private String palo;
    private String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public int getPuntos() {

        return switch (valor) {
            case "A" -> 11;
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(valor);
        };
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}

