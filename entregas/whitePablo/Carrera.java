import java.util.Random;

class Carrera {
    private Pista pista;
    private Caballo[] caballos;
    private Random aleatorio;
    private static final int LONGITUD_PISTA = 40;
    private static final int NUM_CABALLOS = 2;

    public Carrera() {
        this.pista = new Pista(LONGITUD_PISTA);
        this.caballos = new Caballo[NUM_CABALLOS];
        this.aleatorio = new Random();
        
        for (int i = 0; i < NUM_CABALLOS; i++) {
            caballos[i] = new Caballo(i + 1);
        }
    }

    private int determinarCaballoInicial() {
        return aleatorio.nextInt(NUM_CABALLOS);
    }

    private void mostrarEstado() {
        pista.mostrar();
    }

    private int[] comprobarGanadores() {
        int[] ganadores = new int[NUM_CABALLOS];
        int count = 0;
        for (int i = 0; i < NUM_CABALLOS; i++) {
            if (caballos[i].haLlegado()) {
                ganadores[count++] = i;
            }
        }
        int[] resultado = new int[count];
        for (int i = 0; i < count; i++) {
            resultado[i] = ganadores[i];
        }
        return resultado;
    }

    private void mostrarResultado(int[] ganadores) {
        if (ganadores.length == 1) {
            System.out.println("Ganó el caballo " + (ganadores[0] + 1));
        } else {
            System.out.print("Empate entre los caballos: ");
            for (int i = 0; i < ganadores.length; i++) {
                System.out.print((ganadores[i] + 1));
                if (i < ganadores.length - 1) {
                    System.out.print(" y ");
                }
            }
            System.out.println();
        }
    }

    public void jugar() {
        pista.limpiar();
        for (int i = 0; i < NUM_CABALLOS; i++) {
            pista.colocarCaballo(caballos[i], 0);
        }
        
        int turno = determinarCaballoInicial();
        boolean carreraTerminada = false;
        int turnos = 0;
        
        while (!carreraTerminada) {
            System.out.println("\n--- Turno " + (turnos + 1) + " ---");
            System.out.println("Avanza el caballo " + (turno + 1));
            caballos[turno].avanzar();
            
            pista.limpiar();
            for (int i = 0; i < NUM_CABALLOS; i++) {
                pista.colocarCaballo(caballos[i], caballos[i].getPosicion());
            }
            mostrarEstado();
            
            int[] ganadores = comprobarGanadores();
            if (ganadores.length > 0) {
                carreraTerminada = true;
                mostrarResultado(ganadores);
            }
            
            turno = (turno + 1) % NUM_CABALLOS;
            turnos++;
            
            if (turnos > 100) {
                System.out.println("Límite de turnos alcanzado");
                break;
            }
        }
    }
}