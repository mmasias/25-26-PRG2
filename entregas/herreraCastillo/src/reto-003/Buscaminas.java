import java.util.Scanner;


public class Buscaminas {

    static final int TOTAL_FILAS = 5;
    static final int TOTAL_COLUMNAS = 7;
    static final int CANTIDAD_MINAS = 5;
    static final int MAXIMO_EXPLOSIONES = 3;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        boolean[][] mapaMinas = new boolean[TOTAL_FILAS][TOTAL_COLUMNAS ];
        char[][] tableroVisual = new char[TOTAL_FILAS][TOTAL_COLUMNAS];

        int explosionesRecibidas = 0;
        int casillasLiberadas = 0;

        inicializarTableroVisual(tableroVisual);
        dibujarTablero(tableroVisual);

        int filaElegida = leerCoordenada("Ingrese X", TOTAL_FILAS, entrada);
        int columnaElegida = leerCoordenada("Ingrese Y", TOTAL_COLUMNAS, entrada);

    }

    public static int leerCoordenada(String mensaje, int limite, Scanner entrada) {
        int valor = 0;
        boolean esValido = false;
        while (!esValido) {
            System.out.println(mensaje);
            valor = entrada.nextInt();
            if (valor >= 1 && valor <= limite) {
                esValido = true;
            }
        }
        return valor - 1;
    }
    
    public static void colocarMinas(boolean[][] mapa) {
        int minasColocadas = 0;

        while (minasColocadas < CANTIDAD_MINAS) {
            int filaAleatoria = generarNumeroAleatorio(TOTAL_FILAS);
            int columnaAleatoria = generarNumeroAleatorio(TOTAL_COLUMNAS);

            if (!mapa[filaAleatoria][columnaAleatoria]) {
                mapa[filaAleatoria][columnaAleatoria] = true;
                minasColocadas++;
            }
        }
    }
    public static int generarNumeroAleatorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public static void inicializarTableroVisual(char[][] tablero) {
        for (int fila = 0; fila < TOTAL_FILAS; fila++) {
            for (int columna = 0; columna < TOTAL_COLUMNAS; columna++) {
                tablero[fila][columna] = '-';
            }
        }
    }
    public static void dibujarTablero(char[][] tablero) {
        System.out.print("  ");
        for (int columna = 0; columna < TOTAL_COLUMNAS; columna++) {
            System.out.print((columna + 1) + " ");
        }
        System.out.println();

        for (int fila = 0; fila < TOTAL_FILAS; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < TOTAL_COLUMNAS; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();

            
        }
    }
}
