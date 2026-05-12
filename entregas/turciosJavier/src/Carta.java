class Carta {
    private final String valor;
    private final String palo;

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

    public int getPuntos() {
        if (valor.equals("A")) {
            return 11;
        }
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        }
        return Integer.parseInt(valor);
    }

    @Override
    public String toString() {
        return "[" + valor + " " + palo + "]";
    }
}