import java.util.Scanner;

class GestorTarea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX_TAREAS = 10;
        final int ANADIR_TAREA = 1;
        final int MARCAR_COMPLETADA = 2;
        final int VER_PENDIENTES = 3;
        final int VER_ESTADISTICAS = 4;
        final int SALIR = 5;

        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int numTareas = 0;
        int opcion = 0;
        System.out.println("Gestor de Tareas v1.0");
        boolean salio = false;
        while (!salio) {
           opcion= Impresor (sc, opcion);

            if (opcion == ANADIR_TAREA) {
                numTareas = añadidordetareas(sc, tareas, completadas, numTareas, MAX_TAREAS);
            } else if (opcion == MARCAR_COMPLETADA) {
                marcarTareaCompletada(sc, tareas, completadas, numTareas);
            } else if (opcion == VER_PENDIENTES) {
                verTareasPendientes(sc, tareas, completadas, numTareas);
            }
            }  else if (opcion == VER_ESTADISTICAS) {
                verEstadisticas(sc, tareas, completadas, numTareas);
                salio = salir();
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
            sc.close();
        }
        
       static int Impresor(Scanner sc, int opcion) {
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();
        return opcion;

    }
    static int añadidordetareas(Scanner sc, String[] tareas, boolean[] completadas, int numTareas, final int MAX_TAREAS) {
        if (numTareas < MAX_TAREAS) {
            System.out.print("Descripcion de la nueva tarea: ");
            String d = sc.nextLine();
            tareas[numTareas] = d;
            completadas[numTareas] = false;
            numTareas++; 
            System.out.println("Tarea anadida correctamente.");
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
        }
        return numTareas;
    }
    static void marcarTareaCompletada(Scanner sc, String[] tareas, boolean[] completadas, int numTareas) {
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
static void verTareasPendientes(Scanner sc, String[] tareas, boolean[] completadas, int numTareas) {
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
static void verEstadisticas(Scanner sc, String[] tareas, boolean[] completadas, int numTareas) {
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
}
static boolean salir() {
    System.out.println("Saliendo del gestor de tareas.");
    return true;
}
}


