import java.util.Scanner;

public class GestorTareas {
    private static final int MAX_TAREAS = 10;
    private static Scanner sc;
    private static String[] tareas;
    private static boolean[] completadas;
    private static int numTareas;

    //Dividire las funciones para mejorar la legibilidad
    private static void anadirTarea() {
        if (numTareas < MAX_TAREAS) {
            System.out.print("Descripcion de la nueva tarea: ");
            String descripcion = sc.nextLine();
            tareas[numTareas] = descripcion;
            completadas[numTareas] = false;
            numTareas++;
            System.out.println("Tarea anadida correctamente.");
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
        }
    }

    private static void marcarCompletada() {
        System.out.println("Tareas para Marcar");
        for (int i = 0; i < numTareas; i++) {
            System.out.println((i + 1) + ". " + tareas[i] + " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
        }
        if (numTareas > 0) {
            System.out.print("Numero de tarea a marcar como completada: ");
            int num = sc.nextInt();
            if (num >= 1 && num <= numTareas) {
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
    }

    private static void verTareasPendientes() {
        System.out.println("Tareas Pendientes");
        boolean hayPendientes = false;
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

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        tareas = new String[MAX_TAREAS];
        completadas = new boolean[MAX_TAREAS];
        numTareas = 0;

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
                anadirTarea();
            } else if (opcion == 2) {
                marcarCompletada();
            } else if (opcion == 3) {
                verTareasPendientes();
            } else if (opcion == 4) {
                System.out.println("Estadisticas");
                int contCompletadas = 0;
                for (int i = 0; i < numTareas; i++) {
                    if (completadas[i]) {
                        contCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + numTareas);
                System.out.println("Tareas completadas: " + contCompletadas);
                System.out.println("Tareas pendientes: " + (numTareas - contCompletadas));
                if (numTareas > 0) {
                    double porc = (contCompletadas * 100.0) / numTareas;
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