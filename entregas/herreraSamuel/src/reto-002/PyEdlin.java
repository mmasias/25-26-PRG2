import java.util.Scanner;

public class PyEdlin {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String[] lineasDeTexto = new String[10];
        String[] historial = new String[10];
        int lineaActiva = 0;

        lineasDeTexto[0] = "Bienvenidos al editor EDLIN";
        lineasDeTexto[1] = "Utilice el menu inferior para editar el texto";
        lineasDeTexto[2] = "------";
        lineasDeTexto[3] = "[L] permite definir la linea activa";
        lineasDeTexto[4] = "[E] permite editar la linea activa";
        lineasDeTexto[5] = "[I] permite intercambiar dos lineas";
        lineasDeTexto[6] = "[B] borra el contenido de la linea activa";
        lineasDeTexto[7] = "[D] deshace la última acción realizada";
        lineasDeTexto[8] = "[S] sale del programa";
        lineasDeTexto[9] = "--------------------------------------------------";

        for (int i = 0; i < 10; i++) {
            historial[i] = lineasDeTexto[i];
        }
        imprimirFichero(lineasDeTexto, lineaActiva);
    }
    public static void imprimirFichero(String[] lineas, int lineaActiva) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < lineas.length; i++) {
            if (i == lineaActiva) {
                System.out.println(i + ":*| " + lineas[i]);
            } else {
                System.out.println(i + ": | " + lineas[i]);
            }
        }
        System.out.println("--------------------------------------------------");
    }

}
