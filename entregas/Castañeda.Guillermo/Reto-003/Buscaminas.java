import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    public static void main(String[] args) {

        int filas = 5;
        int columnas = 7;
        int minas = 5;

        String[][] tablero = new String[filas][columnas];
        int[][] tableroMinas = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = "-";
                tableroMinas[i][j] = 0;
            }
        }

        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < minas) {
            int f = random.nextInt(filas);
            int c = random.nextInt(columnas);
            if (tableroMinas[f][c] == 0) {
                tableroMinas[f][c] = 1;
                minasColocadas++;
            }
        }

        System.out.println("================");
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
