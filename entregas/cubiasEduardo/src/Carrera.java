public class Carrera {
    private Caballo[] caballos;
    private Pista pista;

    public Carrera(String[] identificadores) {
        this.pista = new Pista(40);
        crearParticipantes(identificadores);
    }

    public void jugar() {
        int inicio = (int) (Math.random() * caballos.length);
        boolean ganado = false;

        while (!ganado) {
            System.out.println("----------------------------------------------");
            pista.mostrar(caballos);
            System.out.println("----------------------------------------------");

            for (int i = 0; i < caballos.length; i++) {
                int indice = (inicio + i) % caballos.length;
                Caballo caballo = caballos[indice];
                int avance = caballo.ejecutarTurno();
                System.out.println("Turno de caballo " + caballo.obtenerIdentificador() + " avanzó " + avance + " casillas.");
            }

            ganado = pista.hayGanador(caballos);
            if (!ganado) {
                System.out.println();
            }
        }

        System.out.println("----------------------------------------------");
        pista.mostrar(caballos);
        System.out.println("----------------------------------------------");
        mostrarGanadores();
    }

    private void crearParticipantes(String[] identificadores) {
        caballos = new Caballo[identificadores.length];
        for (int i = 0; i < identificadores.length; i++) {
            caballos[i] = new Caballo(identificadores[i]);
        }
    }

    private void mostrarGanadores() {
        String[] ganadores = pista.obtenerGanadores(caballos);
        if (ganadores.length == 1) {
            System.out.println("Ganó el caballo " + ganadores[0]);
        } else {
            String resultado = ganadores[0];
            for (int i = 1; i < ganadores.length; i++) {
                resultado += ", " + ganadores[i];
            }
            System.out.println("Empate entre los caballos " + resultado);
        }
    }
}
