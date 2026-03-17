import java.util.Random;
import java.util.Scanner;

 private static final int VIDAS_MAXIMAS = 3;
 private int explosiones = 0;
 private int celdasLiberadas = 0;
 private boolean juegoTerminado = false;

 private static final int TOTAL_MINAS = 5;
    private boolean[][] mapaMinas;
    private Scanner scanner = new Scanner(System.in);
    private static final int VIDAS_MAXIMAS = 3;
    private int explosiones = 0;
    private int celdasLiberadas = 0;
    private boolean juegoTerminado = false;

    private char[][] tableroVisual;

    public void iniciar() {
        inicializarTablero();
        colocarMinas();
        
        while (!juegoTerminado) {
            imprimirTablero();
            realizarJugada();
        }
    }

    private void inicializarTablero() {
    }

    private void procesarCelda(int f, int c) {
        if (tableroVisual[f][c] != CELDA_OCULTA) {
            System.out.println("¡Ya revisaste esta casilla!");
            return;
        }

        if (mapaMinas[f][c]) {
            System.out.println("¡MINA!");
            tableroVisual[f][c] = '*';
            explosiones++;
        } else {
            System.out.println("¡Libre!");
            tableroVisual[f][c] = '.';
            celdasLiberadas++;
        }

        verificarFinal();
    }

    private void verificarFinal() {
        int totalSeguras = (FILAS * COLUMNAS) - TOTAL_MINAS;
        
        if (explosiones >= VIDAS_MAXIMAS) {
            imprimirTablero();
            System.out.println("PERDISTE. Fin del juego.");
            juegoTerminado = true;
        } else if (celdasLiberadas == totalSeguras) {
            imprimirTablero();
            System.out.println("¡GANASTE! Tablero limpio.");
            juegoTerminado = true;
        }
    }                                                                                                                                                                                                                                          


public class Buscaminas {
    private static final int FILAS = 5;
    private static final int COLUMNAS = 7;
    private static final int TOTAL_MINAS = 5;
    private static final char CELDA_OCULTA = '-';
    private static final int VIDAS_MAXIMAS = 3;

    private char[][] malla;
    private boolean[][] ubicacionMinas;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Buscaminas().ejecutar();
    }

     public void ejecutar() {
        prepararMalla();
        sembrarMinas();
        System.out.println("BUSCAMINAS");
        
        while (!juegoTerminado) {
            dibujarMalla();
            System.out.println("Vidas usadas: " + explosiones + "/" + VIDAS_MAXIMAS);
            realizarJugada();
        }
    }

    private void prepararMalla() {
        malla = new char[FILAS][COLUMNAS];
        ubicacionMinas = new boolean[FILAS][COLUMNAS];
        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {
                malla[f][c] = CELDA_OCULTA;
            }
        }
    }
    private void sembrarMinas() {
        Random random = new Random();
        int minasColocadas = 0;
        while (minasColocadas < TOTAL_MINAS) {
            int f = random.nextInt(FILAS);
            int c = random.nextInt(COLUMNAS);
            if (!ubicacionMinas[f][c]) {
                ubicacionMinas[f][c] = true;
                minasColocadas++;
            }
        }
    }

    private void dibujarMalla() {
        System.out.println("=======================");
        for (int f = 0; f < Filas; f++) {
            System.out.print((f + 1) + " | "); 
            for (int c = 0; c < Columnas; c++) {
                System.out.print(malla[f][c] + " ");
            }
            System.out.println();
        }
        System.out.println("=======================");
    }
    private void realizarJugada() {
        int fila = leerNumero("Fila", FILAS);
        int col = leerNumero("Columna", COLUMNAS);
        procesarCelda(fila - 1, col - 1); 
    }

    private int leerNumero(String dato, int max) {
        int valor = -1;
        while (true) {
            System.out.print("Ingrese " + dato + " (1-" + max + "): ");
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= 1 && valor <= max) return valor;
            } else {
                scanner.next(); 
            }
            System.out.println("Valor inválido.");
        }
    }

    private void procesarCelda(int f, int c) {
     if (malla[f][c] != CELDA_OCULTA) {
        System.out.println("¡Ya revisaste esta casilla!");
        return;
     }

        if (ubicacionMinas[f][c]) {
            System.out.println("¡ADIOOS! Has pisado una mina.");
       malla[f][c] = '*'; 
        explosiones++;
        } else {
            System.out.println("Celda limpia.");
         malla[f][c] = '.'; 
         celdasLiberadas++;
        }
     private void verificarFinal() {
        int totalSeguras = (FILAS * COLUMNAS) - TOTAL_MINAS;
        
        if (explosiones >= VIDAS_MAXIMAS) {
            dibujarMalla();
            System.out.println("GAME OVER. Pisaste " + VIDAS_MAXIMAS + " minas.");
            juegoTerminado = true;
        } else if (celdasLiberadas == totalSeguras) {
            dibujarMalla();
            System.out.println("¡GG! Has despejado todo el tablero.");
            juegoTerminado = true;
        }
    }
    }
}

