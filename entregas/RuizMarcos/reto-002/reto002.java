import java.util.Scanner;

public class MiniEdlin {

    private static final int MAX_LINEAS = 10;
    private final String[] lineas = new String[MAX_LINEAS];
    private int lineaActiva = 0; // valores 0–9

    public static void main(String[] args) {
        new MiniEdlin().ejecutar();
    }

    private void ejecutar() {
        Scanner sc = new Scanner(System.in);
        boolean activo = true;

        while (activo) {
            System.out.print("edlin> ");
            String entrada = sc.nextLine().trim();

            if (entrada.equalsIgnoreCase("q")) {
                activo = false;

            } else if (entrada.equalsIgnoreCase("p")) {
                mostrarFichero();

            } else if (entrada.startsWith("l")) {
                cambiarLineaActiva(entrada);

            } else if (entrada.equalsIgnoreCase("e")) {
                editarLinea(sc);

            } else if (entrada.equalsIgnoreCase("d")) {
                borrarLinea();

            } else {
                System.out.println("Comandos disponibles:");
                System.out.println("  p  -> mostrar fichero");
                System.out.println("  lN -> seleccionar línea N (ej: l3)");
                System.out.println("  e  -> editar línea activa");
                System.out.println("  d  -> borrar línea activa");
                System.out.println("  q  -> salir");
            }
        }
    }

    private void mostrarFichero() {
        System.out.println("----- CONTENIDO DEL FICHERO -----");
        for (int i = 0; i < MAX_LINEAS; i++) {
            String indicador = (i == lineaActiva) ? ">" : " ";
            String contenido = (lineas[i] == null) ? "" : lineas[i];
            System.out.printf("%s %2d: %s%n", indicador, i + 1, contenido);
        }
        System.out.println("---------------------------------");
    }

    private void cambiarLineaActiva(String comando) {
        try {
            int numero = Integer.parseInt(comando.substring(1)) - 1;
            if (numero >= 0 && numero < MAX_LINEAS) {
                lineaActiva = numero;
            } else {
                System.out.println("Número de línea fuera de rango (1–10).");
            }
        } catch (Exception e) {
            System.out.println("Uso correcto: lN  (ejemplo: l5 para seleccionar la línea 5)");
        }
    }

    private void editarLinea(Scanner sc) {
        System.out.print("Nuevo contenido para la línea " + (lineaActiva + 1) + ": ");
        lineas[lineaActiva] = sc.nextLine();
    }

    private void borrarLinea() {
        lineas[lineaActiva] = null;
    }
}
