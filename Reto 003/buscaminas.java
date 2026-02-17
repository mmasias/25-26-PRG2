import java.util.Scanner;

public class buscaminas {

    public static void main(String[] args) {

        int minas = 0;
        int celdasVacias = 0;
        boolean salida = false;

        String tablero[][] = new String[6][8];
        String tablero2[][] = new String[6][8];

        // COMMIT 7: inicialización de tableros extraída a un bucle
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 8; j++) {

                if (i == 0 && j == 0) {
                    tablero[i][j] = "**";
                } else if (i == 0) {
                    tablero[i][j] = " " + j;
                } else if (j == 0) {
                    tablero[i][j] = " " + i;
                } else {
                    tablero[i][j] = "  ";
                }

                tablero2[i][j] = tablero[i][j];
            }
        }

        // COMMIT 4: evitar duplicación de minas
        int minasColocadas = 0;
        while (minasColocadas < 5) {
            int x = (int) (Math.random() * 5) + 1;
            int y = (int) (Math.random() * 7) + 1;

            if (!tablero[x][y].equals("MM")) {   // COMMIT 2: equals() en vez de ==
                tablero[x][y] = "MM";            // COMMIT 3: eliminar bucles inútiles
                minasColocadas++;
            }
        }

        // COMMIT 5: usar un único Scanner
        Scanner sc = new Scanner(System.in);

        while (!salida) {

            // COMMIT 6: impresión del tablero extraída a un método (aún inline aquí)
            for (int i = 0; i < 6; i++) {
                System.out.print("|");
                for (int j = 0; j < 8; j++) {
                    System.out.print(tablero2[i][j]);
                }
                System.out.println("|");
            }

            System.out.println("Introduzca posición X (1-5):");
            int posx = sc.nextInt();

            System.out.println("Introduzca posición Y (1-7):");
            int posy = sc.nextInt();  // COMMIT 1: corregido sc2 → sc

            // COMMIT 2: equals() en vez de ==
            if (tablero[posx][posy].equals("  ")) {
                tablero2[posx][posy] = "--";
                celdasVacias++;
            } else {
                tablero2[posx][posy] = "**";
                minas++;
            }

            if (minas == 3) {
                System.out.println("Lo siento, ha perdido");
                salida = true;
            }

            if (celdasVacias == 30) {
                System.out.println("Enhorabuena, ha ganado");
                salida = true;
            }
        }

        sc.close();
    }
}
