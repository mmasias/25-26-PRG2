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

    public void mostrarCarta() {
        System.out.println(valor + " de " + palo);
    }
}