import java.util.Scanner;

public class pyEdlin {
    private static final int MAX_LINEAS = 10;
    private static final int ANCHO_PANTALLA = 50;
    private static String[] lineas = new String[MAX_LINEAS];
    private static int lineaActica = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        iniciarEditor();

    }

    static void iniciarEditor() {
        for (int i = 0; i < MAX_LINEAS; i++) {
            lineas[i] = "";
        }
        
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[B] borra el contenido de la linea activa";
        lineas[6] = "[S] sale del programa";
    }
    



    static void imprimirLinea() {
        for (int i = 0; i < ANCHO_PANTALLA; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    static void limpiarPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
