package entregas.garciaJacobo;

import java.util.Scanner;

public class Buscaminas {
    public static void main(String[] args) {

        int[][] superficie = {
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 }

        };
        final int NUMERO_MINAS = 3;
        colocarMinas(superficie, NUMERO_MINAS);
        mostrarMapa(superficie);
        int[] cordenadas = preguntarCordenadas(superficie);
        despejarSuperficie(superficie, cordenadas);
        mostrarMapa(superficie);
    }

    private static void despejarSuperficie(int[][] superficie, int[] cordenadas) {
        int y = cordenadas[0];
        int x = cordenadas[1];

        superficie[y][x] = superficie[y][x] < 0
                ? superficie[y][x] * -1
                : superficie[y][x];
    }

    private static int[] preguntarCordenadas(int[][] superficie) {
        Scanner scanner = new Scanner(System.in);
        int y;
        int x;
        int[] cordenadas = null;
        boolean tieneCordenada = false;
        do {
            System.out.println(" cordenada Y ?");
            y = scanner.nextInt();
            System.out.println("cordenada X ?");
            x = scanner.nextInt();
            cordenadas = new int[] { y, x };
            tieneCordenada = cordenadaValida(superficie, cordenadas);
        } while (!tieneCordenada);

        return cordenadas;

    }

    private static boolean cordenadaValida(int[][] superficie, int[] cordenadas) {
        int y = cordenadas[0];
        int x = cordenadas[1];
        if (y < 0 || y >= superficie.length || x >= superficie[0].length || x < 0) {
            System.out.println("CORDENADAS INCORRECTAS");
            return false;
        }
        return true;

    }

    private static String mapearSuperficie(int nºmatriz) {
        final String TILES[] = { " - ", " . ", " * " };
        return nºmatriz < 0 ? TILES[0] : TILES[nºmatriz];
    }

    private static void mostrarMapa(int[][] superficie) {
        System.out.println("  ===================");
        System.out.println("  0  1  2  3  4  5  6");

        for (int i = 0; i < superficie.length; i++) {
            System.out.print(i + "");
            for (int j = 0; j < superficie[i].length; j++) {
                int tile = superficie[i][j];
                System.out.print(String.format("%3s", mapearSuperficie(tile)));
            }
            System.out.println();
        }
        System.out.println("  ===================");
    }

    private static void colocarMinas(int[][] superficie, int NUMERO_MINAS) {
        int minasColocadas = 0;
        do {
            int x = (int) (Math.random() * superficie[0].length);
            int y = (int) (Math.random() * superficie.length);
            if (superficie[y][x] != -2) {
                superficie[y][x] = -2;
                minasColocadas++;
            }

        } while (minasColocadas < NUMERO_MINAS);
    }
}
