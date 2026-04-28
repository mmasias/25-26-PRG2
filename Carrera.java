import java.util.Random;

class Carrera {

    private static final int LONGITUD = 40;
    private int[] posiciones = new int[2];
    private Random azar = new Random();

    private void avanzar(int caballo) {
        posiciones[caballo] += azar.nextInt(3);
    }

    private void mostrarPista() {
        System.out.println("--------------------------------------------");
        for (int i = 0; i < posiciones.length; i++) {
            System.out.println(" ".repeat(posiciones[i]) + ";-;'");
        }
        System.out.println("--------------------------------------------");
    }

    private boolean hayGanador() {
        for (int posicion : posiciones) {
            if (posicion >= LONGITUD) {
                return true;
            }
        }
        return false;
    }

    void jugar() {
        mostrarPista();
        while (!hayGanador()) {
            for (int i = 0; i < posiciones.length; i++) {
                avanzar(i);
            }
            mostrarPista();
        }
    }
}
