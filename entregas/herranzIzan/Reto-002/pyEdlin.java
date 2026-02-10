import java.util.Scanner;

public class Edlin {

    private static final int MAX_LINES = 10;
    private static String[] file = new String[MAX_LINES];

    public static void main(String[] args) {
        // Inicializar líneas
        for (int i = 0; i < MAX_LINES; i++) {
            file[i] = "";
        }

        System.out.println("EDLIN iniciado");
    }
}

