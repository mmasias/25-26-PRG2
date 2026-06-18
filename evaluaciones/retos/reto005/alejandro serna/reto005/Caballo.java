import java.util.Random;

public class Caballo {
    private int posicion;
    private int id;
    private Random random;
    private static final int META = 40;

    public Caballo(int id) {
        this.id = id;
        this.posicion = 0;
        this.random = new Random();
    }

    public void avanzar() {
        int paso = random.nextInt(3); // 0, 1 o 2
        posicion += paso;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getId() {
        return id;
    }

    public boolean haLlegado() {
        return posicion >= META;
    }

    public void mostrar(Console console) {
        for (int i = 0; i < posicion; i++) {
            console.write(" ");
        }
        console.writeln(";-;'");
    }
}