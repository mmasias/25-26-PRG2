import java.util.Scanner;

public class EditorEdlin {

    private static final int MAX_LINEAS = 10;
    private static String[] lineas = new String[MAX_LINEAS];
    private static int lineaActiva = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarTexto();

        boolean salir = false;

        while (!salir) {
            mostrarPantalla();
            System.out.print("Comando (L, E, B, S): ");
            String comando = sc.nextLine();

            if (comando.equals("L")) {
                definirLineaActiva(sc);

            } else if (comando.equals("E")) {
                editarLinea(sc);

            } else if (comando.equals("B")) {
                borrarLinea();

            } else if (comando.equals("S")) {
                salir = true;

            } else {
                System.out.println("Comando no válido");
            }
        }

        sc.close();
    }

    private static void inicializarTexto() {
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[B] borra el contenido de la linea activa";
        lineas[6] = "[S] sale del programa";
        for (int i = 7; i < MAX_LINEAS; i++) {
            lineas[i] = "";
        }
    }

    private static void mostrarPantalla() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");
    }

    private static void definirLineaActiva(Scanner sc) {
        System.out.print("Número de línea (0-9): ");
        int linea = sc.nextInt();
        sc.nextLine(); 

        if (linea >= 0 && linea < MAX_LINEAS) {
            lineaActiva = linea;
        } else {
            System.out.println("Línea fuera de rango");
        }
    }

    private static void editarLinea(Scanner sc) {
        System.out.print("Nuevo contenido: ");
        lineas[lineaActiva] = sc.nextLine();
    }

    private static void borrarLinea() {
        lineas[lineaActiva] = "";
    }
}
