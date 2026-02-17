package entregas.sanmiguelHector.reto003;
import java.util.Random;
import java.util.Scanner;

class Buscaminas {

    static final int NUMERO_DE_FILAS = 5;
    static final int NUMERO_DE_COLUMNAS = 7;
    static final int NUMERO_DE_MINAS_INICIALES = 5;
    static final int NUMERO_DE_MINAS_ENCONTRADAS_PERMITIDAS = 3;
    static final int NUMERO_DE_CASILLAS_SEGURAS = NUMERO_DE_FILAS * NUMERO_DE_COLUMNAS - NUMERO_DE_MINAS_INICIALES;

    static Scanner scanner = new Scanner(System.in);

    static char[][] tableroReal = new char[NUMERO_DE_FILAS][NUMERO_DE_COLUMNAS];
    static char[][] tableroVisible = new char[NUMERO_DE_FILAS][NUMERO_DE_COLUMNAS];

    static int conteoMinas = 0;
    static int conteoCasillasSeguras = 0;

    public static void main(String[] args) {
        crearTablero();
        colocarMinas();
        mostrarTablero();

        while (!elJuegoHaTerminado()) {
            turnoJugador();
            mostrarTablero();
        }
    }

    static void crearTablero() {
        for (int f = 0; f < NUMERO_DE_FILAS; f++) {
            for (int c = 0; c < NUMERO_DE_COLUMNAS; c++) {
                tableroReal[f][c] = ' ';
                tableroVisible[f][c] = '-';
            }
        }
    }

    static void mostrarTablero() {
        System.out.print("   ");
        for (int columna = 0; columna < NUMERO_DE_COLUMNAS; columna++) {
            System.out.print((columna + 1) + " ");
        }
        System.out.println();

        for (int fila = 0; fila < NUMERO_DE_FILAS; fila++) {
            System.out.print((fila + 1) + "  ");
            for (int columna = 0; columna < NUMERO_DE_COLUMNAS; columna++) {
                System.out.print(tableroVisible[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    static void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < NUMERO_DE_MINAS_INICIALES) {
            int fila = random.nextInt(NUMERO_DE_FILAS);
            int columna = random.nextInt(NUMERO_DE_COLUMNAS);

            if (tableroReal[fila][columna] != '*') {
                tableroReal[fila][columna] = '*';
                minasColocadas++;
            }
        }
    }

    static void turnoJugador() {
        System.out.print("Introduce fila: ");
        int fila = scanner.nextInt();

        System.out.print("Introduce columna: ");
        int columna = scanner.nextInt();

        validarEleccion(fila, columna);
    }

    static void validarEleccion(int fila, int columna) {

        fila--;
        columna--;

        if (fila < 0 || fila >= NUMERO_DE_FILAS ||
            columna < 0 || columna >= NUMERO_DE_COLUMNAS) {

            System.out.println("Coordenadas fuera de rango.");
            return;
        }

        if (tableroVisible[fila][columna] != '-') {
            System.out.println("Esa casilla ya fue descubierta.");
            return;
        }

        if (tableroReal[fila][columna] == '*') {
            tableroVisible[fila][columna] = '*';
            conteoMinas++;
            System.out.println("Es una mina.");
        } else {
            tableroVisible[fila][columna] = '.';
            conteoCasillasSeguras++;
            System.out.println("Casilla segura.");
        }
    }

    static boolean elJuegoHaTerminado() {

        if (conteoMinas >= NUMERO_DE_MINAS_ENCONTRADAS_PERMITIDAS) {
            System.out.println("Has explotado, perdiste.");
            return true;
        }

        if (conteoCasillasSeguras == NUMERO_DE_CASILLAS_SEGURAS) {
            System.out.println("Has sobrevivido, ganaste.");
            return true;
        }

        return false;
    }
}
