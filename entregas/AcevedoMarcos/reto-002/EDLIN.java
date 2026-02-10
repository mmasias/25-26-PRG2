import java.util.Scanner;


public class EDLIN {

private static final int MAX_LINEAS = 10;
private static String[] lineas = new String[MAX_LINEAS];
private static int lineaActiva = 0;
private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Editor iniciado");
         inicializarTexto();
        boolean salir = false;

        while (!salir) {
            mostrarFichero();
            System.out.print("Comando: ");
            String comando = scanner.nextLine().toUpperCase();

            switch (comando) {
                case "L":
                    cambiarLineaActiva();
                    break;
                case "E":
                    editarLinea();
                    break;
                case "B":
                    borrarLinea();
                    break;
                case "I":
                    intercambiarLineas();
                    break;
                case "S":
                    salir = true;
                    System.out.println("Saliendo del editor...");
                    break;
            }
        }
    }

    private static void inicializarTexto() {
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
private static void mostrarFichero() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marca;
            if (i == lineaActiva) {
                marca = "*";
            } else {
                marca = " ";
            }
            System.out.println(i + ":" + marca + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");

    }
     private static void cambiarLineaActiva() {
        System.out.print("Número de línea (0-9): ");
        int nueva = scanner.nextInt();
        scanner.nextLine(); 

        if (nueva >= 0 && nueva < MAX_LINEAS) {
            lineaActiva = nueva;
        }
    }

    private static void editarLinea() {
        System.out.print("Nuevo contenido: ");
        lineas[lineaActiva] = scanner.nextLine();
    }

    private static void borrarLinea() {
        lineas[lineaActiva] = "";
    }

    private static void intercambiarLineas() {

        System.out.print("Primera línea: ");
        int l1 = scanner.nextInt();

        System.out.print("Segunda línea: ");
        int l2 = scanner.nextInt();
        scanner.nextLine(); 

        if (l1 >= 0 && l1 < MAX_LINEAS && l2 >= 0 && l2 < MAX_LINEAS) {
            String temp = lineas[l1];
            lineas[l1] = lineas[l2];
            lineas[l2] = temp;
        }
    }
}

    

