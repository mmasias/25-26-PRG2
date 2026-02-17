import java.util.Scanner;

public class ExamenMina {
    

    static String[][] mapaMinasMostrar = {
            { " ", "1", "2", "3", "4", "5", "6", "7" },
            { "1", "-", "-", "-", "-", "-", "-", "-" },
            { "2", "-", "-", "-", "-", "-", "-", "-" },
            { "3", "-", "-", "-", "-", "-", "-", "-" },
            { "4", "-", "-", "-", "-", "-", "-", "-" },
            { "5", "-", "-", "-", "-", "-", "-", "-" }
    };

    static int[][] mapaMinasActivas = new int[6][8];

    public static void main(String[] args) {
        boolean juegoEncendido = true;
        int posicionX = 0, posicionY = 0;
        int contadorMapa = 0;
        int contadorMinas = 0;
        int i = 0;
    
        Scanner scanner = new Scanner(System.in);

        while (i < 5) {
            int filaRandom = (int) (Math.random() * 5) + 1;   
            int columnaRandom = (int) (Math.random() * 7) + 1; 
            if (mapaMinasActivas[filaRandom][columnaRandom] == 0) {
                mapaMinasActivas[filaRandom][columnaRandom] = 1; 
                i++;
            }
        }

        while (juegoEncendido) {

            for (int f = 0; f < mapaMinasMostrar.length; f++) {
                for (int c = 0; c < mapaMinasMostrar[f].length; c++) {
                    System.out.print(mapaMinasMostrar[f][c] + " ");
                }
                System.out.println("");
            }

            boolean valoresCorrectos = false; 
            while (!valoresCorrectos) {
                System.out.println("Ingrese Fila (1-5):");
                posicionX = scanner.nextInt();
                System.out.println("Ingrese Columna (1-7):");
                posicionY = scanner.nextInt();

                if (posicionX >= 1 && posicionX <= 5 && posicionY >= 1 && posicionY <= 7) {
                    valoresCorrectos = true;
                } else {
                    System.out.println("Error: Coordenadas fuera de rango.");
                }
            }

            if (mapaMinasActivas[posicionX][posicionY] == 1) {
                mapaMinasMostrar[posicionX][posicionY] = "x";
                contadorMinas++;
                mapaMinasActivas[posicionX][posicionY] = 2; 
                System.out.println("--> ¡BOOM! Mina encontrada.");
            } 
            else if (mapaMinasActivas[posicionX][posicionY] == 0) {
                mapaMinasMostrar[posicionX][posicionY] = ".";
                contadorMapa++;
                mapaMinasActivas[posicionX][posicionY] = 2; 
                System.out.println("--> Agua. Sigue buscando.");
            } 
            else {
                System.out.println("--> Ya habías marcado esa casilla.");
            }

            if (contadorMinas >= 3) {
                System.out.println("Perdieste explotaste 3 minas.");
                juegoEncendido = false;
            } else if (contadorMapa >= 15) {
                System.out.println("Victoria has despejado el área.");
                juegoEncendido = false;
            }
        }
        scanner.close();
    }
}