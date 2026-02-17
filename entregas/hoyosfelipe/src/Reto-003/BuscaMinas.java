import java.util.Scanner;

public class BuscaMinas {
    
    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;
    
    static char[][] tableroJuego;
    static char[][] tableroVisible;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Buscaminas!");
        inicializarTablero();
        colocarMinasAleatorias();
        
        int minasExplotadas = 0;
        boolean juegoTerminado = false;
        
        while (juegoTerminado == false) {
            mostrarTablero();
            int[] coordenadas = pedirCoordenadas(scanner);
            boolean hayMina = procesarJugada(coordenadas[0], coordenadas[1]);
            
            if (hayMina) {
                minasExplotadas++;
            }
            
            juegoTerminado = verificarFinDeJuego(minasExplotadas);
        }
        
        mostrarTablero();
        scanner.close();
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
    
    static int[] pedirCoordenadas(Scanner scanner) {
        System.out.print("Ingrese X: ");
        int columna = scanner.nextInt();
        System.out.print("Ingrese Y: ");
        int fila = scanner.nextInt();
        
        int[] coordenadas = new int[2];
        coordenadas[0] = fila - 1;
        coordenadas[1] = columna - 1;
        return coordenadas;
    }
    
    static boolean procesarJugada(int fila, int columna) {
        if (tableroJuego[fila][columna] == '*') {
            tableroVisible[fila][columna] = '*';
            System.out.println("----------------");
            System.out.println("Mina!");
            return true;
        } else {
            tableroVisible[fila][columna] = '.';
            System.out.println("----------------");
            System.out.println("Libre!");
            return false;
        }
    }
    
    static boolean verificarFinDeJuego(int minasExplotadas) {
        if (minasExplotadas >= MAX_EXPLOSIONES) {
            System.out.println("Has perdido! Explotaron 3 minas");
            return true;
        }
        
        int casillasLibres = 0;
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (tableroVisible[fila][columna] == '.') {
                    casillasLibres++;
                }
            }
        }
        
        if (casillasLibres == (FILAS * COLUMNAS - TOTAL_MINAS)) {
            System.out.println("Felicidades! Has ganado!");
            return true;
        }
        
        return false;
    }
}