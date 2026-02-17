import java.util.Scanner;

public class ExamenMina {

    static String[][] tablero = new String[6][8];
    static String[][] ubicacionMinas = new String[6][8];

    public static void main(String[] args) {    

        inicializarTablero();
        inicializarMinas();
        colocarMinasAleatorias(5);

        Scanner scanner = new Scanner(System.in);

        int posicionFila = 0, posicionColumna = 0, juegoEncendido = 1, contadorMovimientos = 0, contadorMinas = 0;

        while (juegoEncendido == 1) {
            mostrarTablero(tablero);
            int[] coordenadas = pedirCoordenadas(scanner);
            posicionFila = coordenadas[0];
            posicionColumna = coordenadas[1];

            contadorMinas = actualizarTablero(posicionFila, posicionColumna, contadorMinas);
            contadorMovimientos++;
            juegoEncendido = verificarFinJuego(contadorMinas, contadorMovimientos);
        }
    }

    public static int[] pedirCoordenadas(Scanner scanner) {
        int fila = 0, columna = 0;
        boolean valido = false;

        while (!valido) {
            System.out.println("\nIngrese X:");
            columna = scanner.nextInt();
            System.out.println("Ingrese Y:");
            fila = scanner.nextInt();

            if (fila < 1 || fila > 5 || columna < 1 || columna > 7) {
                System.out.println("Coordenadas fuera de rango. Intenta de nuevo.");
            } else {
                valido = true;
            }
        }

        return new int[]{fila, columna};
    }

    public static void inicializarTablero() {
        tablero[0][0] = " ";
        for (int j = 1; j < 8; j++) {
            tablero[0][j] = String.valueOf(j);
        }
        for (int i = 1; i < 6; i++) {
            tablero[i][0] = String.valueOf(i);
            for (int j = 1; j < 8; j++) {
                tablero[i][j] = "-";
            }
        }
    }

    public static void inicializarMinas() {
        ubicacionMinas[0][0] = " ";
        for (int j = 1; j < 8; j++) {
            ubicacionMinas[0][j] = String.valueOf(j);
        }
        for (int i = 1; i < 6; i++) {
            ubicacionMinas[i][0] = String.valueOf(i);
            for (int j = 1; j < 8; j++) {
                ubicacionMinas[i][j] = "0";
            }
        }
    }

    public static void colocarMinasAleatorias(int cantidad) {
        int i = 0;
        while (i < cantidad) {
            int minaPosicionColumna = (int)(Math.random() * 2 + 1);
            int minaPosicionFila = (int)(Math.random() * 4 + 1);

            if (ubicacionMinas[minaPosicionFila][minaPosicionColumna].equals("1")) {
                i--;
            } else {
                ubicacionMinas[minaPosicionFila + 1][minaPosicionColumna + 1] = "1";
            }
            i++;
        }
    }

    public static void mostrarTablero(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int actualizarTablero(int fila, int columna, int contadorMinas) {
        if (ubicacionMinas[fila][columna].equals("1")) {
            tablero[fila][columna] = "*";
            contadorMinas++;
        } else if (ubicacionMinas[fila][columna].equals("0")) {
            tablero[fila][columna] = ".";
        } else {
            System.out.println("No es correcta esa opción.");
        }
        return contadorMinas;
    }

    public static int verificarFinJuego(int contadorMinas, int contadorMovimientos) {
        if (contadorMinas > 2) {
            System.out.println("Has perdido");
            return 0;
        } else if (contadorMovimientos >= 31) {
            System.out.println("Felicidades Ganador!");
            return 0; 
        } else {
            return 1; 
        }
    }
}
