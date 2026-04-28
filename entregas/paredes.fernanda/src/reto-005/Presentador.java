public class Presentador {
    private static final String CABALLO_ASCII = ";-;'";
    private static final int LONGITUD_PISTA = 40;

    public void mostrarInicio() {
        System.out.println("=== COMIENZA LA CARRERA DE CABALLOS ===\n");
    }

    public void mostrarEstado(Caballo[] caballos, int turno) {
        System.out.println("--- Turno " + turno + " ---");
        for (Caballo caballo : caballos) {
            mostrarCaballo(caballo);
        }
        System.out.println();
    }

    public void mostrarGanadores(Caballo[] caballos) {
        System.out.println("=== FIN DE LA CARRERA ===");
        boolean hayGanador = false;
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= LONGITUD_PISTA) {
                System.out.println("¡Ganó el caballo " + (i + 1) + "!");
                hayGanador = true;
            }
        }
        if (!hayGanador) {
            System.out.println("La carrera terminó sin ganador.");
        }
    }

    private void mostrarCaballo(Caballo caballo) {
        System.out.print(caballo.getNombre() + ": ");
        for (int i = 0; i < caballo.getPosicion(); i++) {
            System.out.print(" ");
        }
        System.out.println(CABALLO_ASCII);
    }
}
