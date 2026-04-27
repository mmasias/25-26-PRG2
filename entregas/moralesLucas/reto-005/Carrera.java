public class Carrera {

    private Caballo[] caballos;
    private Pista pista;
    private Turno turno;
    private final int META = 40;

    public Carrera() {
        caballos = new Caballo[2];

        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i + 1);
        }

        pista = new Pista();
        turno = new Turno();
    }

    public void jugar() {

        boolean fin = false;

        while (!fin) {

            int i = turno.siguienteTurno(caballos.length);

            caballos[i].mover();

            pista.mostrar(caballos);

            for (int j = 0; j < caballos.length; j++) {
                if (caballos[j].getPosicion() >= META) {
                    fin = true;
                }
            }
        }

        System.out.println("RESULTADO FINAL:");

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= META) {
                System.out.println("Ganó el caballo " + caballos[i].getNumero());
            }
        }
    }
}