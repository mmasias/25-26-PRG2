import java.util.Scanner;

public class BuscaMinas {
    public static void main(String[] args) {
        final int MINAS_TOTALES = 5;
        int posicionMinas[][] = new int[5][7];
        int tableroVisible[][] = { { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1 } };
        int minasDescubiertas = 0;
        int casillasDescubiertas = 0;

        colocarMinas(posicionMinas, MINAS_TOTALES);

        while (minasDescubiertas < 3 && casillasDescubiertas <= 30) {
            System.out.println();
            System.out.println("Has descubierto " + minasDescubiertas + " minas. Y has mirado " + casillasDescubiertas
                    + " casillas.");
            System.out.println();

            imprimir(tableroVisible);
            minasDescubiertas = adivinarCasilla(tableroVisible, posicionMinas, minasDescubiertas);
            System.out.println();

            if (minasDescubiertas == 3) {
                System.out.println("Encontraste 3 minas, perdiste");
            } else if (minasDescubiertas == 30) {
                System.out.println("¡Has descubierto 30 casillas, Ganaste!");
            }
            casillasDescubiertas++;
        }
    }

    static void colocarMinas(int posicionMinas[][], int MINAS_TOTALES) {
        int minas = 0;
        while (minas < MINAS_TOTALES) {
            int px = (int) (Math.random() * 7);
            int py = (int) (Math.random() * 5);
            if (posicionMinas[py][px] == 0) {
                minas++;
                posicionMinas[py][px] = 1;
            } else if (posicionMinas[py][px] == 1) {
            }
        }
    }

    static int adivinarCasilla(int tableroVisible[][], int posicionMinas[][], int minasDescubiertas) {
        Scanner scanner = new Scanner(System.in);
        int posicionX;
        int posicionY;
        boolean fueraMapa;

        do {
            System.out.println("Ingrese la coordenada x, en número (1-7).");
            posicionX = scanner.nextInt() - 1;
            System.out.println("Ingrese la coordenada Y, en número (1-5).");
            posicionY = scanner.nextInt() - 1;

            fueraMapa = posicionX < 0 || posicionX > 6 || posicionY < 0 || posicionY > 4;

            if (fueraMapa) {
                System.out.println("Has marcado una posición fuera del Mapa, por favor elije de nuevo.");
            }

            if (tableroVisible[posicionY][posicionX] >= 0) {
                System.out.println("Casilla descubierta, por favor elija otra");
            } else if (tableroVisible[posicionY][posicionX] == -1) {
                if (posicionMinas[posicionY][posicionX] == 1) {
                    tableroVisible[posicionY][posicionX] = posicionMinas[posicionY][posicionX];
                    minasDescubiertas++;
                    System.out.println("¡MINA DESCUBIERTA!");

                } else if (posicionMinas[posicionY][posicionX] == 0) {
                    tableroVisible[posicionY][posicionX] = posicionMinas[posicionY][posicionX];
                    System.out.println("¡Libre de Minas!");
                }
            }

        } while (tableroVisible[posicionY][posicionX] < 0 || fueraMapa);
        return minasDescubiertas;

    }

    static void imprimir(int tableroVisible[][]) {
        String posicion[] = { " . ", " * " };
        System.out.println("    1  2  3  4  5  6  7");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 7; j++) {
                if (tableroVisible[i][j] == -1) {
                    System.out.print(" - ");
                } else if (tableroVisible[i][j] >= 0) {
                    System.out.print(posicion[tableroVisible[i][j]]);
                }
            }
            System.out.println();
        }
        System.out.println("=====================");
    }
}
