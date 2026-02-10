import java.util.Scanner;

public class EditorEdlin {
    static String[] lines = new String[10];
    static int activeLine = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            lines[i] = "";
        }
        
        lines[0] = "Bienvenidos al editor EDLIN";
        lines[1] = "Utilice el menu inferior para editar el texto";

        while (true) {
            render();
            System.out.print("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir\n> ");
            String command = sc.nextLine().toUpperCase();

            if (command.equals("S")) {
                System.out.println("Saliendo del editor...");
                break;
            }
            
            switch (command) {
                case "L":
                    System.out.print("Número de línea (0-9): ");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        if (index >= 0 && index < 10) {
                            activeLine = index;
                        } else {
                            System.out.println("Error: Fuera de rango.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Ingrese un número válido.");
                    }
                    break;

                case "E":
                    System.out.print("Nuevo texto para línea " + activeLine + ": ");
                    lines[activeLine] = sc.nextLine();
                    break;
            }
            
        }
    }

    static void render() {
        for (int i = 0; i < 15; i++) System.out.println();
        
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < lines.length; i++) {
            String marker = (i == activeLine) ? "*" : " ";
            System.out.printf("%d:%s| %s\n", i, marker, lines[i]);
        }
        System.out.println("--------------------------------------------------");
    }
}