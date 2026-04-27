package entregas.moraDaniel;

public class Caballo {

    private int posicion;
    private int numero;
    private String simbolo;

    public Caballo(int numero, String simbolo) {
        this.numero = numero;
        this.simbolo = simbolo;
        this.posicion = 0;
    }

    public void mover() {
        int avance = (int) (Math.random() * 3);
        this.posicion = this.posicion + avance;

    }

    public int getPosicion() {
        return this.posicion;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public int getNumero() {
        return this.numero;
    }
}
