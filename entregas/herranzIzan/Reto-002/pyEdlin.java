import java.util.Scanner;

public class Edlin {

    private static final int MAX_LINES = 10;
    private static String[] file = new String[MAX_LINES];
    private static int activeLine = 0;

    public static void main(String[] args) {
        // Inicializar líneas
        for (int i = 0; i < MAX_LINES; i++) {
            file[i] = "";
        }

        printFile();
        System.out.println("Línea activa: " + (activeLine + 1));
    }
    
    private static void printFile() {
        System.out.println("----- FICHERO -----");
        for (int i = 0; i < MAX_LINES; i++) {
            String marker = (i == activeLine) ? ">" : " ";
            System.out.println(marker + " " + (i + 1) + ": " + file[i]);
        }
        System.out.println("-------------------");
    }
}

