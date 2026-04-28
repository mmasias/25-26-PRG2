public class Caballo {
    private int id;
    private int posicion;
    private Random random;

    public Caballo(int id) {
        this.id = id;
        this.posicion = 0;
        this.random = new Random();
    }

    public void avanzar() {
        int avance = random.nextInt(3); 
        posicion += avance;
    }

    public int getPosicion() {
        return posicion;
    }

    public int getId() {
        return id;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}