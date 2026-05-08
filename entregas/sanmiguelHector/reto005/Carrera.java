class Carrera {
    private final int NUMERO_CABALLOS = 2;
    private final int TAMAÑO_PISTA = 100;
    private Caballo[] caballos;
    private Pista pista;

    public Carrera() {
        pista = new Pista(NUMERO_CABALLOS, TAMAÑO_PISTA);
        caballos = new Caballo[NUMERO_CABALLOS];
        for (int i = 0; i < NUMERO_CABALLOS; i++) {
            caballos[i] = new Caballo(i);
            pista.meter(caballos[i]);
        }

    }

    public void jugar() {
        do {
            pista.mostrar();
            for (int i = 0; i < NUMERO_CABALLOS; i++) {
                pista.mover(caballos[i]);
            }

        } while (!pista.hayGanadores());
        pista.mostrar();
        pista.mostrarEstadoFinal();
    }
}