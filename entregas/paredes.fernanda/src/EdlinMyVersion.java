import java.util.Arrays;
import java.util.Scanner;

class PyEdlin {

    static String[] lines = new String[10];
    static String[] previousLines = null;
    static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {
        Arrays.fill(lines, "");
        boolean running = true;

        while (running) {
            showEditor();
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "E" -> editLine();
                case "B" -> clearLine();
                case "I" -> swapLines();
                case "D" -> undo();
                case "S" -> running = false;
                default -> System.out.println("Comando no válido");
            }
        }
    }
    static void showEditor() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": | " + lines[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
        System.out.print("> ");
    }

    static void saveState() {
        previousLines = Arrays.copyOf(lines, lines.length);
    }

    static void editLine() {
        System.out.print("Linea a editar (0-9): ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index >= 0 && index < 10) {
            saveState();
            System.out.print("Nuevo texto: ");
            lines[index] = scanner.nextLine();
        }
    }

    static void clearLine() {
        System.out.print("Linea a borrar (0-9): ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index >= 0 && index < 10) {
            saveState();
            lines[index] = "";
        }
    }

    static void swapLines() {
        System.out.print("Primera linea (0-9): ");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.print("Segunda linea (0-9): ");
        int second = Integer.parseInt(scanner.nextLine());

        if (first >= 0 && first < 10 && second >= 0 && second < 10) {
            saveState();
            String temp = lines[first];
            lines[first] = lines[second];
            lines[second] = temp;
        }
    }

    static void undo() {
        if (previousLines != null) {
            lines = Arrays.copyOf(previousLines, previousLines.length);
            previousLines = null;
        }
    }
}