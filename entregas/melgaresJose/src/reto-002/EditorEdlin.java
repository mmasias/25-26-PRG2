import java.util.Scanner;

class EditorEdlin {
    public static void main(String[] args) {
        final int BUFFER_SIZE = 10;
        final int LINEA_ACTIVA_INICIAL = 1;
        
        String[] buffer = new String[BUFFER_SIZE];
        int lineaActiva = LINEA_ACTIVA_INICIAL;
        
        int opcion;
        boolean editorEstaActivo = true;
        iniciarPrograma(buffer, lineaActiva);
        
        do {
            opcion = leerComando();
            editorEstaActivo = opcion != 4;
            if(editorEstaActivo) {
                lineaActiva = ejecutarComando(opcion, buffer, lineaActiva);
                imprimirEditor(buffer, lineaActiva);
            }
            else
                salir();
        } while (editorEstaActivo);
    }

    private static void iniciarPrograma(String[] buffer, int lineaActiva) {
        imprimirMenuIncial(lineaActiva);
        inicializarBuffer(buffer);
    }

    private static void imprimirEditor(String[] buffer, int lineaActiva) {
        limpiarPantalla();
        imprimirBorde();
        for (int i = 0; i < buffer.length; i++) {
            System.out.print(i);
            System.out.print(i == lineaActiva ? "*" : " ");
            System.out.print("| " + buffer[i]);
            System.out.println();
        }
        imprimirBorde();
        imprimirBarraOpciones();
    }

    private static void inicializarBuffer(String[] buffer) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = "~";
        }
    }

    private static void imprimirMenuIncial(int lineaActiva) {
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
        imprimirEditor(bufferMenu, lineaActiva);
    }

    private static void imprimirBarraOpciones() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    private static int leerComando() {
        Scanner scanner = new Scanner(System.in);
        String comando = scanner.nextLine();
        int numeroComando = mapearComando(comando);
        return numeroComando;
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

    private static int ejecutarComando(int opcion, String[] buffer, int lineaActiva) {
        switch (opcion) {
            case 0 -> lineaActiva = cambiarLineaActiva();
            case 1 -> lineaActiva = editarTextoLinea(buffer, lineaActiva);
            case 2 -> intercambiarLineas(buffer);
            case 3 -> inicializarBuffer(buffer);
            case 4 -> salir();
            default -> System.out.println("Opcion Invalida!");
        }
        return lineaActiva;
    }

    private static int cambiarLineaActiva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuál debería de ser la nueva línea activa? (0-9): ");
        int nuevaLineaActiva = scanner.nextInt();
        return nuevaLineaActiva;
    }

    private static int editarTextoLinea(String[] buffer, int lineaActiva) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Texto en línea [" + lineaActiva + "]: ");
        buffer[lineaActiva] = scanner.nextLine();
        return lineaActiva + 1;
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
