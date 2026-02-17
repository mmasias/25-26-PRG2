public class Buscaminas {

    static final int TOTAL_FILAS = 5;
    static final int TOTAL_COLUMNAS = 7;
    static final int CANTIDAD_MINAS = 5;
    static final int MAXIMO_EXPLOSIONES = 3;

    public static void main(String[] args) {

        boolean[][] mapaMinas = new boolean[TOTAL_FILAS][TOTAL_COLUMNAS ];
        char[][] tableroVisual = new char[TOTAL_FILAS][TOTAL_COLUMNAS];

        int explosionesRecibidas = 0;
        int casillasLiberadas = 0;

        inicializarTableroVisual(tableroVisual);

        
    }

    public static void inicializarTableroVisual(char[][] tablero) {
        for (int fila = 0; fila < TOTAL_FILAS; fila++) {
            for (int columna = 0; columna < TOTAL_COLUMNAS; columna++) {
                tablero[fila][columna] = '-';
            }
        }
    }
    
}