package entregas.moraDaniel;

public class Turno {
    private int turnoActual;

    public Turno() {
        this.turnoActual = (int) (Math.random() * 2);
    }

    public int getTurno() {
        return this.turnoActual;
    }

    public void cambiarTurno() {
        this.turnoActual = 1 - this.turnoActual;
    }
}
