import java.util.Scanner;

public class EditorTexto {

    static final int TAM_FICHERO = 10;
    static String[] fichero = new String[TAM_FICHERO];
    static int lineaActiva = 0;
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        boolean salir = false;

        do {
            limpiarConsola();
            imprimirFichero();
            mostrarMenu();
            System.out.print("Elige una opcion: ");

            String opcion = teclado.next().toUpperCase();

            switch (opcion) {
                case "L" -> definirLineaActiva();
                case "E" -> editarLinea();
                case "I" -> intercambiarLinea();
                case "B" -> elimiarLinea();
                case "S" -> {
                    System.out.println("Saliendo del editor...");
                    salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }

        } while (!salir);
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void imprimirFichero() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < fichero.length; i++) {
            String contenido = (fichero[i] == null) ? "" : fichero[i];
            int numeroLineaUsuario = i + 1;

            if (i == lineaActiva) {
                System.out.println(numeroLineaUsuario + ":*| " + contenido);
            } else {
                System.out.println(numeroLineaUsuario + ": | " + contenido);
            }
        }
        System.out.println("--------------------------------------------------");
    }

    public static void mostrarMenu() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    public static void definirLineaActiva() {
        System.out.print("Introduce la linea activa (1-10): ");
        int lineaUsuario = teclado.nextInt();

        if (lineaUsuario >= 1 && lineaUsuario <= TAM_FICHERO) {
            lineaActiva = lineaUsuario - 1;
        } else {
            System.out.println("Error: la linea debe estar entre 1 y 10");
        }
    }

    public static void editarLinea() {
        System.out.print("Introduce el contenido de la nueva linea: ");
        teclado.nextLine();
        String nuevoContenido = teclado.nextLine();
        fichero[lineaActiva] = nuevoContenido;
    }

    public static void intercambiarLinea() {
        System.out.print("Introduce la linea con la que quieres intercambiar (1-10): ");
        int lineaUsuario = teclado.nextInt();

        if (lineaUsuario >= 1 && lineaUsuario <= TAM_FICHERO) {
            int indiceOtra = lineaUsuario - 1;
            String aux = fichero[lineaActiva];
            fichero[lineaActiva] = fichero[indiceOtra];
            fichero[indiceOtra] = aux;
        } else {
            System.out.println("Error: la linea debe estar entre 1 y 10");
        }
    }

    public static void elimiarLinea() {
        fichero[lineaActiva] = null;
    }
}
