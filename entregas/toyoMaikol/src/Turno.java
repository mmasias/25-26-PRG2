public class Turno {
    private int turnoActual;
    private int numeroJugadores;

    public Turno(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        this.turnoActual = 0;
    }

    public void cambiar() {
        turnoActual = (turnoActual + 1) % numeroJugadores;
    }

    public int toca() {
        return turnoActual;
    }
}
