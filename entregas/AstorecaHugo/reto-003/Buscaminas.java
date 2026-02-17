
import java.util.Scanner;

public class Buscaminas {

    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int TOTAL_MINAS = 5;
    static final int MINA = -1;

    public static void main(String[] args) {


        int posx = 0;
        int posy = 0;
        boolean salida = false;

        String tablero[][] = crearTablero();
        String tablero2[][] = crearTablero();

        colocarMinas(tablero);
        mostrarTablero(tablero2);

        while (!salida) {

            pedirCoordenadas(posx, posy);

            if (esMina(tablero, posx, posy)) {
                System.out.println("Has perdido");
                salida = true;
            } else {
                descubrirCelda(tablero, tablero2, posx, posy);
                mostrarTablero(tablero2);
            }
        }

    }

    static String[][] crearTablero() {
        String tablero[][] = new String[FILAS + 1][COLUMNAS + 1];
        tablero[0][0] = "**";
        for (int i = 1; i <= FILAS; i++) {
            tablero[i][0] = "" + i;

        }
        for (int j = 1; j <= COLUMNAS; j++) {
            tablero[0][j] = "" + j;
            for (int i = 1; i <= FILAS; i++) {
                tablero[i][j] = " ";
            }

        }
        return tablero;
    }

    static void mostrarTablero(String tablero[][]) {
        for (int x = 0; x < tablero.length; x++) {
            System.out.print("|");
            for (int y = 0; y < tablero[0].length; y++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println("|");
        }
    }

    static void colocarMinas(String tablero[][]) {
        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int fila = (int) (Math.random() * FILAS) + 1;
            int columna = (int) (Math.random() * COLUMNAS) + 1;
            if (tablero[fila][columna] != "*") {
                tablero[fila][columna] = "*";
                minasColocadas++;
            }
        }
    }

    static void pedirCoordenadas(int posx, int posy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la coordenada x:");
        posx = scanner.nextInt();
        System.out.println("Introduce la coordenada y:");
        posy = scanner.nextInt();
    }

    static boolean esMina(String tablero[][], int posx, int posy) {
        return tablero[posx][posy] == "*";

    }

    static boolean descubrirCelda(String[][] tablero, String[][] tableroVisible, int x, int y) {
        if (esMina(tablero, x, y)) {
            tableroVisible[x][y] = "**";
            return true;

        }
    return false;
    }
}



