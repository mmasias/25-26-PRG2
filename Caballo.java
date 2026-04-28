import java.util.Random;

public class Caballo {
    private String nombre;
    private int posicion;
    private Random random;

    public Caballo(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.random = new Random();
    }

    public void mover() {
        this.posicion += random.nextInt(3);
    }

    public int getPosicion() {
        return posicion;
    }
}