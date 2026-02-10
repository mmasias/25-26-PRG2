import java.util.Scanner;

public class main {
    
    private static final int MAX_LINEAS = 10;
    private static String[] lineas = new String[MAX_LINEAS];
    private static int lineaActiva = 1;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inicializarLineas();
        
        boolean salir = false;
        while (!salir) {
            mostrarEditor();
            System.out.print("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir\n> ");
            
            String comando = sc.nextLine().toUpperCase();
            
            switch (comando) {
                case "L":
                    cambiarLineaActiva(sc);
                    break;
                case "E":
                    editarLinea(sc);
                    break;
                case "I":
                    intercambiarLineas(sc);
                    break;
                case "B":
                    borrarLinea();
                    break;
                case "S":
                    salir = true;
                    System.out.println("Saliendo del editor EDLIN...");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intente de nuevo.");
            }
        }
        
        sc.close();
    }
    
    private static void inicializarLineas() {
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[S] sale del programa";
        lineas[8] = "";
        lineas[9] = "";
    }
    
    private static void mostrarEditor() {
        System.out.println("\n--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marcador = (i == lineaActiva) ? "*" : " ";
            System.out.printf("%d:%s| %s\n", i, marcador, lineas[i]);
        }
        System.out.println("--------------------------------------------------");
    }
    
    private static void cambiarLineaActiva(Scanner sc) {
        System.out.print("Ingrese el numero de linea (0-9): ");
        try {
            int nuevaLinea = Integer.parseInt(sc.nextLine());
            if (nuevaLinea >= 0 && nuevaLinea < MAX_LINEAS) {
                lineaActiva = nuevaLinea;
                System.out.println("Linea activa cambiada a: " + lineaActiva);
            } else {
                System.out.println("Numero de linea invalido. Debe ser entre 0 y 9.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero.");
        }
    }
    
    private static void editarLinea(Scanner sc) {
        System.out.println("Linea actual [" + lineaActiva + "]: " + lineas[lineaActiva]);
        System.out.print("Nuevo contenido: ");
        String nuevoContenido = sc.nextLine();
        lineas[lineaActiva] = nuevoContenido;
        System.out.println("Linea editada correctamente.");
    }
    
    private static void borrarLinea() {
        lineas[lineaActiva] = "";
        System.out.println("Contenido de la linea " + lineaActiva + " borrado.");
    }
    
    private static void intercambiarLineas(Scanner sc) {
        System.out.print("Ingrese la primera linea (0-9): ");
        try {
            int linea1 = Integer.parseInt(sc.nextLine());
            if (linea1 < 0 || linea1 >= MAX_LINEAS) {
                System.out.println("Numero de linea invalido. Debe ser entre 0 y 9.");
                return;
            }
            
            System.out.print("Ingrese la segunda linea (0-9): ");
            int linea2 = Integer.parseInt(sc.nextLine());
            if (linea2 < 0 || linea2 >= MAX_LINEAS) {
                System.out.println("Numero de linea invalido. Debe ser entre 0 y 9.");
                return;
            }

            String temp = lineas[linea1];
            lineas[linea1] = lineas[linea2];
            lineas[linea2] = temp;
            
            System.out.println("Lineas " + linea1 + " y " + linea2 + " intercambiadas correctamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida. Ingrese un numero.");
        }
    }
}
