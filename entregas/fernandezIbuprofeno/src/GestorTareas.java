import java.util.Scanner;

class GestorTareas {
    public static void main(String[] args) {
        
        final int AGREGAR_TAREA = 1, COMPLETAR_TAREA = 2, VER_PENDIENTES = 3, VER_ESTADISTICAS = 4, SALIR = 5;
        final int NUMERO_MAXIMO_TAREAS = 10;
        String[] tareas = new String[NUMERO_MAXIMO_TAREAS];
        boolean[] tareasCompletadas = new boolean[NUMERO_MAXIMO_TAREAS];
        int[] contadorDeTareas = { 0 };
        boolean estaFuncionando = true;

        do {
            mostrarMenu();
            switch (preguntarOpcion()) {
                case AGREGAR_TAREA -> agregarTarea(tareas, tareasCompletadas, contadorDeTareas);
                case COMPLETAR_TAREA -> marcarTareaComoCompletada(tareas, tareasCompletadas, contadorDeTareas);
                case VER_PENDIENTES -> verTareasPendientes(tareas, tareasCompletadas, contadorDeTareas);
                case VER_ESTADISTICAS -> verEstadisticas(tareas, tareasCompletadas, contadorDeTareas);
                case SALIR -> estaFuncionando = !estaFuncionando;
                default -> System.out.println("Error!");
            }
        } while (estaFuncionando);
    }

    static void verEstadisticas(String[] tareas, boolean[] tareasCompletadas, int[] contadorDeTareas) {
        System.out.println("Estadisticas");
        int contadorDeTareasCompletadas = 0;
        for (int tarea = 0; tarea < contadorDeTareas[0]; tarea++) {
            if (tareasCompletadas[tarea]) {
                contadorDeTareasCompletadas++;
            }
        }
        System.out.println("Total de tareas: " + contadorDeTareas[0]);
        System.out.println("Tareas completadas: " + contadorDeTareasCompletadas);
        System.out.println("Tareas pendientes: " + (contadorDeTareas[0] - contadorDeTareasCompletadas));
        if (contadorDeTareas[0] > 0) {
            double porcentaje = (contadorDeTareasCompletadas * 100.0) / contadorDeTareas[0];
            System.out.println("Porcentaje de completacion: " + porcentaje + "%");
        }
    }

    static void verTareasPendientes(String[] tareas, boolean[] tareasCompletadas, int[] contadorDeTareas) {
        System.out.println("Tareas Pendientes");
        boolean hayPendientes = false;
        for (int tarea = 0; tarea < contadorDeTareas[0]; tarea++) {
            if (!tareasCompletadas[tarea]) {
                System.out.println((tarea + 1) + ". " + tareas[tarea]);
                hayPendientes = true;
            }
        }
        if (!hayPendientes) {
            System.out.println("(No hay tareas pendientes)");
        }
    }

    static void agregarTarea(String[] tareas, boolean[] tareasCompletadas, int[] contadorDeTareas) {
        Scanner scanner = new Scanner(System.in);
        if (contadorDeTareas[0] < tareas.length) {
            System.out.print("Descripcion de la nueva tarea: ");
            String descripcionDeTarea = scanner.nextLine();
            tareas[contadorDeTareas[0]] = descripcionDeTarea;
            tareasCompletadas[contadorDeTareas[0]] = false;
            contadorDeTareas[0]++;
            System.out.println("Tarea anadida correctamente.");
        } else {
            System.out.println("ERROR: No se pueden anadir mas tareas, limite alcanzado.");
        }
    }

    static void marcarTareaComoCompletada(String[] tareas, boolean[] tareasCompletadas, int[] contadorDeTareas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tareas para Marcar");
        for (int tarea = 0; tarea < contadorDeTareas[0]; tarea++) {
            System.out.println((tarea + 1) + ". " + tareas[tarea] + " [" + (tareasCompletadas[tarea] ? "Completada" : "Pendiente") + "]");
        }
        if (contadorDeTareas[0] > 0) {
            System.out.print("Numero de tarea a marcar como completada: ");
            int numeroDeTarea = scanner.nextInt();
            if (numeroDeTarea >= 1 && numeroDeTarea <= contadorDeTareas[0]) {
                if (!tareasCompletadas[numeroDeTarea - 1]) {
                    tareasCompletadas[numeroDeTarea - 1] = true;
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

    static int preguntarOpcion() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static void mostrarMenu() {
        System.out.println("Gestor de Tareas v1.0");
        System.out.println("--------------------------------");
        System.out.println("[1] Anadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");

    }
}
