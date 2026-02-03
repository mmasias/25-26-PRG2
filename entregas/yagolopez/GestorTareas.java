import java.util.Scanner;

public class GestorTareas {

    static final int MAX_TAREAS = 10;

    static void mostrarMenu() {
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");
    }

    static int leerOpcion(Scanner sc) {
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    static int anadirTarea(Scanner sc, String[] tareas, boolean[] completadas, int numTareas) {
        if (numTareas < MAX_TAREAS) {
            System.out.print("Descripcion de la nueva tarea: ");
            tareas[numTareas] = sc.nextLine();
            completadas[numTareas] = false;
            System.out.println("Tarea anadida correctamente.");
            return numTareas + 1;
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
            return numTareas;
        }
    }

    static void marcarTarea(Scanner sc, String[] tareas, boolean[] completadas, int numTareas) {
        if (numTareas == 0) {
            System.out.println("No hay tareas para marcar.");
            return;
        }

        for (int i = 0; i < numTareas; i++) {
            System.out.println((i + 1) + ". " + tareas[i] +
                    " [" + (completadas[i] ? "Completada" : "Pendiente") + "]");
        }

        System.out.print("Numero de tarea: ");
        int num = sc.nextInt();

        if (num >= 1 && num <= numTareas) {
            if (!completadas[num - 1]) {
                completadas[num - 1] = true;
                System.out.println("Tarea marcada como completada.");
            } else {
                System.out.println("Esta tarea ya estaba completada.");
            }
        } else {
            System.out.println("Numero invalido.");
        }
    }

    static void mostrarPendientes(String[] tareas, boolean[] completadas, int numTareas) {
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

    static void mostrarEstadisticas(boolean[] completadas, int numTareas) {
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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tareas = new String[MAX_TAREAS];
        boolean[] completadas = new boolean[MAX_TAREAS];
        int numTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerOpcion(sc);

            if (opcion == 1) {
                numTareas = anadirTarea(sc, tareas, completadas, numTareas);
            } else if (opcion == 2) {
                marcarTarea(sc, tareas, completadas, numTareas);
            } else if (opcion == 3) {
                System.out.println("Tareas Pendientes");
                mostrarPendientes(tareas, completadas, numTareas);
            } else if (opcion == 4) {
                System.out.println("Estadisticas");
                mostrarEstadisticas(completadas, numTareas);
            } else if (opcion == 5) {
                System.out.println("Saliendo del gestor de tareas.");
                salir = true;
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        sc.close();
    }
}


