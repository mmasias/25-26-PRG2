import java.util.Scanner;

public class BuscaMinas {

    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int TOTAL_MINAS = 5;
    private static final int MINAS_PARA_PERDER = 3;

    private static String[][] mapaVisible = new String[FILAS][COLUMNAS];
    private static String[][] mapaMinas = new String[FILAS][COLUMNAS];

    private static int minasPisadas = 0;
    private static int casillasDescubiertas = 0;

    public static void main(String[] args) {

        inicializarMapas();
        colocarMinasAleatorias();

        while (!juegoTerminado()) {
            imprimirMapa();
            int fila = pedirNumero("Introduce fila (1-5): ", FILAS);
            int columna = pedirNumero("Introduce columna (1-7): ", COLUMNAS);
            procesarMovimiento(fila - 1, columna - 1);
        }

        imprimirMapa();
        mostrarResultado();
    }

    private static void inicializarMapas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                mapaVisible[i][j] = "-";
                mapaMinas[i][j] = "0";
            }
        }
    }

    private static void colocarMinasAleatorias() {
        int minasColocadas = 0;

        while (minasColocadas < TOTAL_MINAS) {
            int fila = (int) (Math.random() * FILAS);
            int columna = (int) (Math.random() * COLUMNAS);

            if (mapaMinas[fila][columna].equals("0")) {
                mapaMinas[fila][columna] = "1";
                minasColocadas++;
            }
        }
    }

    private static void imprimirMapa() {
        System.out.println("\nMapa actual:");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(mapaVisible[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int pedirNumero(String mensaje, int maximo) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print(mensaje);
            numero = scanner.nextInt();
        } while (numero < 1 || numero > maximo);

        return numero;
    }

    private static void procesarMovimiento(int fila, int columna) {

        if (mapaMinas[fila][columna].equals("1")) {
            mapaVisible[fila][columna] = "X";
            minasPisadas++;
        } else {
            mapaVisible[fila][columna] = ".";
        }

        casillasDescubiertas++;
    }

    private static boolean juegoTerminado() {
        return minasPisadas >= MINAS_PARA_PERDER ||
               casillasDescubiertas >= (FILAS * COLUMNAS - TOTAL_MINAS);
    }

    private static void mostrarResultado() {
        if (minasPisadas >= MINAS_PARA_PERDER) {
            System.out.println("Has perdido.");
        } else {
            System.out.println("¡Felicidades, has ganado!");
        }
    }
}
