package Entregas.aznarCarlos.Reto001;

import java.util.Scanner;

public class GestorTareasPaso3 {



    static void mostrarMenu() {
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");
    }

    static void mostrarTareas(String[] tareas, boolean[] completadas, int numTareas) {
        for (int i = 0; i < numTareas; i++) {
            System.out.println((i + 1) + ". " + tareas[i] +
                    " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
        }
    }

    public static void main(String[] args) {
        final int MAX_TAREAS = 10;

        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[MAX_TAREAS];
        boolean[] completadas = new boolean[MAX_TAREAS];
        int numTareas = 0;

        System.out.println("Gestor de Tareas v1.3");

        while (true) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (numTareas < MAX_TAREAS) {
                    System.out.print("Descripcion de la nueva tarea: ");
                    tareas[numTareas] = sc.nextLine();
                    completadas[numTareas] = false;
                    numTareas++;
                    System.out.println("Tarea anadida.");
                } else {
                    System.out.println("Limite alcanzado.");
                }

            } else if (opcion == 2) {
                if (numTareas == 0) {
                    System.out.println("No hay tareas.");
                    continue;
                }

                mostrarTareas(tareas, completadas, numTareas);
                System.out.print("Numero de tarea: ");
                int num = sc.nextInt();

                if (num >= 1 && num <= numTareas) {
                    completadas[num - 1] = true;
                    System.out.println("Tarea completada.");
                }

            } else if (opcion == 3) {
                boolean hay = false;
                for (int i = 0; i < numTareas; i++) {
                    if (!completadas[i]) {
                        System.out.println((i + 1) + ". " + tareas[i]);
                        hay = true;
                    }
                }
                if (!hay) {
                    System.out.println("No hay tareas pendientes.");
                }

            } else if (opcion == 4) {
                int completas = 0;
                for (int i = 0; i < numTareas; i++) {
                    if (completadas[i]) completas++;
                }
                System.out.println("Total: " + numTareas);
                System.out.println("Completadas: " + completas);
                System.out.println("Pendientes: " + (numTareas - completas));

            } else if (opcion == 5) {
                System.out.println("Saliendo del programa.");
                break;
            }
        }
        sc.close();
    }
}
