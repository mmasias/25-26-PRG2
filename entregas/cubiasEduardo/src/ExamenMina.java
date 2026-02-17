import java.util.Scanner;

public class ExamenMina {

    static String[][] mapaMinasMostrar = {
            {" ", "1", "2", "3", "4", "5", "6", "7"},
            {"1", "-", "-", "-", "-", "-", "-", "-"},
            {"2", "-", "-", "-", "-", "-", "-", "-"},
            {"3", "-", "-", "-", "-", "-", "-", "-"},
            {"4", "-", "-", "-", "-", "-", "-", "-"},
            {"5", "-", "-", "-", "-", "-", "-", "-"}
    };

    static String[][] mapaMinasActivas = {
            {" ", "1", "2", "3", "4", "5", "6", "7"},
            {"1", "0", "0", "0", "0", "0", "0", "0"},
            {"2", "0", "0", "0", "0", "0", "0", "0"},
            {"3", "0", "0", "0", "0", "0", "0", "0"},
            {"4", "0", "0", "0", "0", "0", "0", "0"},
            {"5", "0", "0", "0", "0", "0", "0", "0"}
    };

    public static void main(String[] args) {

        Scanner scannerEntrada = new Scanner(System.in);

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

        int posicionFilaUsuario = 0;
        int posicionColumnaUsuario = 0;
        int juegoEncendido = 1;
        int valoresCorrectos;
        int contadorTurnos = 0;
        int contadorMinasEncontradas = 0;

        while (juegoEncendido == 1) {

            for (int fila = 0; fila < mapaMinasMostrar.length; fila++) {
                for (int columna = 0; columna < mapaMinasMostrar[fila].length; columna++) {
                    System.out.print(mapaMinasMostrar[fila][columna]);
                }
                System.out.println(" ");
            }

            valoresCorrectos = 0;

            while (valoresCorrectos == 0) {

                System.out.println("Ingrese X");
                posicionColumnaUsuario = scannerEntrada.nextInt();

                System.out.println("Ingrese Y");
                posicionFilaUsuario = scannerEntrada.nextInt();

                if (posicionFilaUsuario > 5) {
                    valoresCorrectos = 0;
                } else if (posicionColumnaUsuario > 7) {
                    valoresCorrectos = 0;
                } else {
                    valoresCorrectos = 1;
                }
            }

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
}
