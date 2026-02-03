import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int numTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        while (true) {
            System.out.println("[1] Anadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("ERROR: Debe introducir un numero.");
                sc.nextLine();
                continue;
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 2) {
                if (numTareas == 0) {
                    System.out.println("No hay tareas para marcar.");
                    continue;
                }

                for (int i = 0; i < numTareas; i++) {
                    System.out.println((i + 1) + ". " + tareas[i] + " [" +
                            (completadas[i] ? "Completada" : "Pendiente") + "]");
                }
            }

            if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                break;
            }
        }
        sc.close();
    }
}
