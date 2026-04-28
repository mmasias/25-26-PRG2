import java.util.Random;

public class Carrera {
    private static final int LONGITUD_PISTA = 40;
    private static final int CANTIDAD_CABALLOS = 2;
    private Caballo[] caballos;
    private int turno;
    private Random random;
    private Presentador presentador;

    public Carrera() {
        this(CANTIDAD_CABALLOS);
    }

    public Carrera(int cantidadCaballos) {
        this.caballos = new Caballo[cantidadCaballos];
        this.turno = 0;
        this.random = new Random();
        this.presentador = new Presentador();
        inicializarCaballos();
    }

    private void inicializarCaballos() {
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo("Caballo " + (i + 1));
        }
    }

    public void jugar() {
        presentador.mostrarInicio();
        while (!hayGanador()) {
            avanzarTurno();
            presentador.mostrarEstado(caballos, turno);
        }
        presentador.mostrarGanadores(caballos);
    }

    private void avanzarTurno() {
        turno++;
        int caballoActual = random.nextInt(caballos.length);
        int avance = random.nextInt(3);
        caballos[caballoActual].avanzar(avance);
    }

    private boolean hayGanador() {
        for (Caballo caballo : caballos) {
            if (caballo.llegadaAlFinal(LONGITUD_PISTA)) {
                return true;
            }
        }
        return false;
    }

    public Caballo[] getCaballos() {
        return caballos;
    }

    public int getTurno() {
        return turno;
    }
}
