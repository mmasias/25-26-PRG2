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

        System.out.println("=== Mini EDLIN Java ===");
        System.out.println("p -> print");
        System.out.println("s n -> select line");
        System.out.println("e -> edit line");
        System.out.println("d n -> delete line");
        System.out.println("q -> quit");

        while (true) {
            System.out.print("EDLIN> ");
            String input = sc.nextLine().trim();

            if (input.equals("q")) break;

            if (input.equals("p")) {
                printFile();
            } 
            else if (input.startsWith("s ")) {
                int n = Integer.parseInt(input.split(" ")[1]);
                if (n >= 1 && n <= MAX_LINES) activeLine = n - 1;
            } 
            else if (input.equals("e")) {
                System.out.print("Nuevo texto: ");
                file[activeLine] = sc.nextLine();
            } 
            else if (input.startsWith("d ")) {
                int n = Integer.parseInt(input.split(" ")[1]);
                if (n >= 1 && n <= MAX_LINES) file[n - 1] = "";
            } 
            else {
                System.out.println("Comando desconocido");
            }
        }

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

