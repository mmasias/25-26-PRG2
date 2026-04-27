public class Caballo {
    private int numero;
    private int posicion;

    public Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
    }

    public void avanzar() {
        int avance = (int)(Math.random() * 4); // ahora 0-3
        posicion += avance;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getNumero() {
        return numero;
    }
}