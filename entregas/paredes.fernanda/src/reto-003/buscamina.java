import java.util.Scanner;

public class Buscaminas {

    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;

    public static void main(String[] args) {
        boolean[][] tableroOculto = crearTableroOculto();
        String[][] tableroVisible = crearTableroVisible();
        Scanner sc = new Scanner(System.in);

        int explosiones = 0;
        int celdasVacias = 0;
        boolean salida = false;

        while (!salida) {
            imprimirTablero(tableroVisible);

            int[] posicion = pedirPosicion(sc, tableroVisible);
            int filaX = posicion[0];
            int columnaY = posicion[1];

            if (tableroOculto[filaX][columnaY]) {
                tableroVisible[filaX][columnaY] = "**";
                explosiones++;
            } else {
                tableroVisible[filaX][columnaY] = "--";
                celdasVacias++;
            }

            if (explosiones >= MAX_EXPLOSIONES) {
                imprimirTablero(tableroVisible);
                System.out.println("Lo siento, ha perdido");
                salida = true;
            } else if (celdasVacias == FILAS * COLUMNAS - TOTAL_MINAS) {
                imprimirTablero(tableroVisible);
                System.out.println("Enhorabuena, ha ganado");
                salida = true;
            }
        }

        sc.close();
    }

    static boolean[][] crearTableroOculto() {
        boolean[][] tableroOculto = new boolean[FILAS + 1][COLUMNAS + 1];
        int minasColocadas = 0;

        while (minasColocadas < TOTAL_MINAS) {
            int fila = (int)((Math.random() * FILAS) + 1);
            int columna = (int)((Math.random() * COLUMNAS) + 1);
            if (!tableroOculto[fila][columna]) {
                tableroOculto[fila][columna] = true;
                minasColocadas++;
            }
        }

        return tableroOculto;
    }

    static String[][] crearTableroVisible() {
        String[][] tableroVisible = new String[FILAS + 1][COLUMNAS + 1];

        tableroVisible[0][0] = "**"; tableroVisible[0][1] = " 1"; tableroVisible[0][2] = " 2"; tableroVisible[0][3] = " 3"; tableroVisible[0][4] = " 4"; tableroVisible[0][5] = " 5"; tableroVisible[0][6] = " 6"; tableroVisible[0][7] = " 7";
        tableroVisible[1][0] = " 1"; tableroVisible[1][1] = "  "; tableroVisible[1][2] = "  "; tableroVisible[1][3] = "  "; tableroVisible[1][4] = "  "; tableroVisible[1][5] = "  "; tableroVisible[1][6] = "  "; tableroVisible[1][7] = "  ";
        tableroVisible[2][0] = " 2"; tableroVisible[2][1] = "  "; tableroVisible[2][2] = "  "; tableroVisible[2][3] = "  "; tableroVisible[2][4] = "  "; tableroVisible[2][5] = "  "; tableroVisible[2][6] = "  "; tableroVisible[2][7] = "  ";
        tableroVisible[3][0] = " 3"; tableroVisible[3][1] = "  "; tableroVisible[3][2] = "  "; tableroVisible[3][3] = "  "; tableroVisible[3][4] = "  "; tableroVisible[3][5] = "  "; tableroVisible[3][6] = "  "; tableroVisible[3][7] = "  ";
        tableroVisible[4][0] = " 4"; tableroVisible[4][1] = "  "; tableroVisible[4][2] = "  "; tableroVisible[4][3] = "  "; tableroVisible[4][4] = "  "; tableroVisible[4][5] = "  "; tableroVisible[4][6] = "  "; tableroVisible[4][7] = "  ";
        tableroVisible[5][0] = " 5"; tableroVisible[5][1] = "  "; tableroVisible[5][2] = "  "; tableroVisible[5][3] = "  "; tableroVisible[5][4] = "  "; tableroVisible[5][5] = "  "; tableroVisible[5][6] = "  "; tableroVisible[5][7] = "  ";

        return tableroVisible;
    }

    static void imprimirTablero(String[][] tableroVisible) {
        for (int x = 0; x < tableroVisible.length; x++) {
            System.out.print("|");
            for (int y = 0; y < tableroVisible[x].length; y++) {
                System.out.print(tableroVisible[x][y]);
            }
            System.out.println("|");
        }
    }

    static int[] pedirPosicion(Scanner sc, String[][] tableroVisible) {
        while (true) {
            System.out.println("Introduzca posicion X (1-" + FILAS + ")");
            int filaX = sc.nextInt();
            System.out.println("Introduzca posicion Y (1-" + COLUMNAS + ")");
            int columnaY = sc.nextInt();

            if (filaX < 1 || filaX > FILAS || columnaY < 1 || columnaY > COLUMNAS) {
                System.out.println("Posicion fuera del tablero, intente de nuevo.");
            } else if (!tableroVisible[filaX][columnaY].equals("  ")) {
                System.out.println("Esa casilla ya fue descubierta, elija otra.");
            } else {
                return new int[]{filaX, columnaY};
            }
        }
    }
}