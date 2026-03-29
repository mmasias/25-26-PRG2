static final int MAX_LINEAS = 10;
static String[] archivo = new String[MAX_LINEAS];
static int lineaActiva = 0;
static void mostrarArchivo() {
    System.out.println("--------------------------------------------------");
    for (int i = 0; i < MAX_LINEAS; i++) {
        String marca = (i == lineaActiva) ? "*" : " ";
        System.out.println(i + ":" + marca + "| " + archivo[i]);
    }
    System.out.println("--------------------------------------------------");
    System.out.println("Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
}
static void definirLineaActiva(Scanner sc) {
    System.out.print("Ingrese número de línea (0-9): ");
    try {
        int linea = Integer.parseInt(sc.nextLine());
        if (linea >= 0 && linea < MAX_LINEAS) {
            lineaActiva = linea;
        } else {
            System.out.println("Línea fuera de rango");
        }
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida");
    }
}
static void editarLinea(Scanner sc) {
    System.out.print("Nuevo contenido: ");
    archivo[lineaActiva] = sc.nextLine();
}
static void borrarLinea() {
    archivo[lineaActiva] = "";
}
static void intercambiarLineas(Scanner sc) {
    try {
        System.out.print("Primera línea: ");
        int l1 = Integer.parseInt(sc.nextLine());

        System.out.print("Segunda línea: ");
        int l2 = Integer.parseInt(sc.nextLine());

        if (l1 >= 0 && l1 < MAX_LINEAS && l2 >= 0 && l2 < MAX_LINEAS) {
            String temp = archivo[l1];
            archivo[l1] = archivo[l2];
            archivo[l2] = temp;
        } else {
            System.out.println("Líneas fuera de rango");
        }
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida");
    }
}
import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;
    static String[] archivo = new String[MAX_LINEAS];
    static int lineaActiva = 1;

    public static void main(String[] args) {

        // Inicialización del archivo
        archivo[0] = "Bienvenidos al editor EDLIN";
        archivo[1] = "Utilice el menu inferior para editar el texto";
        archivo[2] = "------";
        archivo[3] = "[L] permite definir la linea activa";
        archivo[4] = "[E] permite editar la linea activa";
        archivo[5] = "[I] permite intercambiar dos lineas";
        archivo[6] = "[B] borra el contenido de la linea activa";
        archivo[7] = "[S] sale del programa";
        archivo[8] = "";
        archivo[9] = "";

        Scanner sc = new Scanner(System.in);
        String comando;

        do {
            mostrarArchivo();
            System.out.print("Ingrese comando: ");
            comando = sc.nextLine().toUpperCase();

            switch (comando) {
                case "L":
                    definirLineaActiva(sc);
                    break;
                case "E":
                    editarLinea(sc);
                    break;
                case "B":
                    borrarLinea();
                    break;
                case "I":
                    intercambiarLineas(sc);
                    break;
                case "S":
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Comando no válido");
            }

        } while (!comando.equals("S"));

        sc.close();
    }

    static void mostrarArchivo() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + archivo[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    static void definirLineaActiva(Scanner sc) {
        System.out.print("Ingrese número de línea (0-9): ");
        try {
            int linea = Integer.parseInt(sc.nextLine());
            if (linea >= 0 && linea < MAX_LINEAS) {
                lineaActiva = linea;
            } else {
                System.out.println("Línea fuera de rango");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida");
        }
    }

    static void editarLinea(Scanner sc) {
        System.out.print("Nuevo contenido: ");
        archivo[lineaActiva] = sc.nextLine();
    }

    static void borrarLinea() {
        archivo[lineaActiva] = "";
    }

    static void intercambiarLineas(Scanner sc) {
        try {
            System.out.print("Primera línea: ");
            int l1 = Integer.parseInt(sc.nextLine());

            System.out.print("Segunda línea: ");
            int l2 = Integer.parseInt(sc.nextLine());

            if (l1 >= 0 && l1 < MAX_LINEAS && l2 >= 0 && l2 < MAX_LINEAS) {
                String temp = archivo[l1];
                archivo[l1] = archivo[l2];
                archivo[l2] = temp;
            } else {
                System.out.println("Líneas fuera de rango");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida");
        }
    }
}
