public class Carrera {
    private Caballo[] caballos;
    private Pista pista;
    private Random random;

    public Carrera(int numCaballos, int longitudPista) {
        caballos = new Caballo[numCaballos];
        for (int i = 0; i < numCaballos; i++) {
            caballos[i] = new Caballo(i + 1);
        }

        pista = new Pista(longitudPista);
        random = new Random();
    }

    public void jugar() {
        int turno = random.nextInt(caballos.length);

        System.out.println("Empieza el caballo " + caballos[turno].getId());

        while (!hayGanador()) {
            caballos[turno].avanzar();
            pista.mostrar(caballos);

            turno = (turno + 1) % caballos.length;

            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }

        mostrarResultado();
    }

    private boolean hayGanador() {
        for (Caballo c : caballos) {
            if (c.getPosicion() >= pista.getLongitud()) {
                return true;
            }
        }
        return false;
    }

    private void mostrarResultado() {
        boolean empate = false;
        Caballo ganador = null;

        for (Caballo c : caballos) {
            if (c.getPosicion() >= pista.getLongitud()) {
                if (ganador == null) {
                    ganador = c;
                } else {
                    empate = true;
                }
            }
        }

        if (empate) {
            System.out.println("¡Empate!");
        } else {
            System.out.println("Ganó el caballo " + ganador.getId());
        }
    }
}