import java.util.Scanner;

public class PyEdlin {
    
    private static final int MAX_LINES = 10;
    private String[] lines = new String[MAX_LINES];
    private int activeLine = 0;
git commit -g "Inicialización de líneas vacías en el constructor"
    public PyEdlin() {
        for (int i = 0; i < MAX_LINES; i++) {
            lines[i] = "";
        }
    }
git commit -g "Método para imprimir el contenido del archivo con indicador de línea activa"
    public void printFile() {
        System.out.println("\n--- FICHERO ---");
        for (int i = 0; i < MAX_LINES; i++) {
            String marker = (i == activeLine) ? ">" : " ";
            System.out.printf("%s %2d: %s%n", marker, i + 1, lines[i]);
        }
    }
git commit -g "Métodos para navegar entre líneas, editar y eliminar contenido"
    public void nextLine() {
        if (activeLine < MAX_LINES - 1) {
            activeLine++;
        }
    }
git commit -g "Método para moverse a la línea anterior"
    public void previousLine() {
        if (activeLine > 0) {
            activeLine--;
        }
    }

    public void editLine(Scanner scanner) {
        System.out.print("Nuevo contenido: ");
        lines[activeLine] = scanner.nextLine();
    }
git commit -g "Método para eliminar el contenido de la línea activa"
    public void deleteLine() {
        lines[activeLine] = "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PyEdlin editor = new PyEdlin();
        boolean running = true;
git commit -g "Bucle principal para manejar comandos del usuario"
        while (running) {
            editor.printFile();
            System.out.print("\nComando (p/n/b/e/d/q): ");
            String command = scanner.nextLine().toLowerCase();
git commit -g "Manejo de comandos para navegar, editar, eliminar y salir"
            switch (command) {
                case "p":
                    break;
                case "n":
                    editor.nextLine();
                    break;
                case "b":
                    editor.previousLine();
                    break;
                case "e":
                    editor.editLine(scanner);
                    break;
                case "d":
                    editor.deleteLine();
                    break;
                case "q":
                    running = false;
                    break;
                default:
                    System.out.println("Comando no válido");
            }
        }
git commit -g "Cierre del scanner y mensaje de salida"
        scanner.close();
        System.out.println("Saliendo de pyEdlin...");
    }
}
git commit -g "Finalización de la implementación básica de pyEdlin en Java"
