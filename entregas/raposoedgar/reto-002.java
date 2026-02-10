import java.util.Scanner;
import java.util.Stack;

public class Edlin {

    static String[] lineas = new String[10];
    static int lineaActiva = 0;
    static Stack<String[]> historial = new Stack<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        inicializar();
        boolean salir = false;

        while (!salir) {
            mostrarPantalla();
            System.out.print("Comando: ");
            String comando = sc.nextLine().toUpperCase();

            switch (comando) {
                case "L":
                    definirLineaActiva();
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
                case "D":
                    deshacer();
                    break;
                case "S":
                    salir = true;
                    break;
                default:
                    System.out.println("Comando no válido");
            }
        }
        System.out.println("Saliendo de EDLIN...");
    }

    static void inicializar() {
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[D] deshace la última acción realizada";
        lineas[8] = "[S] sale del programa";
    }

    static void mostrarPantalla() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", i, marca, lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L] [E] [I] [B] [D] [S]");
    }

    static void guardarEstado() {
        String[] copia = new String[10];
        System.arraycopy(lineas, 0, copia, 0, 10);
        historial.push(copia);
    }

    static void definirLineaActiva() {
        System.out.print("Número de línea (0-9): ");
        int n = Integer.parseInt(sc.nextLine());
        if (n >= 0 && n < 10) {
            lineaActiva = n;
        }
    }

    static void editarLinea() {
        guardarEstado();
        System.out.print("Nuevo contenido: ");
        lineas[lineaActiva] = sc.nextLine();
    }

    static void borrarLinea() {
        guardarEstado();
        lineas[lineaActiva] = "";
    }

    static void intercambiarLineas() {
        System.out.print("Primera línea: ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Segunda línea: ");
        int b = Integer.parseInt(sc.nextLine());

        if (a >= 0 && a < 10 && b >= 0 && b < 10) {
            guardarEstado();
            String temp = lineas[a];
            lineas[a] = lineas[b];
            lineas[b] = temp;
        }
    }

    static void deshacer() {
        if (!historial.isEmpty()) {
            lineas = historial.pop();
        } else {
            System.out.println("Nada que deshacer");
        }
    }
}
