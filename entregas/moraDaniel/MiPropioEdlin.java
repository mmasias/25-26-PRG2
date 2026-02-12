

import java.util.Scanner;

public class MiPropioEdlin {
    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineas = crearArrayLineas();
        String[] copiaAnterior = crearArrayLineas();
        int lineaActiva = 1;
        boolean salir = false;
        while (!salir) {
            mostrarEditor(lineas, lineaActiva);
            String comando = leerComando(scanner);
            switch (comando) {
                case "L":
                    lineaActiva = cambiarLineaActiva(scanner, lineaActiva);
                    break;
                case "E":
                    copiarEstado(lineas, copiaAnterior);
                    editarLinea(scanner, lineas, lineaActiva);
                    break;
                case "B":
                    copiarEstado(lineas, copiaAnterior);
                    borrarLinea(lineas, lineaActiva);
                    break;
                case "I":
                    copiarEstado(lineas, copiaAnterior);
                    intercambiarLineas(scanner, lineas);
                    break;
                case "D":
                    deshacer(lineas, copiaAnterior);
                    break;
                default:
                    mostrarMensaje("Comando no reconocido ");

            }
        }
        scanner.close();

    }

    static String[] crearArrayLineas() {
        String[] array = new String[MAX_LINEAS];

        array[0] = "Bienvenidos al editor EDLIN";
        array[1] = "Utilice el menu inferior para editar el texto";
        array[2] = "------";
        array[3] = "[L] permite definir la linea activa";
        array[4] = "[E] permite editar la linea activa";
        array[5] = "[I] permite intercambiar dos lineas";
        array[6] = "[B] borra el contenido de la linea activa";
        array[7] = "[D] deshace la última acción realizada";
        array[8] = "[S] sale del programa";
        array[9] = "";

        return array;
    }

    static void mostrarEditor(String[] lineas, int lineaActiva) {
        for (int i = 0; i < MAX_LINEAS; i++) {
            if (i == lineaActiva) {
                System.out.println(i + ":*| " + lineas[i]);
            } else {
                System.out.println(i + ": | " + lineas[i]);
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");

    }

    static String leerComando(Scanner scanner) {
        System.out.print("Seleccione comando: ");
        return scanner.nextLine().toUpperCase();
    }

    static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    static int cambiarLineaActiva(Scanner scanner, int lineaActual) {
        System.out.print("Ingrese número de línea (0-9): ");
        int nuevaLinea = Integer.parseInt(scanner.nextLine());

        if (nuevaLinea >= 0 && nuevaLinea < MAX_LINEAS) {
            return nuevaLinea;
        } else {
            mostrarMensaje("Número inválido.");
            return lineaActual;
        }
    }

    static void editarLinea(Scanner scanner, String[] lineas, int lineaActiva) {
        System.out.print("Nuevo texto: ");
        lineas[lineaActiva] = scanner.nextLine();
    }

    static void borrarLinea(String[] lineas, int lineaActiva) {
        lineas[lineaActiva] = "";
    }

    static void intercambiarLineas(Scanner scanner, String[] lineas) {

        System.out.print("Primera línea: ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Segunda línea: ");
        int b = Integer.parseInt(scanner.nextLine());

        if (a >= 0 && a < MAX_LINEAS && b >= 0 && b < MAX_LINEAS) {
            String temp = lineas[a];
            lineas[a] = lineas[b];
            lineas[b] = temp;
        } else {
            mostrarMensaje("Líneas inválidas.");
        }
    }

    static void deshacer(String[] lineas, String[] copiaAnterior) {
        copiarEstado(copiaAnterior, lineas);
    }

    static void copiarEstado(String[] origen, String[] destino) {
        for (int i = 0; i < MAX_LINEAS; i++) {
            destino[i] = origen[i];
        }
    }
}
