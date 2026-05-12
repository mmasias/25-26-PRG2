package entregas.riveraOscar;
public class Carta{
    private String valor;
    private String palo;

    public Carta(String valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public int obtenerValor(){
        if (valor.equals("A")) return 11;
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) return 10;
        return Integer.parseInt(valor);
    }
    public void mostrarCarta(){
        System.out.print("[" + valor + " " + palo + "]"); 
    }
}