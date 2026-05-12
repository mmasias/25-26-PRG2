import java.util.Scanner;

class BuscaMinas {

    public static void main(String[] args) {

        String[][] mapaMostrar = obtenerMapaMostrar();
        String[][] mapaActivas = obtenerMapaActivas();
        colocarMinas(mapaActivas);

        final int MAX_INTENTOS = 31;
        final int LIMITE_MINAS = 2;
        
        int contadorMinas = 0;
        int contadorTurnos = 0;
        boolean seguirJugando = true;

        do {
            imprimir(mapaMostrar);
            int[] posicion = elegirPosicion();
            int x = posicion[0];
            int y = posicion[1];

            if (mapaActivas[x][y].equals("1")) {
                mapaMostrar[x][y] = "x";
                contadorMinas++;
            } else if (mapaActivas[x][y].equals("0")) {
                mapaMostrar[x][y] = ".";
            } else {
                System.out.println("No es correcta esa opcion.");
            }

            contadorTurnos++;

            if (contadorMinas > LIMITE_MINAS) {
                System.out.println("Has perdido");
                seguirJugando = false;
            } else if (contadorTurnos >= MAX_INTENTOS) {
                System.out.println("Felicidades Ganador!");
                seguirJugando = false;
            }

        } while (seguirJugando);
    }

    static String[][] obtenerMapaMostrar() {
        return new String[][] {
                {" ", "1", "2", "3", "4", "5", "6", "7"},
                {"1", "-", "-", "-", "-", "-", "-", "-"},
                {"2", "-", "-", "-", "-", "-", "-", "-"},
                {"3", "-", "-", "-", "-", "-", "-", "-"},
                {"4", "-", "-", "-", "-", "-", "-", "-"},
                {"5", "-", "-", "-", "-", "-", "-", "-"}
        };
    }

    static String[][] obtenerMapaActivas() {
        return new String[][] {
                {" ", "1", "2", "3", "4", "5", "6", "7"},
                {"1", "0", "0", "0", "0", "0", "0", "0"},
                {"2", "0", "0", "0", "0", "0", "0", "0"},
                {"3", "0", "0", "0", "0", "0", "0", "0"},
                {"4", "0", "0", "0", "0", "0", "0", "0"},
                {"5", "0", "0", "0", "0", "0", "0", "0"}
        };
    }

    static void colocarMinas(String[][] mapaActivas) {
        int colocadas = 0;
        final int TOTAL_MINAS = 5;
        while (colocadas < TOTAL_MINAS) {
            int posYMina = (int) (Math.random() * 2 + 1);
            int posXMina = (int) (Math.random() * 4 + 1);
            if (!mapaActivas[posXMina + 1][posYMina + 1].equals("1")) {
                mapaActivas[posXMina + 1][posYMina + 1] = "1";
                colocadas++;
            }
        }
    }

    static void imprimir(String[][] escenario) {
        for (int i = 0; i < escenario.length; i++) {
            for (int j = 0; j < escenario[i].length; j++) {
                System.out.print(escenario[i][j]);
            }
            System.out.println(" ");
        }
    }

    static int[] elegirPosicion() {
        Scanner scan = new Scanner(System.in);
        int posX, posY;
        boolean valido = false;
        do {
            System.out.println(" ");
            System.out.println("Ingrese X");
            posY = scan.nextInt();
            System.out.println("Ingrese Y");
            posX = scan.nextInt();
            if (posX <= 5 && posY <= 7) {
                valido = true;
            }
        } while (!valido);
        return new int[] { posX, posY };
    }
}