class Turno {
    private int actual;
    private int totalParticipantes;

    public Turno(int totalParticipantes) {
        this.totalParticipantes = totalParticipantes;
        this.actual = 0;
    }

    public int getJugadorActual() {
        return actual;
    }

    public void pasarTurno() {
        actual = (actual + 1) % totalParticipantes;
    }
}
