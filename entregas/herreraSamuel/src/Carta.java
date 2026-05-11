public class Carta {
    private String palo;
    private String rango;

    public Carta(String palo, String rango) {
        this.palo = palo;
        this.rango = rango;
    }

    public int obtenerValor() {
        return switch (rango) {
            case "A" -> 11; 
            case "J", "Q", "K" -> 10;
            default -> Integer.parseInt(rango);
        };
    }

    public boolean esAs() {
        return rango.equals("A");
    }

    public void mostrar() {
        System.out.print("[" + rango + " " + palo + "]");
    }
}