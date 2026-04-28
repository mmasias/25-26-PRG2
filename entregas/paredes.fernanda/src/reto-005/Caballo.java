public class Caballo {
    private String nombre;
    private int posicion;

    public Caballo(String nombre) {
        this(nombre, 0);
    }

    public Caballo(String nombre, int posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void avanzar(int casillas) {
        this.posicion += casillas;
    }

    public boolean llegadaAlFinal(int longitudPista) {
        return this.posicion >= longitudPista;
    }
}
