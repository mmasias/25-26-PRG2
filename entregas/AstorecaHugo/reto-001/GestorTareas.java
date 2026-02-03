
import java.util.Scanner;

public class GestorTareas {

    static final int MAX_TAREAS = 10;
    static String[] tareas = new String[MAX_TAREAS];
    static boolean[] completadas = new boolean[MAX_TAREAS];
    static int numTareas = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gestor de Tareas v1.0");

        while (true) {
            System.out.println("[1] Añadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                añadirTarea(scanner);
            } else if (opcion == 2) {
                marcarTarea(scanner);
            } else if (opcion == 3) {
                verPendientes();
            } else if (opcion == 4) {
                verEstadisticas();
            } else if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                break;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    static void añadirTarea(Scanner scanner) {
        if (numTareas < 10) {
            System.out.print("Descripcion de la nueva tarea: ");
            String d = scanner.nextLine();
            tareas[numTareas] = d;
            completadas[numTareas] = false;
            numTareas++;
            System.out.println("Tarea añadida correctamente.");
        } else {
            System.out.println("No se pueden añadir mas tareas.");
        }
    }

    static void marcarTarea(Scanner scanner) {
        if (numTareas == 0) {
            System.out.println("No hay tareas para marcar.");
            return;
        }

        System.out.println("Tareas para Marcar:");
        for (int i = 0; i < numTareas; i++) {
            System.out.println((i + 1) + ". " + tareas[i] + " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
        }

        System.out.print("Número de tarea a marcar como completada: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num < 1 || num > numTareas) {
            System.out.println("Número de tarea inválido.");
        } else if (completadas[num - 1]) {
            System.out.println("Esta tarea ya estaba completada.");
        } else {
            completadas[num - 1] = true;
            System.out.println("Tarea marcada como completada.");
        }
    }

    static void verPendientes() {

        boolean hayPendientes = false;
        System.out.println("Tareas Pendientes:");

        for (int i = 0; i < numTareas; i++) {
            if (!completadas[i]) {
                System.out.println((i + 1) + ". " + tareas[i]);
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("(No hay tareas pendientes)");
        }
    }

    static void verEstadisticas() {
        int contCompletadas = 0;
        for (int i = 0; i < numTareas; i++) {
            if (completadas[i]) {
                contCompletadas++;
            }
        }

        System.out.println("Estadísticas:");
        System.out.println("Total de tareas: " + numTareas);
        System.out.println("Tareas completadas: " + contCompletadas);
        System.out.println("Tareas pendientes: " + (numTareas - contCompletadas));

        if (numTareas > 0) {
            double porc = (contCompletadas * 100.0) / numTareas;
            System.out.println("Porcentaje de completación: " + porc + "%");
        }
    }
}
