public class Carta {
    private String palo;
    private String rango;

    public Carta(String palo, String rango) {
        this.palo = palo;
        this.rango = rango;
    }

    public String toString() {
        return"[" + rango + " " + palo + "]";
    }

    public int getValorNumerico() {

        if (rango.equals("J") || rango.equals("Q") || rango.equals("K")) {
            return 10;
        }

        if (rango.equals("A")) {
            return 11;
        }

        return Integer.parseInt(rango);
    }

    public String getRango() {
        return rango;
    }
}