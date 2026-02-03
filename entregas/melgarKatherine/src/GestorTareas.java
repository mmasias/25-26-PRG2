import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int NUMTAREAS = 0;

        System.out.println("Gestor de Tareas v1.0");

        while (true) {
            System.out.println("[1] Anadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (NUMTAREAS < 10) {
                    System.out.print("Descripcion de la nueva tarea: ");
                    String d = sc.nextLine();
                    tareas[NUMTAREAS] = d;
                    completadas[NUMTAREAS] = false;
                    NUMTAREAS++;
                    System.out.println("Tarea anadida correctamente.");
                } else {
                    System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
                }
            } else if (opcion == 2) {
                System.out.println("Tareas para Marcar");
                for (int i = 0; i < NUMTAREAS; i++) {
                    System.out.println((i + 1) + ". " + tareas[i] + " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
                }
                if (NUMTAREAS > 0) {
                    System.out.print("Numero de tarea a marcar como completada: ");
                    int num = sc.nextInt();
                    if (num >= 1 && num <= NUMTAREAS) {
                        if (!completadas[num - 1]) {
                            completadas[num - 1] = true;
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Esta tarea ya estaba completada.");
                        }
                    } else {
                        System.out.println("Numero de tarea invalido.");
                    }
                } else {
                    System.out.println("No hay tareas para marcar.");
                }
            } else if (opcion == 3) {
                System.out.println("Tareas Pendientes");
                boolean hayPendientes = false;
                for (int i = 0; i < NUMTAREAS; i++) {
                    if (!completadas[i]) {
                        System.out.println((i + 1) + ". " + tareas[i]);
                        hayPendientes = true;
                    }
                }
                if (!hayPendientes) {
                    System.out.println("(No hay tareas pendientes)");
                }
            } else if (opcion == 4) {
                System.out.println("Estadisticas");
                int contCompletadas = 0;
                for (int i = 0; i < NUMTAREAS; i++) {
                    if (completadas[i]) {
                        contCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + NUMTAREAS);
                System.out.println("Tareas completadas: " + contCompletadas);
                System.out.println("Tareas pendientes: " + (NUMTAREAS - contCompletadas));
                if (NUMTAREAS > 0) {
                    double porc = (contCompletadas * 100.0) / NUMTAREAS;
                    System.out.println("Porcentaje de completacion: " + porc + "%");
                }
            } else if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                break;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
