public class Carrera {

    private Pista pista;
    private Turno turno;
    private Caballo[] caballos;
    private int numeroJugadores;

    public Carrera(int numeroJugadores){
        this.numeroJugadores = numeroJugadores;
        pista = new Pista(40, numeroJugadores);
        caballos = new Caballo[numeroJugadores];
        for(int i = 0; i < numeroJugadores; i++){
            caballos[i] = new Caballo(i + 1);
        }
        turno = new Turno(numeroJugadores);
    }

    public void jugar() {
        do{
            pista.mostrarPista();
            caballos[turno.toca()].mover(pista);
            turno.cambiar();
        } while(!pista.haSidoCompletada());
        pista.mostrarResultadoFinal();
    }

}
