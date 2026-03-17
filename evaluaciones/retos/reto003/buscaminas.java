import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    public static final int FILAS = 5;
    public static final int COLUMNAS = 7;
    public static final int MINAS = 5;
    public static final int MAX_EXPLOSIONES = 3;

    public static void main(String[] args) {
        char[][] tablero = new char[FILAS][COLUMNAS];
        boolean[][] minas = new boolean[FILAS][COLUMNAS];

        inicializarTablero(tablero);
        colocarMinas(minas);
        jugar(tablero, minas);
    }

    private static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = '-';
            }
        }
    }

    private static void colocarMinas(boolean[][] minas) {
        Random rand = new Random();
        int colocadas = 0;

        while (colocadas < MINAS) {
            int f = rand.nextInt(FILAS);
            int c = rand.nextInt(COLUMNAS);

            if (!minas[f][c]) {
                minas[f][c] = true;
                colocadas++;
            }
        }
    }

    private static void jugar(char[][] tablero, boolean[][] minas) {
        Scanner sc = new Scanner(System.in);
        int explosiones = 0;
        int libresNecesarias = FILAS * COLUMNAS - MINAS;
        int descubiertas = 0;

        while (true) {
            imprimirTablero(tablero);

            System.out.println("Ingrese X");
            int x = leerEntero(sc) - 1;

            System.out.println("Ingrese Y");
            int y = leerEntero(sc) - 1;

            System.out.println("----------------");

            if (x < 0 || x >= COLUMNAS || y < 0 || y >= FILAS) {
                System.out.println("Coordenadas inválidas\n");
                continue;
            }

            if (tablero[y][x] != '-') {
                System.out.println("Ya revelada\n");
                continue;
            }

            if (minas[y][x]) {
                System.out.println("Mina!");
                tablero[y][x] = '*';
                explosiones++;

                if (explosiones >= MAX_EXPLOSIONES) {
                    imprimirTablero(tablero);
                    System.out.println("Has perdido!");
                    break;
                }

            } else {
                System.out.println("Libre!");
                tablero[y][x] = '.';
                descubiertas++;

                if (descubiertas == libresNecesarias) {
                    imprimirTablero(tablero);
                    System.out.println("Has ganado!");
                    break;
                }
            }

            System.out.println();
        }

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Ingrese un número válido:");
            sc.next();
        }
        return sc.nextInt();
    }

    private static void imprimirTablero(char[][] tablero) {
        System.out.println("================");
        System.out.print("  ");
        for (int col = 1; col <= COLUMNAS; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print((fila + 1) + " ");
            for (int col = 0; col < COLUMNAS; col++) {
                System.out.print(tablero[fila][col] + " ");
            }
            System.out.println();
        }

        System.out.println("================");
    }
}
