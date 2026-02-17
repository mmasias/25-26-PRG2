import java.util.Scanner;

public class BuscaMinas {
    
    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;
    
    static char[][] tableroJuego;
    static char[][] tableroVisible;
    
    public static void main(String[] args) {
        System.out.println("Bienvenido al Buscaminas!");
        inicializarTablero();
        colocarMinasAleatorias();
        mostrarTablero();
    }
    
    static void inicializarTablero() {
        tableroJuego = new char[FILAS][COLUMNAS];
        tableroVisible = new char[FILAS][COLUMNAS];
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                tableroJuego[fila][columna] = '.';
                tableroVisible[fila][columna] = '-';
            }
        }
    }
    
    static void colocarMinasAleatorias() {
        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int filaAleatoria = (int)(Math.random() * FILAS);
            int columnaAleatoria = (int)(Math.random() * COLUMNAS);
            
            if (tableroJuego[filaAleatoria][columnaAleatoria] != '*') {
                tableroJuego[filaAleatoria][columnaAleatoria] = '*';
                minasColocadas++;
            }
        }
    }
    
    static void mostrarTablero() {
        System.out.println("================");
        System.out.print("  ");
        for (int columna = 1; columna <= COLUMNAS; columna++) {
            System.out.print(columna + " ");
        }
        System.out.println();
        
        for (int fila = 0; fila < FILAS; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < COLUMNAS; columna++) {
                System.out.print(tableroVisible[fila][columna] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}