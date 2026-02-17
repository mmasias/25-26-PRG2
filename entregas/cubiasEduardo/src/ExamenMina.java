import java.util.Scanner;

public class ExamenMina {

    static String[][] mapaMinasMostrar = new String[6][8];
    static String[][] mapaMinasActivas = new String[6][8];


    static final int TOTAL_MINAS = 5;
    static final int LIMITE_MINAS_PERDER = 2;
    static final int LIMITE_TURNOS_GANAR = 31;


    public static void main(String[] args) {

        Scanner scannerEntrada = new Scanner(System.in);
    
        int[] coordenadasUsuario = new int[2];
        int[] juegoEncendido = {1};
        int[] contadorMinasEncontradas = {0};
    
        int contadorTurnos = 0;
    
        generarMinas();
    
        do {
    
            mostrarMapa();
    
            leerCoordenadas(scannerEntrada, coordenadasUsuario);
    
            revelarCelda(
                    coordenadasUsuario[0],
                    coordenadasUsuario[1],
                    contadorMinasEncontradas
            );
    
            contadorTurnos++;
    
            evaluarEstadoJuego(
                    contadorTurnos,
                    contadorMinasEncontradas[0],
                    juegoEncendido
            );
    
        } while (juegoEncendido[0] == 1);
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

    public static void revelarCelda(int fila, int columna, int[] contadorMinasEncontradas) {

        String valorCelda = mapaMinasActivas[fila][columna];
    
        if (valorCelda.equals("1")) {
            mapaMinasMostrar[fila][columna] = "*";
            contadorMinasEncontradas[0]++;
        }
    
        if (valorCelda.equals("0")) {
            mapaMinasMostrar[fila][columna] = ".";
        }
    }
    
    
    public static void evaluarEstadoJuego(int contadorTurnos, int contadorMinasEncontradas, int[] juegoEncendido) {

        if (contadorMinasEncontradas > 2) {
            juegoEncendido[0] = 0;
            System.out.println("Has perdido");
        }
    
        if (contadorTurnos >= 31) {
            juegoEncendido[0] = 0;
            System.out.println("Felicidades Ganador!");
        }
    }
    
}
