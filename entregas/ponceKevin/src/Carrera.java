public class Carrera {
    private boolean carreraEnCurso = false;
    private Pista pista;
    final int tamañoPista = 80;
    final int delayMs = 280;
    public void iniciarCarrera() {
        this.incializarCarrera();
        while (carreraEnCurso) {
          this.avanzarCarrera();
        }
        limpiarConsola();
        pista.mostrarPosiciones();
        pista.mostrarGanadores();
    }

    public void incializarCarrera() {
        this.carreraEnCurso = true;
        Caballo caballo1 = new Caballo("Aurora");
        Caballo caballo2 = new Caballo("Brillo");
        Caballo caballo3 = new Caballo("Viento");
        Caballo caballo4 = new Caballo("Trueno");
        Caballo caballo5 = new Caballo("Fulgor");
        pista = new Pista(tamañoPista);
        pista.agregarCaballo(caballo1);
        pista.agregarCaballo(caballo2);
        pista.agregarCaballo(caballo3);
        pista.agregarCaballo(caballo4);
        pista.agregarCaballo(caballo5);

    }
    private void limpiarConsola() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void avanzarCarrera() {
        carreraEnCurso = !pista.hayGanador();
        limpiarConsola();
        pista.mostrarPosiciones();
        esperar(delayMs);
        pista.avanzarCaballos();
    }

}