public class Caballo {
    private int posicionActual;
    private int id;
    private final int META = 40;

    public Caballo(int id) {
        this.id = id;
        this.posicionActual = 0;
    }

    public void moverCaballo() {
        int avance = (int)(Math.random() * 3);
        posicionActual += avance;
    }

    public boolean estaEnMeta() {
        return posicionActual >= META;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public String getNombre() {
        return "Caballo " + id;
    }
}