import java.util.Scanner;

class reto-002 {

    public static void main(String[] args) {

        String[] documento = crearDocumento();
        int lineaActiva = 0;
        final int COMANDO_SALIR = 0;

        int opcion;
        do {
            imprimirEditor(documento, lineaActiva);
            opcion = solicitarOpcion();
            
            if (opcion == 1) {
                lineaActiva = seleccionarLinea(documento.length);
            } else if (opcion == 2) {
                editarLinea(documento, lineaActiva);
            } else if (opcion == 3) {
                eliminarContenido(documento, lineaActiva);
            }

        } while (opcion != COMANDO_SALIR);

        System.out.println("Cierre de pyEdlin exitoso.");
    }

    static String[] crearDocumento() {
        return new String[] {
            "", "", "", "", "", "", "", "", "", ""
        };
    }

    static int solicitarOpcion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n[1] Seleccionar Línea | [2] Editar | [3] Eliminar | [0] Salir");
        System.out.print("Comando > ");
        return scanner.nextInt();
    }

    static int seleccionarLinea(int totalLineas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Número de línea (0-9): ");
        int seleccion = scanner.nextInt();
        return (seleccion >= 0 && seleccion < totalLineas) ? seleccion : 0;
    }

    static void editarLinea(String[] documento, int indice) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nuevo contenido: ");
        String contenido = scanner.nextLine();
        documento[indice] = contenido;
    }

    static void eliminarContenido(String[] documento, int indice) {
        documento[indice] = "";
    }

    static void imprimirEditor(String[] documento, int activa) {
        limpiarPantalla();
        System.out.println("pyEdlin - Editor de texto");
        System.out.println("-------------------------");
        for (int i = 0; i < documento.length; i++) {
            String marcador = (i == activa) ? " > " : "   ";
            System.out.println(i + marcador + documento[i]);
        }
        System.out.println("-------------------------");
        System.out.println("Línea activa: " + activa);
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}