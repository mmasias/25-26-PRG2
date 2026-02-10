import java.util.Scanner;

class Edlin {

    static String[] archivo = new String[10];
    static int lineaActiva = 0;
    static Scanner sc = new Scanner(System.in);

    static void ejecutar() {
        for (int i = 0; i < 10; i++) archivo[i] = "";
        while (true) {
            mostrarArchivo();
            mostrarMenu();

            System.out.print("\nEscribe el comando: ");
            String comando = sc.nextLine();

            if (comando.equalsIgnoreCase("seleccionarLinea")) {
                seleccionarLinea();
            } else if (comando.equalsIgnoreCase("editarLinea")) {
                editarLinea();
            } else if (comando.equalsIgnoreCase("borrarLinea")) {
                borrarLinea();
            } else if (comando.equalsIgnoreCase("intercambiarLineas")) {
                intercambiarLineas();
            } else if (comando.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Comando inválido. Intenta de nuevo.");
            }
        }
    }

    static void mostrarArchivo() {
        System.out.println("\nArchivo:");
        for (int i = 0; i < 10; i++) {
            if (i == lineaActiva)
                System.out.println("> " + (i + 1) + ": " + archivo[i]);
            else
                System.out.println("  " + (i + 1) + ": " + archivo[i]);
        }
    }

    static void mostrarMenu() {
        System.out.println("\nComandos disponibles:");
        System.out.println("- seleccionarLinea");
        System.out.println("- editarLinea");
        System.out.println("- borrarLinea");
        System.out.println("- intercambiarLineas");
        System.out.println("- salir");
    }

    static void seleccionarLinea() {
        System.out.print("Número de línea a activar (1-10): ");
        int linea = sc.nextInt() - 1;
        sc.nextLine();
        if (linea >= 0 && linea < 10) lineaActiva = linea;
    }

    static void editarLinea() {
        System.out.print("Texto para la línea activa: ");
        archivo[lineaActiva] = sc.nextLine();
    }

    static void borrarLinea() {
        System.out.print("Número de línea a borrar (1-10): ");
        int linea = sc.nextInt() - 1;
        sc.nextLine();
        if (linea >= 0 && linea < 10) archivo[linea] = "";
    }

    static void intercambiarLineas() {
        System.out.print("Número de la primera línea a intercambiar (1-10): ");
        int linea1 = sc.nextInt() - 1;
        System.out.print("Número de la segunda línea a intercambiar (1-10): ");
        int linea2 = sc.nextInt() - 1;
        sc.nextLine();
        if (linea1 >= 0 && linea1 < 10 && linea2 >= 0 && linea2 < 10) {
            String temp = archivo[linea1];
            archivo[linea1] = archivo[linea2];
            archivo[linea2] = temp;
        }
    }

    public static void main(String[] args) {
        ejecutar();
    }
}
