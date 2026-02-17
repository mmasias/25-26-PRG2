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