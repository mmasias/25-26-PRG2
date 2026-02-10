
import java.util.Scanner;

public class pyEdlin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String[] MEMORIA = new String[10];
        int lineaActiva = 0;
        String nuevoTexto;
        boolean fin = false;

        for (int posicion = 0; posicion < MEMORIA.length; posicion++) {
            MEMORIA[posicion] = "";
        }

        do {

            MostrarMenu(lineaActiva, MEMORIA);

            char comando = verificarComando();
            switch (comando) {
                case 'L':
                    lineaActiva = saltoDeLinea(lineaActiva, scanner);
                    break;
                case 'E':
                    MEMORIA[lineaActiva] = editarLinea(scanner);
                    break;
                case 'B':
                    borrarLinea(MEMORIA, lineaActiva);
                    break;
                case 'S':
                    fin = true;
                default:
                    System.out.println("Comando Incorrecto");
                    break;
            }

        } while (fin == false);
        System.out.println("Vuelve pronto!!");
    }

    static void MostrarMenu(int lineaActiva, String[] MEMORIA) {
        System.out.println("--------------------------------------------------");
        System.out.println("Bienvenido al bluc de notepad");
        System.out.println("--------------------------------------------------");
        for (int posicion = 0; posicion < MEMORIA.length; posicion++) {
            if (posicion == lineaActiva) {
                System.out.println(posicion + ":*| " + MEMORIA[posicion]);
            } else {
                System.out.println(posicion + ": | " + MEMORIA[posicion]);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");

    }

    static char verificarComando() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    static int saltoDeLinea(int lineaActiva, Scanner scanner) {
        System.out.println("A que linea desea saltar?");
        return scanner.nextInt();
    }

    static String editarLinea(Scanner scanner) {
        System.out.println("Escriba el texto nuevo");
        return scanner.nextLine();

    }

    static void borrarLinea(String MEMORIA[], int lineaActiva) {
        MEMORIA[lineaActiva] = "";
        System.out.println("Su texto fue borrado con exito");
    }
}
