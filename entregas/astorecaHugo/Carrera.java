
class Carrera {

    private Pista pista;
    private Caballo[] caballos;

    public Carrera() {
        pista = new Pista(40);
        caballos = new Caballo[2];
        caballos[0] = new Caballo(1);
        caballos[1] = new Caballo(2);

    }

    public void jugar() {
        do {
            pista.mostrar();
            for (int i = 0; i < 2; i++) {
                caballos[i].moverse(pista);
            }

        } while (!pista.hayGanadores());
        pista.mostrarResultadoFinal();

    }

}
