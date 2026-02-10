 

import java.util.Scanner;

public class PyEdlinNotas {
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
                case 'L' ->          lineaActiva = saltoDeLinea(lineaActiva, scanner);

                case 'E' -> MEMORIA[lineaActiva] = editarLinea(scanner);

                case 'B' -> borrarLinea(MEMORIA, lineaActiva);

                case 'S' -> fin = true;

                case 'I' -> intercambioDeLineas(scanner, MEMORIA, lineaActiva);

                default -> System.out.println("Comando Incorrecto");
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

    static void intercambioDeLineas(Scanner scanner, String MEMORIA[], int lineaActiva) {
        System.out.println("Con que linea desea intercambiar?");
        int cambioLinea;
        String guardarTexto;

        cambioLinea = scanner.nextInt();
        guardarTexto = MEMORIA[cambioLinea];
        MEMORIA[cambioLinea] = MEMORIA[lineaActiva];
        MEMORIA[lineaActiva] = guardarTexto;
    }
}



