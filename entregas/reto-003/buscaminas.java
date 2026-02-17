import java.util.Scanner;
import java.util.Random;

public class Buscaminas {

    public static void imprimirTablero(char[][] tablero) {
        System.out.println("================");
        System.out.print("  ");
        for (int j = 0; j < tablero[0].length; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    public static void main(String[] args) {

        final int FILAS = 5;
        final int COLUMNAS = 7;
        final int MINAS = 5;

        char[][] tablero = new char[FILAS][COLUMNAS];
        boolean[][] minas = new boolean[FILAS][COLUMNAS];

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = '-';
                minas[i][j] = false;
            }
        }

        int colocadas = 0;
        while (colocadas < MINAS) {
            int x = rand.nextInt(FILAS);
            int y = rand.nextInt(COLUMNAS);
            if (!minas[x][y]) {
                minas[x][y] = true;
                colocadas++;
            }
        }

        int explosiones = 0;
        int descubiertas = 0;
        int seguras = FILAS * COLUMNAS - MINAS;

        while (explosiones < 3 && descubiertas < seguras) {

            imprimirTablero(tablero);

            System.out.print("Ingrese X: ");
            int x = sc.nextInt() - 1;

            System.out.print("Ingrese Y: ");
            int y = sc.nextInt() - 1;

            if (x < 0 || x >= FILAS || y < 0 || y >= COLUMNAS) {
                System.out.println("Posición inválida");
                continue;
            }

            if (tablero[x][y] != '-') {
                System.out.println("Casilla ya abierta");
                continue;
            }

            if (minas[x][y]) {
                tablero[x][y] = '*';
                explosiones++;
                System.out.println("Mina! Explosiones: " + explosiones);
            } else {
                tablero[x][y] = '.';
                descubiertas++;
                System.out.println("Libre!");
            }
        }

        imprimirTablero(tablero);

        if (explosiones >= 3) {
            System.out.println("Perdiste!");
        } else {
            System.out.println("Ganaste!");
        }

        sc.close();
    }
}
