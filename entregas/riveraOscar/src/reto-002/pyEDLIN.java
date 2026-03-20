package src;

import java.util.Scanner;


public class pyEDLIN {
    public static void main(String[] args) {
        int[] lineaActiva = {0};
        String[] lineas = {
            "Bienvenidos al editor EDLIN",
            "Utilice el menu inferior para editar el texto",
            "------",
            "[L] permite definir la línea activa",
            "[E] permite editar la linea activa",
            "[I] permite intercambiar dos lineas",
            "[B] borra el contenido de la linea activa",
            "[D] deshace la última acción realizada",
            "[S] sale del programa",
            ""
        };
        Scanner sc = new Scanner(System.in);

        ImprimirEnConsola(lineaActiva, lineas);
        String eleccionUsuario = sc.nextLine();
        switch (eleccionUsuario) {
            case "L":
                ModificarLineaActiva(lineaActiva, sc);
                ImprimirEnConsola(lineaActiva, lineas);
                break;
            case "E":
                editarLinea(lineaActiva, lineas, sc);
                ImprimirEnConsola(lineaActiva, lineas);
                break;
            default:
                System.out.println("No es una opción valida");
                break;
        }
    }

    private static void ImprimirEnConsola(int[] lineaActiva, String[] lineas) {
        System.out.println("--------------------------------------------------");
        int i = 0;
        do {
        System.out.println(i + ":" + (i == lineaActiva[0] ? "*" : " ") + "| " + lineas[i]);
        i = i + 1;
        } while (i < 10);
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }
    private static void ModificarLineaActiva(int[] lineaActiva, Scanner sc) {
        System.out.println("Seleccione la nueva linea activa:");
        int nuevaLineaActiva = sc.nextInt();
        if (nuevaLineaActiva <= 9 && nuevaLineaActiva >= 0){
            lineaActiva[0] = nuevaLineaActiva;
        }
        System.out.println("La nueva línea activa es: " + lineaActiva);
    }
    private static void editarLinea(int[] lineaActiva, String[] lineas, Scanner sc) {
        System.out.println("Modifique el texto: ");
        lineas[lineaActiva[0]] = sc.nextLine();
        System.out.println("Texto modificado");
    }
}