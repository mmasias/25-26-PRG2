import java.util.Scanner;
import java.util.Stack;

public class PyEdlin {

    public static void mostrarLineas(String[] lineas, int activa) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < lineas.length; i++) {
            String marca = (i == activa) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineas = new String[10];
        for (int i = 0; i < lineas.length; i++) lineas[i] = "";

        int lineaActiva = 0;

        Stack<String[]> historial = new Stack<>();

        while (true) {

            mostrarLineas(lineas, lineaActiva);
            System.out.print("Comando: ");
            String cmd = sc.nextLine().toUpperCase();

            if (cmd.equals("S")) break;

            if (cmd.equals("L")) {
                System.out.print("Nueva linea (0-9): ");
                int nueva = Integer.parseInt(sc.nextLine());
                if (nueva >= 0 && nueva < 10) {
                    lineaActiva = nueva;
                }
            }

            else if (cmd.equals("E")) {
                historial.push(lineas.clone());
                System.out.print("Nuevo texto: ");
                lineas[lineaActiva] = sc.nextLine();
            }

            
            else if (cmd.equals("B")) {
                historial.push(lineas.clone());
                lineas[lineaActiva] = "";
            }

            
            else if (cmd.equals("I")) {
                historial.push(lineas.clone());
                System.out.print("Linea 1: ");
                int l1 = Integer.parseInt(sc.nextLine());
                System.out.print("Linea 2: ");
                int l2 = Integer.parseInt(sc.nextLine());

                if (l1 >= 0 && l1 < 10 && l2 >= 0 && l2 < 10) {
                    String temp = lineas[l1];
                    lineas[l1] = lineas[l2];
                    lineas[l2] = temp;
                }
            }

        
            else if (cmd.equals("D")) {
                if (!historial.isEmpty()) {
                    lineas = historial.pop();
                } else {
                    System.out.println("Nada que deshacer.");
                }
            }
        }

        sc.close();
        System.out.println("Saliendo de pyEdlin...");
    }
}