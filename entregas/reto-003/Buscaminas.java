import java.util.Scanner;
import java.util.Random;

public class Buscaminas {

    static final int FILAS       = 5;
    static final int COLUMNAS    = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;

    static char[][]    tablero    = new char[FILAS][COLUMNAS];
    static boolean[][] minas      = new boolean[FILAS][COLUMNAS];
    static int         explosiones   = 0;
    static int         casillasLibres = 0;
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        inicializarTablero();
        colocarMinas();

        boolean juegoActivo = true;

        while (juegoActivo) {
            imprimirTablero();

            int x = leerCoordenada(entrada, "X", COLUMNAS);
            int y = leerCoordenada(entrada, "Y", FILAS);

            // Verificar casilla ya revelada
            if (tablero[y - 1][x - 1] != '-') {
                System.out.println("Esa casilla ya fue revelada. Elija otra.");
                continue;
            }

            System.out.println("----------------");
            procesarJugada(x, y);

            if (verificarFin()) {
                juegoActivo = false;
            }
        }

        entrada.close();
    }

    static void inicializarTablero() {
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                tablero[f][c] = '-';
                minas[f][c]   = false;
            }
        }
    }

    static boolean verificarFin() {
        if (explosiones >= MAX_EXPLOSIONES) {
            revelarMinas();
            imprimirTablero();
            System.out.println("================");
            System.out.println("  *** PERDISTE ***");
            System.out.println("  Te explotaron " + explosiones + " minas.");
            System.out.println("================");
            return true;
        }
        if (casillasLibres == (FILAS * COLUMNAS - TOTAL_MINAS)) {
            imprimirTablero();
            System.out.println("================");
            System.out.println("  *** GANASTE ***");
            System.out.println("  Liberaste todas las casillas!");
            System.out.println("================");
            return true;
        }
        return false;
    }

    static void revelarMinas() {
        for (int f = 0; f < FILAS; f++)
            for (int c = 0; c < COLUMNAS; c++)
                if (minas[f][c] && tablero[f][c] == '-')
                    tablero[f][c] = '*';
    }

    static void procesarJugada(int x, int y) {
        int fila = y - 1;
        int col  = x - 1;
        if (minas[fila][col]) {
            tablero[fila][col] = '*';
            explosiones++;
            System.out.println("Mina!");
        } else {
            tablero[fila][col] = '.';
            casillasLibres++;
            System.out.println("Libre!");
        }
    }

    static int leerCoordenada(Scanner entrada, String eje, int maximo) {
        int valor = -1;
        while (valor < 1 || valor > maximo) {
            System.out.println("Ingrese " + eje);
            if (entrada.hasNextInt()) {
                valor = entrada.nextInt();
                if (valor < 1 || valor > maximo)
                    System.out.println("[!] Valor fuera de rango (1-" + maximo + ").");
            } else {
                System.out.println("[!] Ingrese un numero entero.");
                entrada.next();
            }
        }
        return valor;
    }

    static void colocarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < TOTAL_MINAS) {
            int f = rand.nextInt(FILAS);
            int c = rand.nextInt(COLUMNAS);
            if (!minas[f][c]) {
                minas[f][c] = true;
                colocadas++;
            }
        }
    }

    static void imprimirTablero() {
        System.out.println("================");
        System.out.print("  ");
        for (int c = 1; c <= COLUMNAS; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int f = 0; f < FILAS; f++) {
            System.out.print((f + 1) + " ");
            for (int c = 0; c < COLUMNAS; c++) {
                System.out.print(tablero[f][c] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}