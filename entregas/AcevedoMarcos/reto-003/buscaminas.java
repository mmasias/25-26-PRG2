import java.util.Random;
import java.util.Scanner;

class Buscaminas {

    public static void main(String[] args) {
        Buscaminas juego = new Buscaminas();
        juego.jugar();
    }

    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int MINAS = 5;
    private static final int MAX_EXPLOSIONES = 3;

    private String[][] tableroVisible;
    private boolean[][] tableroMinas;
    private int explosiones;
    private int casillasDescubiertas;

    public Buscaminas() {
        tableroVisible = new String[FILAS][COLUMNAS];
        tableroMinas = new boolean[FILAS][COLUMNAS];
        explosiones = 0;
        casillasDescubiertas = 0;
        inicializarTablero();
        colocarMinas();
    }
    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroVisible[i][j] = "-";
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (!tableroMinas[fila][columna]) {
                tableroMinas[fila][columna] = true;
                minasColocadas++;
            }
        }
    }
    
    private void mostrarTablero() {
        System.out.println("================");
        System.out.print("  ");
        for (int j = 1; j <= COLUMNAS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tableroVisible[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }