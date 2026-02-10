
import java.util.Scanner;

class edlin {

    private static final int MAX_LINEAS = 10;
    private static String[] lineas = new String[MAX_LINEAS];
    private static int lineaActual = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarTexto();
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            System.out.print("Ingrese un comando: ");
            String comando = scanner.nextLine();
            switch (comando) {
                case "L":
                    cambiarLineaActiva();
                    break;
                case "E":
                    editarLineaActiva();
                    break;
                case "B":
                    borrarLineaActiva();
                    break;
                case "I":
                    intercambiarLineas();
                    break;
                case "S":
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

            }

        }
    }

    static void cargarTexto() {
        for (int i = 0; i < MAX_LINEAS; i++) {
            lineas[i] = "";
        }

        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[S] sale del programa";
    }

    static void mostrarMenu() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String seleccion;
            if (i == lineaActual) {
                seleccion = "*";
            } else {
                seleccion = " ";
            }
            System.out.println(i + ":" + seleccion + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    static void cambiarLineaActiva() {
        System.out.print("Número de línea (0-9): ");
        int nueva = scanner.nextInt();
        scanner.nextLine();

        if (nueva >= 0 && nueva < MAX_LINEAS) {
            lineaActual = nueva;
        }
    }

    static void editarLineaActiva() {
        System.out.print("Nuevo contenido: ");
        lineas[lineaActual] = scanner.nextLine();
    }

    static void borrarLineaActiva() {
        lineas[lineaActual] = "";

    }

    static void intercambiarLineas() {
        System.out.println("Numero de la linea que quiere intercabiar(0-9)");
        int linea1 = scanner.nextInt();
        System.out.println("Numero de la linea que quiere intercabiar(0-9)");
        int linea2 = scanner.nextInt();
        scanner.nextLine();
        if (linea1 >= 0 && linea1 < MAX_LINEAS && linea2 >= 0 && linea2 < MAX_LINEAS) {
            String contenidolinea1 = lineas[linea1];
            lineas[linea1] = lineas[linea2];
            lineas[linea2] = contenidolinea1;

        }

    }

}
