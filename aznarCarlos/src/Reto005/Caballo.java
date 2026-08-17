public class Caballo {
    private int posicion = 0;

    void avanzar() {
        
        int paso = (int)(Math.random() * 3); 
        this.posicion += paso;
    }

    public int ObtenerPosicion() {
        return this.posicion;
    }
}
