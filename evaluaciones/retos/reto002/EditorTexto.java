package evaluaciones.retos.reto002;

import java.util.Scanner;

public class EditorTexto {

    static String[] fichero;
    static int lineaActiva = 0;
    static Scanner teclado = new Scanner(System.in);
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

    public static void editarLinea() {
        System.out.print("Introduce el contenido de la nueva linea: ");
        
        teclado.nextLine();
        String nuevoContenido = teclado.nextLine();
    
        fichero[lineaActiva] = nuevoContenido;
    }
    
    public void definirLineaActiva() {
        System.out.print("Introduce la linea activa (1-10): ");
        int linea = teclado.nextInt();
    
        if (linea >= 1 && linea <= 10) {
            lineaActiva = linea - 1;
        } else {
            System.out.println("Error: la linea debe estar entre 1 y 10");
        }
    }
    

    public static void intercambiarLinea(){

    }

    public static void elimiarLinea(){

    }

    
}
