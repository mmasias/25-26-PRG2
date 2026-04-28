class Carrera {

    private static final int LONGITUD = 40;
    private Caballo[] caballos;

    public Carrera() {
        caballos = new Caballo[2];
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo();
        }
    }

    private void mostrarPista() {
        System.out.println("--------------------------------------------");
        for (int i = 0; i < caballos.length; i++) {
            System.out.println(" ".repeat(caballos[i].getPosicion()) + ";-;'");
        }
        System.out.println("--------------------------------------------");
    }

    private boolean hayGanador() {
        for (Caballo caballo : caballos) {
            if (caballo.getPosicion() >= LONGITUD) {
                return true;
            }
        }
        return false;
    }

    private void mostrarResultado() {
        int ganadores = 0;
        for (Caballo caballo : caballos) {
            if (caballo.getPosicion() >= LONGITUD) ganadores++;
        }
        if (ganadores > 1) {
            System.out.println("Empate");
        } else {
            for (int i = 0; i < caballos.length; i++) {
                if (caballos[i].getPosicion() >= LONGITUD) {
                    System.out.println("Ganó el caballo " + (i + 1));
                }
            }
        }
    }

    void jugar() {
        mostrarPista();
        while (!hayGanador()) {
            for (int i = 0; i < caballos.length; i++) {
                caballos[i].avanzar();
            }
            mostrarPista();
        }
        mostrarResultado();
    }
}
