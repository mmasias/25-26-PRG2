

	
	
import java.util.Scanner;
public class buscaminas{
    static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int MINAS_TOTALES = 5;
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[][] tablero = new String[FILAS][COLUMNAS];
        String[][] visible = new String[FILAS][COLUMNAS];

        int minasExplotadas = 0;
        int celdasLibres = 0;
        boolean salir = false;
	
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = " ";
                visible[i][j] = "-";
            }
        }

        int minasColocadas = 0;
        while (minasColocadas < MINAS_TOTALES) {
            int x = (int)(Math.random() * FILAS);
            int y = (int)(Math.random() * COLUMNAS);

            if (!tablero[x][y].equals("M")) {
                tablero[x][y] = "M";
                minasColocadas++;
            }
        }

        while (!salir) {

            mostrarTablero(visible);

            System.out.println("Ingrese X (1-5): ");
            int posX = sc.nextInt() - 1;

            System.out.println("Ingrese Y (1-7): ");
            int posY = sc.nextInt() - 1;

            if (tablero[posX][posY].equals("M")) {
                System.out.println(" Mina!");
                visible[posX][posY] = "*";
                minasExplotadas++;
            } else {
                System.out.println("Libre!");
                visible[posX][posY] = ".";
                celdasLibres++;
                }

            if (minasExplotadas == 3) {
                System.out.println("Lo siento, has perdido.");
                salir = true;
            }

            if (celdasLibres == (FILAS * COLUMNAS - MINAS_TOTALES)) {
                System.out.println("¡Enhorabuena, has ganado!");
                salir = true;
            }
        }

        sc.close();
    }

    public static void mostrarTablero(String[][] tablero) {
        System.out.println("================");
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================");
    }
}