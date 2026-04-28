public class Caballo {
    private String identificador;
    private int posicion;
    private Turno turno;

    public Caballo(String identificador) {
        this.identificador = identificador;
        this.posicion = 0;
        this.turno = new Turno();
    }

    public String obtenerIdentificador() {
        return identificador;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public void recibirAvance(int avance) {
        posicion += avance;
    }

    public int ejecutarTurno() {
        return turno.ejecutar(this);
    }
}
