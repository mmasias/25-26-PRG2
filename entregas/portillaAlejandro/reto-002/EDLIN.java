import java.util.Scanner;

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


