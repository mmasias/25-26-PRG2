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
                case 'L', 'l' -> definirLineaActiva();
                case 'E', 'e' -> editarLineaActiva();
                case 'B', 'b' -> borrarContenidoLineaActiva()
                case 'S', 's' -> estaFuncionando = !estaFuncionando;
                default -> System.out.println("Error!");
            }
        } while (estaFuncionando);

        scanner.close();


            


            definirLineaActiva();
            editarLineaActiva();
            borrarContenidoLineaActiva();




    }

    static void mostrarPantalla(){
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

    static void iniciarEditor() {
        for (int i = 0; i < MAX_LINEAS; i++) {
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
        System.out.print("\n¿Qué línea desea activar? (0-9): ");
        
        try {
            int n = Integer.parseInt(scanner.nextLine());
            
            if (n >= 0 && n < MAX_LINEAS) {
                lineaActiva = n;
                System.out.println("Línea " + lineaActiva + " activada.");
            } else {
                System.out.println("Línea inválida. Debe ser entre 0 y 9.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número.");
        }
        
        pausa();
    }

    static void editarLineaActiva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEditando línea " + lineaActiva);
        System.out.println("Contenido actual: " + lineas[lineaActiva]);
        System.out.print("Nuevo texto: ");
        
        String nuevoTexto = scanner.nextLine();
        lineas[lineaActiva] = nuevoTexto;
        
        System.out.println("Línea actualizada.");
        pausa();
    }

    static void borrarContenidoLineaActiva() {
        System.out.println("\nBorrando línea " + lineaActiva + "...");
        lineas[lineaActiva] = "";
        System.out.println("Línea borrada.");
        pausa();
    }

    static char preguntarOpcion(){
        System.out.print("\nIngrese comando: ");
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        
        if (entrada.length() > 0) {
            return entrada.charAt(0);
        }
        return ' '; 
    }

    static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    static void pausa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}
