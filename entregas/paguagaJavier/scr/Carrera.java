import java.util.Scanner;

class Carrera {

    private Caballo[] caballos;
    private Pista pista;
    private Turno turno;
    private int numeroJugadores;

    public Carrera(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
        this.pista = new Pista(40);
        this.caballos = new Caballo[numeroJugadores];
        this.turno = new Turno(numeroJugadores);

        for (int i = 0; i < numeroJugadores; i++) {
            caballos[i] = new Caballo(i + 1);
        }
    }

    public void jugar() {
        do {
            pista.mostrar(caballos);
            int indice = turno.getJugadorActual();
            caballos[indice].moverCaballos();
            this.Pausa();
            turno.pasarTurno();

        } while (!pista.hayGanadores(caballos));

        pista.mostrarResultadoFinal(caballos);
    }

    private void Pausa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        scanner.nextLine();
    }

}
