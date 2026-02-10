import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;
    static String[] archivo = new String[MAX_LINEAS];
    static int lineaActiva = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i < MAX_LINEAS; i++) {
            archivo[i] = "";
        }

        archivo[0] = "Sea bienvenido al editor EDLIN";
        archivo[1] = "Utilice el menu inferior para editar las líneas de texto";
        archivo[2] = "---------------------------------------------------------";
        archivo[3] = "[L] Definir la linea activa";
        archivo[4] = "[E] Editar la linea activa";
        archivo[5] = "[I] Intercambiar dos lineas";
        archivo[6] = "[B] Borrar el contenido de la linea activa";
        archivo[7] = "[S] Salir del programa";

        boolean salir = false;

        while (!salir) {
            mostrarArchivo();
            System.out.print("Comando: ");
            String comando = sc.nextLine().toUpperCase();

            switch (comando) {
                case "L":
                    definirLineaActiva();
                    break;
                case "E":
                    editarLineaActiva();
                    break;
                case "B":
                    borrarLineaActiva();
                    break;
                case "I":
                    intercambiarLineas();
                    break;
                case "S":
                    salir = true;
                    System.out.println("Saliendo del editor...");
                    break;
                default:
                    System.out.println("Comando no reconocido.");
            }
        }
    }
}