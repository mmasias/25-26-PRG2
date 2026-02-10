import java.util.Scanner;

public class Edlin {

    private static final int MAX_LINES = 10;
    private static String[] file = new String[MAX_LINES];
    private static int activeLine = 0;

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < MAX_LINES; i++) {
            file[i] = "";
        }
        
        file[0] = "Linea 1";
        file[1] = "Linea 2";

        System.out.print("Número de línea a borrar: ");
        int line = sc.nextInt();

        if (line >= 1 && line <= MAX_LINES) {
            file[line - 1] = "";
        }

        printFile();
        sc.close();
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

