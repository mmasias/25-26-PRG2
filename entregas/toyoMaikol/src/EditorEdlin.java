import java.util.Scanner;

public class EditorEdlin {

    private static String[] lineas = new String[10];
    private static int lineaActiva = 0; 

    public static void main(String[] args) {
    
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        mostrarEditor();
    }

    public static void mostrarEditor() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < lineas.length; i++) {
            String marcador = (i == lineaActiva) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", i, marcador, lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }
}