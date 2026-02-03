import java.util.Scanner;

public class GestorTareas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tareas = new String[10];
        boolean[] completadas = new boolean[10];
        int numTareas = 0;

        System.out.println("Gestor de Tareas v1.0");

        while (true) {
            System.out.println("\n[1] Anadir tarea");
            System.out.println("[2] Marcar tarea como completada");
            System.out.println("[3] Ver tareas pendientes");
            System.out.println("[4] Ver estadisticas");
            System.out.println("[5] Salir");
            System.out.print("Opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("ERROR: Introduzca un numero valido.");
                sc.nextLine();
                continue;
            }

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    if (numTareas >= 10) {
                        System.out.println("ERROR: Limite de tareas alcanzado.");
                        break;
                    }
                    System.out.print("Descripcion de la nueva tarea: ");
                    tareas[numTareas] = sc.nextLine();
                    completadas[numTareas] = false;
                    numTareas++;
                    System.out.println("Tarea anadida correctamente.");
                    break;

                case 2:
                    if (numTareas == 0) {
                        System.out.println("No hay tareas para marcar.");
                        break;
                    }

                    for (int i = 0; i < numTareas; i++) {
                        System.out.println((i + 1) + ". " + tareas[i] + " [" +
                                (completadas[i] ? "Completada" : "Pendiente") + "]");
                    }

                    System.out.print("Numero de tarea: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("Entrada invalida.");
                        sc.nextLine();
                        break;
                    }

                    int num = sc.nextInt();
                    sc.nextLine();

                    if (num < 1 || num > numTareas) {
                        System.out.println("Numero fuera de rango.");
                        break;
                    }

                    if (completadas[num - 1]) {
                        System.out.println("La tarea ya estaba completada.");
                    } else {
                        completadas[num - 1] = true;
                        System.out.println("Tarea marcada como completada.");
                    }
                    break;

                case 3:
                    boolean hayPendientes = false;
                    for (int i = 0; i < numTareas; i++) {
                        if (!completadas[i]) {
                            System.out.println((i + 1) + ". " + tareas[i]);
                            hayPendientes = true;
                        }
                    }
                    if (!hayPendientes) {
                        System.out.println("No hay tareas pendientes.");
                    }
                    break;

                case 4:
                    int completadasCount = 0;
                    for (int i = 0; i < numTareas; i++) {
                        if (completadas[i]) completadasCount++;
                    }

                    System.out.println("Total: " + numTareas);
                    System.out.println("Completadas: " + completadasCount);
                    System.out.println("Pendientes: " + (numTareas - completadasCount));

                    if (numTareas > 0) {
                        double porcentaje = (completadasCount * 100.0) / numTareas;
                        System.out.printf("Progreso: %.2f%%\n", porcentaje);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del gestor.");
                    sc.close();
                    return;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
