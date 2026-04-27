public class Caballo {

    private String nombre;
    private int posicion;

    public Caballo(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
    }

    public int getPosicion() {
        return posicion;
    }

    public void avanzar() {
        int avance = (int) (Math.random() * 3) + 1; 
        posicion += avance;
    }

    public String getNombre() {
        return nombre;
    }
}