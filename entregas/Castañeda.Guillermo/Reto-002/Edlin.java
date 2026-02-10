import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;
    static String[] archivo = new String[MAX_LINEAS];
    static int lineaActiva = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i < MAX_LINEAS; i++) {
            archivo[i] = "";
        }

        archivo[0] = "Sea bienvenido al editor EDLIN";
        archivo[1] = "Utilice el menu inferior para editar las líneas de texto";
        archivo[2] = "---------------------------------------------------------";
        archivo[3] = "[L] Definir la linea activa";
        archivo[4] = "[E] Editar la linea activa";
        archivo[5] = "[I] Intercambiar dos lineas";
        archivo[6] = "[B] Borrar el contenido de la linea activa";
        archivo[7] = "[S] Salir del programa";

        boolean salir = false;

        while (!salir) {
            mostrarArchivo();
            System.out.print("Comando: ");
            String comando = sc.nextLine().toUpperCase();

            switch (comando) {
                case "L":
                    definirLineaActiva();
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
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }

    static void mostrarArchivo() {
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + archivo[i]);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Comandos: [L] Línea activa | [E] Editar | [I] Intercambiar | [B] Borrar | [S] Salir");
    }

    static void definirLineaActiva() {
        System.out.print("Numero de linea activa (0-9): ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n >= 0 && n < MAX_LINEAS) {
                lineaActiva = n;
            } else {
                System.out.println("Linea fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
        }
    }

    static void editarLineaActiva() {
        System.out.print("Nuevo contenido de la linea: ");
        archivo[lineaActiva] = sc.nextLine();
    }

    static void borrarLineaActiva() {
        archivo[lineaActiva] = "";
    }

    static void intercambiarLineas() {
        try {
            System.out.print("Primera linea (0-9): ");
            int l1 = Integer.parseInt(sc.nextLine());
            System.out.print("Segunda linea (0-9): ");
            int l2 = Integer.parseInt(sc.nextLine());

            if (l1 >= 0 && l1 < MAX_LINEAS && l2 >= 0 && l2 < MAX_LINEAS) {
                String aux = archivo[l1];
                archivo[l1] = archivo[l2];
                archivo[l2] = aux;
            } else {
                System.out.println("Lineas fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
        }
    }
}

