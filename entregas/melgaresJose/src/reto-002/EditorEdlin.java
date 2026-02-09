import java.util.Scanner;

class EditorEdlin {
    public static void main(String[] args) {
        int opcion = 0;
        imprimirMenuIncial();
        String[] buffer = new String[10];
        limpiarBuffer(buffer);
        int lineaActiva = 3;
        while (opcion != 4) {
            opcion = leerComando();
            ejecutarComando(opcion, buffer, lineaActiva);
            imprimirEditor(buffer, lineaActiva);
            imprimirBarraOpciones();
        }
    }

    private static void imprimirEditor(String[] buffer, int lineaActiva) {
        imprimirBorde();
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(i);
            System.out.print(i == lineaActiva ? "*" : " ");
            System.out.print("| " + buffer[i]);
            System.out.println();
        }
        imprimirBorde();
    }

    private static void limpiarBuffer(String[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = "~";
        }
    }

    private static void imprimirMenuIncial() {
        String[] bufferMenu = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[S] sale del programa",
                "",
                "No lea esto por favor"
        };
        imprimirEditor(bufferMenu, 0);
    }

    private static void imprimirBarraOpciones() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    private static int leerComando() {
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();
        return mapearComando(comando);
    }

    private static int mapearComando(String comando) {
        String[] comandosValidos = { "L", "E", "I", "B", "S" };
        final int OPCION_INVALIDA = -1;

        for (int i = 0; i < comandosValidos.length; i++) {
            if (comando.equalsIgnoreCase(comandosValidos[i]))
                return i;
        }
        return OPCION_INVALIDA;
    }

    private static void ejecutarComando(int opcion, String[] buffer, int lineaActiva) {
        switch (opcion) {
            case 0 -> lineaActiva = cambiarLineaActiva();
            case 1 -> editarLineaActiva(buffer, lineaActiva);
            case 2 -> intercambiarLineas(buffer);
            case 3 -> limpiarBuffer(buffer);
            case 4 -> salir();
        }
    }

    private static int cambiarLineaActiva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuál debería de ser la nueva línea activa? (0-9): ");
        int nuevaLinea = scanner.nextInt();
        scanner.close();
        return nuevaLinea;
    }

    private static void editarLineaActiva(String[] buffer, int lineaActiva) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Texto en línea [" + lineaActiva + "]");
        buffer[lineaActiva] = scanner.nextLine();
        scanner.close();
    }

    private static void intercambiarLineas(String[] buffer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intercambiar linea (0-9): ");
        int lineaA = scanner.nextInt();
        System.out.println("Intercambiar con linea (0-9): ");
        int lineaB = scanner.nextInt();

        String auxiliar = buffer[lineaA];
        buffer[lineaA] = buffer[lineaB];
        buffer[lineaB] = auxiliar;
        scanner.close(); 
    }

    private static void salir() {
        System.out.println("Bye Bye :D");
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void imprimirBorde() {
        System.out.println("--------------------------------------------------");
    }
}
