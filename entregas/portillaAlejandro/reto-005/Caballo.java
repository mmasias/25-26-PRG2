
public class Caballo {

    private int numero;
    private int posicion;

    public Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
    }

    public void mover() {
        int avance = (int)(Math.random() * 3);
        posicion += avance;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getNumero() {
        return numero;
    }
}