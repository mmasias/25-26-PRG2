public class Carrera {
    private Pista pista;
    private Caballo[] caballos;

    public Carrera() {
        pista = new Pista(50);
        caballos = new Caballo[3]; // ahora 3 caballos

        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i + 1);
        }
    }

    public void iniciar() {
        do {
            pista.mostrar(caballos);

            for (Caballo c : caballos) {
                c.avanzar();
            }

            esperar();
        } while (!pista.hayGanador(caballos));

        pista.mostrarResultado(caballos);
    }

    private void esperar() {
        try {
            Thread.sleep(500); // pausa automática
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}