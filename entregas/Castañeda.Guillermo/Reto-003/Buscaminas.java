import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    public static void main(String[] args) {

        int filas = 5;
        int columnas = 7;
        int minas = 5;
        int maxExplosiones = 3;

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

        Scanner sc = new Scanner(System.in);

        int explosiones = 0;
        int descubiertas = 0;
        int seguras = filas * columnas - minas;

        while (explosiones < maxExplosiones && descubiertas < seguras) {

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

            System.out.print("Ingrese X: ");
            int x = sc.nextInt() - 1;

            System.out.print("Ingrese Y: ");
            int y = sc.nextInt() - 1;

            if (x >= 0 && x < filas && y >= 0 && y < columnas) {

                if (tablero[x][y].equals("-")) {

                    if (tableroMinas[x][y] == 1) {
                        System.out.println("Mina!");
                        tablero[x][y] = "*";
                        explosiones++;
                    } else {
                        System.out.println("Libre!");
                        tablero[x][y] = ".";
                        descubiertas++;
                    }

                } else {
                    System.out.println("Casilla ya usada");
                }

            } else {
                System.out.println("Posicion no valida");
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

        if (explosiones == maxExplosiones) {
            System.out.println("Has perdido");
        } else {
            System.out.println("Has ganado");
        }

        sc.close();
    }
}
