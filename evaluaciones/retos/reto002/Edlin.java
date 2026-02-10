import java.util.Scanner;

public class Edlin {
    static final int MAX_LINEAS = 10;
    static String[] lineas = new String[MAX_LINEAS];
    static int lineaActiva = 0;
    public static void main(String[] args) {
        boolean estaFuncionando = true;

        iniciarEditor();

        do {
            mostrarPantalla();
            switch(preguntarOpcion()){
                case 'L', 'l' -> definirLineaActiva();
                case 'E', 'e' -> editarLineaActiva();
                case 'I', 'i' -> intercambiarLineas();
                case 'B', 'b' -> borrarContenidoLineaActiva();
                case 'S', 's' -> estaFuncionando = !estaFuncionando;
                default -> System.out.println("Error!");
            }
        } while (estaFuncionando);

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
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[S] sale del programa";
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

    static void intercambiarLineas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese la primera línea a intercambiar (0-9): ");
        int linea1 = scanner.nextInt();
        System.out.print("Ingrese la segunda línea a intercambiar (0-9): ");
        int linea2 = scanner.nextInt();

        scanner.nextLine(); 

        if (linea1 >= 0 && linea1 < MAX_LINEAS && linea2 >= 0 && linea2 < MAX_LINEAS) {
            String temporal = lineas[linea1];
            lineas[linea1] = lineas[linea2];
            lineas[linea2] = temporal;
            System.out.println("Líneas intercambiadas.");
        } else {
            System.out.println("Error: Líneas inválidas. Deben ser entre 0 y 9.");
    } pausa();
    }

    static void borrarContenidoLineaActiva() {
        System.out.println("\nBorrando línea " + lineaActiva + "...");
        lineas[lineaActiva] = "";
        System.out.println("Línea borrada.");
        pausa();
    }

    static char preguntarOpcion(){
        System.out.print("\nIngrese comando: ");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");
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
