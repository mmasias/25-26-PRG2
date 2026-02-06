import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;
    static String[] lineas = new String[MAX_LINEAS];
    static int lineaActiva = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        inicializarTexto();

        boolean salir = false;
        while (!salir) {
            mostrarEditor();
            System.out.print("Comando: ");
            String comando = sc.nextLine().trim().toUpperCase();

            switch (comando) {
                case "L":
                    definirLineaActiva();
                    break;
                case "E":
                    editarLinea();
                    break;
                case "I":
                    intercambiarLineas();
                    break;
                case "B":
                    borrarLinea();
                    break;
                case "S":
                    salir = true;
                    System.out.println("Saliendo de EDLIN...");
                    break;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }

    static void inicializarTexto() {
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[S] sale del programa";
        lineas[8] = "";
        lineas[9] = "";
    }

    static void mostrarEditor() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", i, marca, lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    static void definirLineaActiva() {
        System.out.print("Numero de linea (0-9): ");
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

    static void editarLinea() {
        System.out.print("Nuevo contenido: ");
        lineas[lineaActiva] = sc.nextLine();
    }

    static void borrarLinea() {
        lineas[lineaActiva] = "";
    }

    static void intercambiarLineas() {
        try {
            System.out.print("Primera linea (0-9): ");
            int l1 = Integer.parseInt(sc.nextLine());
            System.out.print("Segunda linea (0-9): ");
            int l2 = Integer.parseInt(sc.nextLine());

            if (l1 >= 0 && l1 < MAX_LINEAS && l2 >= 0 && l2 < MAX_LINEAS) {
                String temp = lineas[l1];
                lineas[l1] = lineas[l2];
                lineas[l2] = temp;
            } else {
                System.out.println("Lineas fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida.");
        }
    }
}

