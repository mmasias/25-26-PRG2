import java.util.Scanner;

public class pyEdlin {

    private static final int MAX_LINEAS = 10;
    private static final int MAX_HISTORIAL = 20;

    public static void main(String[] args) {

        String[] lineas = new String[MAX_LINEAS];
        int lineaActiva = 1;

        String[][] historialLineas = new String[MAX_HISTORIAL][MAX_LINEAS];
        int[] historialLineaActiva = new int[MAX_HISTORIAL];
        int tamanoHistorial = 0;

        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[D] deshace la ultima accion realizada";
        lineas[8] = "[S] sale del programa";

        Scanner lector = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {

            mostrarPantalla(lineas, lineaActiva);
            System.out.print("Comando: ");
            String opcion = lector.nextLine().trim().toUpperCase();

            if (opcion.isEmpty()) {
                continue;
            }

            switch (opcion) {

                case "L":
                    lineaActiva = elegirLinea(lector, "Linea activa (0-9): ");

                case "S":
                    ejecutando = false;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        lector.close();
    }

    private static void mostrarPantalla(String[] lineas, int lineaActiva) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String marcador = (i == lineaActiva) ? "*|" : " |";
            String contenido = (lineas[i] == null) ? "" : lineas[i];
            System.out.println(i + ":" + marcador + " " + contenido);
        }
        System.out.println("--------------------------------------------------");
        System.out.println(
                "Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir"
        );
    }

    private static int elegirLinea(Scanner lector, String mensaje) {
        int numeroLinea = -1;

        while (numeroLinea < 0 || numeroLinea >= MAX_LINEAS) {
            System.out.print(mensaje);
            String entrada = lector.nextLine().trim();
            try {
                numeroLinea = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                numeroLinea = -1;
            }
        }
        return numeroLinea;
    }

   
    
}
