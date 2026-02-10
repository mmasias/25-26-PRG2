import java.util.Scanner;

public class PyEdlin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String [] lineas = new String [10];
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[D] deshace la última acción realizada";
        lineas[8] = "[S] sale del programa";
        lineas[9] = "";
        
        int lineaActiva = 1;
        boolean usuarioActivo = true;
        String comando;

        do {
            mostrarFichero(lineas, lineaActiva);
            comando = scanner.nextLine();
            
            switch (comando) {
                case "L" -> lineaActiva = cambiarLineaActiva(scanner);
                case "E" -> editarLineaActiva(scanner, lineas, lineaActiva);
                case "I" -> intercambiarLineas(scanner, lineas);
                case "B" -> borrarLinea(lineas, lineaActiva);
                case "S" -> usuarioActivo = false;
                default  -> System.out.println("Comando no reconocido");
            }
        } while (usuarioActivo);

        scanner.close();
    }

    static void mostrarFichero(String[] lineas, int lineaActiva) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            String asterisco = (i == lineaActiva) ? "*" : " ";
            String contenido = (lineas[i] != null) ? lineas[i] : "";
            System.out.println(i + ":" + asterisco + "| " + contenido);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
        System.out.print("Elija una opción: ");
    }
    
    static int cambiarLineaActiva(Scanner scanner) {
        System.out.print("Ingrese número de línea (0-9): ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    static void editarLineaActiva(Scanner scanner, String[] lineas, int lineaActiva) {
        System.out.print("Nuevo contenido: ");
        String nuevoTexto = scanner.nextLine();
        lineas[lineaActiva] = nuevoTexto;
    }

    static void borrarLinea(String[] lineas, int lineaActiva) {
        lineas[lineaActiva] = "";
    }

    static void intercambiarLineas(Scanner scanner, String[] lineas) {
        System.out.print("Primera línea: ");
        int lineaInicial = scanner.nextInt();
        System.out.print("Segunda línea: ");
        int lineaAIntercambiar = scanner.nextInt();
        scanner.nextLine();
        
        String temporal = lineas[lineaInicial];
        lineas[lineaInicial] = lineas[lineaAIntercambiar];
        lineas[lineaAIntercambiar] = temporal;
    }
}
