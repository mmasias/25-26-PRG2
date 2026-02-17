import java.util.Scanner;

public class ExamenMina {

    static String[][] mapaMinasMostrar = {};

    static String[][] mapaMinasActivas = {};

    public static void main(String[] args) {

        Scanner scannerEntrada = new Scanner(System.in);

        generarMinas();

        int posicionFilaUsuario = 0;
        int posicionColumnaUsuario = 0;
        int juegoEncendido = 1;
        int valoresCorrectos;
        int contadorTurnos = 0;
        int contadorMinasEncontradas = 0;

        while (juegoEncendido == 1) {

            mostrarMapa();

            valoresCorrectos = 0;

            leerCoordenadas(scannerEntrada, null);

            if (mapaMinasActivas[posicionFilaUsuario][posicionColumnaUsuario] == "1") {
                mapaMinasMostrar[posicionFilaUsuario][posicionColumnaUsuario] = "x";
                contadorMinasEncontradas++;
            } else if (mapaMinasActivas[posicionFilaUsuario][posicionColumnaUsuario] == "0") {
                mapaMinasMostrar[posicionFilaUsuario][posicionColumnaUsuario] = ".";
            } else {
                System.out.println("No es correcta esa opcion.");
            }

            contadorTurnos++;

            if (contadorMinasEncontradas > 2) {
                juegoEncendido = 0;
                System.out.println("Has perdido");
            } else if (contadorTurnos >= 31) {
                System.out.println("Felicidades Ganador!");
                juegoEncendido = 0;
            }
        }
    }

    public static void generarMinas() {

        int contadorMinasGeneradas = 0;
        int posicionFilaMina;
        int posicionColumnaMina;
    
        do {
            posicionColumnaMina = (int) (Math.random() * 7 + 1);
            posicionFilaMina = (int) (Math.random() * 5 + 1);
    
            if (mapaMinasActivas[posicionFilaMina][posicionColumnaMina] != "1") {
                mapaMinasActivas[posicionFilaMina][posicionColumnaMina] = "1";
                contadorMinasGeneradas++;
            }
    
        } while (contadorMinasGeneradas < 5);
    }

    public static void mostrarMapa() {

        for (int fila = 0; fila < mapaMinasMostrar.length; fila++) {
            for (int columna = 0; columna < mapaMinasMostrar[fila].length; columna++) {
                System.out.print(mapaMinasMostrar[fila][columna]);
            }
            System.out.println(" ");
        }
    }
    
    public static void leerCoordenadas(Scanner scannerEntrada, int[] coordenadas) {

        int valoresCorrectos;
    
        do {
            valoresCorrectos = 1;
    
            System.out.println("Ingrese X");
            coordenadas[1] = scannerEntrada.nextInt();
    
            System.out.println("Ingrese Y");
            coordenadas[0] = scannerEntrada.nextInt();
    
            if (coordenadas[0] > 5) valoresCorrectos = 0;
            if (coordenadas[1] > 7) valoresCorrectos = 0;
    
        } while (valoresCorrectos == 0);
    }
    
}
