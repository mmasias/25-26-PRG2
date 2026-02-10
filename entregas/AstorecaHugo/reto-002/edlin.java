
import java.util.Scanner;

class edlin {

    private static final int MAX_LINEAS = 100;
    private static String[] lineas = new String[MAX_LINEAS];
    private static int lineaActual = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            cargarTexto();
            boolean salir = false;
    }

    static void cargarTexto() {
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
}
