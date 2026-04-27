import java.util.Random;

class Caballo {
    private int id;
    private int posicion;
    private Random aleatorio;
    private static final int META = 40;
    private static final String ICONO = ";-;'";

    public Caballo(int id) {
        this.id = id;
        this.posicion = 0;
        this.aleatorio = new Random();
    }

    public void avanzar() {
        int avance = aleatorio.nextInt(3);
        posicion += avance;
        if (posicion > META) {
            posicion = META;
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public boolean haLlegado() {
        return posicion >= META;
    }

    public String dibujar() {
        return ICONO;
    }

    public int getId() {
        return id;
    }

    private void reset() {
        this.posicion = 0;
    }
}