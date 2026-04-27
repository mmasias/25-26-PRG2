package entregas.lopezYago;

public class Carrera {
    private Pista pista;
    private Caballo[] caballos;
    private Turno turno;
    private int numeroJugadores;

    public Carrera(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        pista = new Pista(numeroJugadores);
        caballos = new Caballo[numeroJugadores];
        for (int i = 0; i < numeroJugadores; i++) {
            caballos[i] = new Caballo(i + 1);
        }
        turno = new Turno();
    }

    public void jugar() {
        do {
            pista.mostrar();
            int caballoActual = turno.toca();
            caballos[caballoActual].moverse(pista);
            turno.cambiar();
        } while (!pista.hayGanadores());
        pista.mostrarResultadoFinal();
    }
}
