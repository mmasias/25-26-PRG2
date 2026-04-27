public class Carrera<Caballo, Pista> {

    private Pista pista;
    private Caballo[] caballos;
    private int turno;

    public Carrera() {
        pista = new Pista(40);
        caballos = new Caballo[2];

        caballos[0] = new Caballo(1);
        caballos[1] = new Caballo(2);

        // empieza uno al azar
        turno = (int)(Math.random() * 2);
    }

    public void jugar() {

        do {
            ((Object) pista).mostrar(caballos);

            caballos[turno].mover();

            cambiarTurno();

            esperar();

        } while (!pista.hayGanador(caballos));

        pista.mostrarResultado(caballos);
    }

    private void cambiarTurno() {
        turno = (turno + 1) % 2;
    }

    private void esperar() {
        try {
            Thread.sleep(400);
        } catch (Exception e) {
        }
    }
}