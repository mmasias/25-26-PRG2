package reto003;

import java.util.Scanner;

public class BuscaMinas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] mapa = {
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },

        };

        final int MINAS_TOTALES = 5;

        colocarMinas(MINAS_TOTALES, mapa);

        final int MAX_EXPLOSIONES = 3;
        int explosiones = 0;
        boolean seguirJugando = true;

        do {
            imprimir(mapa);
            boolean esMina = revelarCasilla(scanner, mapa);
            if (esMina) {
                explosiones++;
            }
            boolean todasLibres = todasCasillasLibres(mapa, MINAS_TOTALES);
            seguirJugando = explosiones < MAX_EXPLOSIONES && !todasLibres;
        } while (seguirJugando);

        imprimir(mapa);

        if (explosiones >= MAX_EXPLOSIONES) {
            System.out.println("¡Has perdido! Explotaron 3 minas");
        } else {
            System.out.println("¡Felicidades, has ganado!");
        }

        scanner.close();
    }

    static void colocarMinas(int numero, int[][] mapa) {
        boolean terminado = false;
        int minasColocadas = 0;

        do {
            int x = (int) (Math.random() * mapa.length);
            int y = (int) (Math.random() * mapa[0].length);

            if (mapa[x][y] != -2) {
                mapa[x][y] = -2;
                minasColocadas = minasColocadas + 1;
            }
            terminado = minasColocadas >= numero;
        } while (!terminado);
    }

    static void imprimir(int[][] mapa) {
        System.out.println("================");
        System.out.println("  1 2 3 4 5 6 7");
        for (int i = 0; i < mapa.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapear(mapa[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    static String mapear(int casilla) {

        String[] simbolos = {
                "-",
                ".",
                "*"
        };

        return casilla < 0 ? simbolos[0] : simbolos[casilla];

    }

    static int[] pedirCoordenadas(Scanner scanner, int[][] mapa) {
        System.out.println("Ingresa la coordenada x: ");
        int x = scanner.nextInt() - 1;
        System.out.println("Ingresa la coordenada y: ");
        int y = scanner.nextInt() - 1;
        return new int[] { y, x };
    }

    static boolean revelarCasilla(Scanner scanner, int[][] mapa) {
        int[] coordenada = pedirCoordenadas(scanner, mapa);

        int x = coordenada[1];
        int y = coordenada[0];

        if (mapa[y][x] < 0) {
            mapa[y][x] = mapa[y][x] * -1;
        } else {
            mapa[y][x] = mapa[y][x];
        }

        System.out.println("----------------");
        if (mapa[y][x] == 2) {
            System.out.println("Mina!");
            return true;
        } else {
            System.out.println("Libre!");
            return false;
        }
    }

    static boolean todasCasillasLibres(int[][] mapa, int totalMinas) {
        int casillasReveladas = 0;
        int totalCasillas = mapa.length * mapa[0].length;

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j] >= 0) {
                    casillasReveladas++;
                }
            }
        }
        return casillasReveladas == (totalCasillas - totalMinas);
    }

}
