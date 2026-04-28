import java.util.Random;

class Caballo {

    private int posicion;
    private Random azar = new Random();

    public Caballo() {
        this.posicion = 0;
    }

    public void avanzar() {
        posicion += azar.nextInt(3);
    }

    public int getPosicion() {
        return posicion;
    }
}
