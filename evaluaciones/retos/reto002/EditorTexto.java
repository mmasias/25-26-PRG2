package evaluaciones.retos.reto002;

import java.util.Scanner;

public class EditorTexto {

    String[] fichero;
    int lineaActiva = 0;
    Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        editor.fichero = new String[10];

        editor.imprimirFichero();
        editor.mostrarMenu();
    }

    public void imprimirFichero() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < fichero.length; i++) {
            String contenido = (fichero[i] == null) ? "" : fichero[i];
            if (i == lineaActiva) {
                System.out.println(i + ":*| " + contenido);
            } else {
                System.out.println(i + ": | " + contenido);
            }
        }
        System.out.println("--------------------------------------------------");
    }

    public void mostrarMenu() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    public static void editarLinea(){
        System.out.println("ingrece el contenido de la nueva linea: \n");
    }

    public static void cambiar
}
