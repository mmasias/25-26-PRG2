import java.util.Scanner;

public class GestorTareas {
    static final int MAXIMO_TAREAS = 10;
    static final int OPCION_ANADIR = 1;
    static final int OPCION_MARCAR = 2;
    static final int OPCION_VER_PENDIENTES = 3;
    static final int OPCION_ESTADISTICAS = 4;
    static final int OPCION_SALIR = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tareas = new String[MAXIMO_TAREAS];
        boolean[] completadas = new boolean[MAXIMO_TAREAS];
        int cantidadTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        
            imprimirMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == OPCION_ANADIR) {
                cantidadTareas = anadirTarea(scanner, tareas, completadas, cantidadTareas);
            }
            
            marcarTareaComoCompletada(opcion, scanner, tareas, completadas, cantidadTareas);
            
            verTareasPendientes(opcion, tareas, completadas, cantidadTareas);
            
            if (opcion == OPCION_ESTADISTICAS) {
                System.out.println("Estadisticas");
                int contCompletadas = 0;
                for (int indiceTarea = 0; indiceTarea < cantidadTareas; indiceTarea++) {
                    if (completadas[indiceTarea]) {
                        contCompletadas++;
                    }
                }
                System.out.println("Total de tareas: " + cantidadTareas);
                System.out.println("Tareas completadas: " + contCompletadas);
                System.out.println("Tareas pendientes: " + (cantidadTareas - contCompletadas));
                if (cantidadTareas > 0) {
                    double porcentaje = (contCompletadas * 100.0) / cantidadTareas;
                    System.out.println("Porcentaje de completacion: " + porcentaje + "%");
                }
            } 
            
            if (opcion == OPCION_SALIR) {
                System.out.println("Saliendo del gestor de tareas.");
            } else {
                System.out.println("Opcion no valida. Intente de nuevo.");
            }
        
        scanner.close();
    }

   static void imprimirMenu() {
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");
    }

    static int anadirTarea(Scanner scanner, String[] tareas, boolean[] completadas, int cantidadTareas) {
        if (cantidadTareas < MAXIMO_TAREAS) {
            System.out.print("Descripcion de la nueva tarea: ");
            String d = scanner.nextLine();
            tareas[cantidadTareas] = d;
            completadas[cantidadTareas] = false;
            cantidadTareas++;
            System.out.println("Tarea anadida correctamente.");
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
        }
        return cantidadTareas;
    }

    static void marcarTareaComoCompletada (int opcion ,Scanner scanner, String[] tareas, boolean [] completadas, int cantidadTareas) {
        if (opcion == OPCION_MARCAR) {
                System.out.println("Tareas para Marcar");
                for (int indiceTarea = 0; indiceTarea < cantidadTareas; indiceTarea++) {
                    System.out.println((indiceTarea + 1) + ". " + tareas[indiceTarea] + " [" + (completadas[indiceTarea] ? "Completada" : "Pendiente") + "]");
                }
                if (cantidadTareas > 0) {
                    System.out.print("Numero de tarea a marcar como completada: ");
                    int numeroTareaSeleccionada = scanner.nextInt();
                    if (numeroTareaSeleccionada >= 1 && numeroTareaSeleccionada <= cantidadTareas) {
                        if (!completadas[numeroTareaSeleccionada - 1]) {
                            completadas[numeroTareaSeleccionada - 1] = true;
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
    }

    static void verTareasPendientes (int opcion, String[] tareas, boolean [] completadas, int cantidadTareas) {
        if (opcion == OPCION_VER_PENDIENTES) {
                System.out.println("Tareas Pendientes");
                boolean hayTareasPendientes = false;
                for (int indiceTarea = 0; indiceTarea < cantidadTareas; indiceTarea++) {
                    if (!completadas[indiceTarea]) {
                        System.out.println((indiceTarea + 1) + ". " + tareas[indiceTarea]);
                        hayTareasPendientes = true;
                    }
                }
                if (!hayTareasPendientes) {
                    System.out.println("(No hay tareas pendientes)");
                }
            }
    }


}