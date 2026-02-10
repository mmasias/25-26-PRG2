import java.util.Scanner;

class PyEdlin {

    public static void main(String[] args) {

        String[] documento = obtenerDocumentoInicial();
        String[] backup = documento.clone();
        int lineaActiva = 1;
        boolean ejecutar = true;

        do {
            imprimirInterfaz(documento, lineaActiva);
            String comando = solicitarComando();

            if (comando.equals("S")) {
                ejecutar = false;
            } else if (comando.equals("D")) {
                documento = deshacerAccion(backup);
            } else {
                backup = documento.clone();
                if (comando.equals("L")) {
                    lineaActiva = seleccionarLinea();
                } else if (comando.equals("E")) {
                    editarLinea(documento, lineaActiva);
                } else if (comando.equals("I")) {
                    intercambiarLineas(documento);
                } else if (comando.equals("B")) {
                    borrarLinea(documento, lineaActiva);
                }
            }
        } while (ejecutar);

    }

    static String[] obtenerDocumentoInicial() {
        return new String[] {
            "Bienvenidos al editor EDLIN",
            "Utilice el menu inferior para editar el texto",
            "------",
            "[L] permite definir la linea activa",
            "[E] permite editar la linea activa",
            "[I] permite intercambiar dos lineas",
            "[B] borra el contenido de la linea activa",
            "[D] deshace la última acción realizada",
            "[S] sale del programa",
            " "
        };
    }

    static String solicitarComando() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir\n> ");
        return sc.nextLine().toUpperCase();
    }

    static int seleccionarLinea() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de línea (0-9): ");
        return sc.nextInt();
    }

    static void editarLinea(String[] doc, int indice) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nuevo texto para línea " + indice + ": ");
        doc[indice] = sc.nextLine();
    }

    static void borrarLinea(String[] doc, int indice) {
        doc[indice] = " ";
    }

    static void intercambiarLineas(String[] doc) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Línea origen: ");
        int origen = sc.nextInt();
        System.out.print("Línea destino: ");
        int destino = sc.nextInt();

        String temporal = doc[origen];
        doc[origen] = doc[destino];
        doc[destino] = temporal;
    }

    static String[] deshacerAccion(String[] backup) {
        return backup.clone();
    }

    static void imprimirInterfaz(String[] doc, int activa) {
        cleanScreen();
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < doc.length; i++) {
            String marcador = (i == activa) ? "*|" : " |";
            System.out.println(i + ":" + marcador + " " + doc[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}