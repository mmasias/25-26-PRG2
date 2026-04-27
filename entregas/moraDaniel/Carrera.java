package entregas.moraDaniel;

public class Carrera {
    private Pista pista;
    private Caballo[] caballos;
    private Turno turno;

    public Carrera() {
        pista = new Pista();
        caballos = new Caballo[2];
        caballos[0] = new Caballo(1, ";-;'");
        caballos[1] = new Caballo(2, ";-;''");
        turno = new Turno();

    }

    public void jugar() {
        boolean carreraTerminada = false;
        int ganador = -1;
        System.out.println("Comienza la Carrera");
        System.out.println();
        while (!carreraTerminada) {
            int indiceCaballo = turno.getTurno();
            Caballo caballoActual = caballos[indiceCaballo];

            caballoActual.mover();

            pista.dibujar(caballos[0], caballos[1]);

            if (caballoActual.getPosicion() >= 39) {
                carreraTerminada = true;
                ganador = caballoActual.getNumero();
            }
            turno.cambiarTurno();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
        }
        System.out.println();
        System.out.println("=========================================");
        System.out.println("¡GANÓ EL CABALLO " + ganador + "!");
        System.out.println("=========================================");
    }
}
