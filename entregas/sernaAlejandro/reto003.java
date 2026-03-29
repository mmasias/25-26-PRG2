import java.util.Random;
import java.util.Scanner;

public class Buscaminas {

    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char[][] tableroVisible = new char[FILAS][COLUMNAS];
        boolean[][] tableroMinas = new boolean[FILAS][COLUMNAS];

        // Inicializar tablero visible
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tableroVisible[i][j] = '-';
            }
        }

        // Colocar minas aleatoriamente
        int minasColocadas = 0;
        while (minasColocadas < MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (!tableroMinas[fila][columna]) {
                tableroMinas[fila][columna] = true;
                minasColocadas++;
            }
        }

        int explosiones = 0;
        int casillasDescubiertas = 0;
        int totalSeguras = FILAS * COLUMNAS - MINAS;

        // Juego principal
        while (explosiones < MAX_EXPLOSIONES && casillasDescubiertas < totalSeguras) {

            mostrarTablero(tableroVisible);

            System.out.println("Ingrese X (fila): ");
            int x = sc.nextInt() - 1;

            System.out.println("Ingrese Y (columna): ");
            int y = sc.nextInt() - 1;

            // Validar rango
            if (x < 0 || x >= FILAS || y < 0 || y >= COLUMNAS) {
                System.out.println("Posición inválida. Intente nuevamente.");
                continue;
            }

            // Verificar si ya fue descubierta
            if (tableroVisible[x][y] != '-') {
                System.out.println("Casilla ya descubierta. Intente otra.");
                continue;
            }

            System.out.println("----------------");

            if (tableroMinas[x][y]) {
                System.out.println("¡Mina!");
                tableroVisible[x][y] = '*';
                explosiones++;
                System.out.println("Explosiones: " + explosiones);
            } else {
                System.out.println("¡Libre!");
                tableroVisible[x][y] = '.';
                casillasDescubiertas++;
            }
        }

        // Mostrar tablero final
        mostrarTablero(tableroVisible);

        if (casillasDescubiertas == totalSeguras) {
            System.out.println("🎉 ¡Ganaste! Liberaste todas las casillas seguras.");
        } else {
            System.out.println("💥 ¡Perdiste! Explotaron 3 minas.");
        }

        sc.close();
    }

    public static void mostrarTablero(char[][] tablero) {
        System.out.println("================");
        System.out.print("  ");
        for (int i = 1; i <= COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}
