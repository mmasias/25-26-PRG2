import java.util.Scanner;

public class pyEdlin {
    public static void main(String[] args) {
        final int MAX_LINEAS = 10;
        String[] lineas = new String[MAX_LINEAS];
        int LineaActiva = 0;
        boolean estaFuncionando = true;
        Scanner scanner = new Scanner(System.in);

        iniciarEditor();

        do {
            mostrarPantalla();
            switch(preguntarOpcion()){
                case 'L', 'l' -> definirLineaActiva(espacioLineas, a);
                case 'E', 'e' -> editarLineaActiva(espacioLineas, lineas);
                case 'B', 'b' -> borrarContenidoLineaActiva(lineas, espacioLineas, a)
                case 'E', 'e' -> estaFuncionando = !estaFuncionando;
                default -> System.out.println("Error!");
            }
        }

        


            


            definirLineaActiva();
            editarLineaActiva();
            borrarContenidoLineaActiva();



        scanner.close();
    }

    static void mostrarPantalla(String[] lineas, int lineaActiva){
        limpiarPantalla();
        System.out.println("--------------------------------------------------");
            for (int i = 0; i < MAX_LINEAS; i++) {
                if (i == lineaActiva) {
                    System.out.println(i + ":*| " + lineas[i]);
                } else {
                    System.out.println(i + ": | " + lineas[i]);
                }
            }
    }

    static void iniciarEditor(String[] lineas) {
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[B] borra el contenido de la linea activa";
        lineas[6] = "[S] sale del programa";
    }

    static void definirLineaActiva() {
        Scanner scanner = new Scanner(System.in);
        if (cmd.equals("L") || cmd.equals("l")) {
                System.out.print("Numero de linea (0-9): ");
                String x = scanner.nextLine();
                int n = Integer.parseInt(x);
                if (n >= 0 && n < 10) {
                    a = n;
                } else {
                    System.out.println("Linea invalida");
                }

            }
    }

    static void editarLineaActiva(String cmd, String[] lineas, int a) {
        Scanner scanner = new Scanner(System.in);
        if (cmd.equals("E") || cmd.equals("e")) {
                System.out.print("Nuevo texto para linea " + a + ": ");
                String nuevo = scanner.nextLine();
                lineas[a] = nuevo; 

            }
    }

    static void borrarContenidoLineaActiva(String[] lineas, String cmd, int a) {
        if (cmd.equals("B") || cmd.equals("b")) {
                lineas[a] = ""; 

            }
    }

    static char preguntarOpcion(String cmd){
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------------------------------------------");
            System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");

            System.out.print("Ingrese comando: ");
            cmd = scanner.nextLine();   

            if(entrada.length() > 0){
                return entrada.charAt(0);
            }
            return ' ';
    }

    static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
