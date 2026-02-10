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
         System.out.print("Texto para línea activa: ");
        String text = sc.nextLine();
        file[activeLine] = text;

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

