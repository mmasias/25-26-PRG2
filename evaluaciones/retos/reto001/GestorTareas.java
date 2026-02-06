import java.util.Scanner;

public class GestorTareas {

    private static final int MAX_TAREAS = 10;

    private static class Tarea {
        private String descripcion;
        private boolean completada;

        public Tarea(String descripcion) {
            this.descripcion = descripcion;
            this.completada = false;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public boolean isCompletada() {
            return completada;
        }

        public void completar() {
            this.completada = true;
        }
    }

    private Tarea[] tareas;
    private int numTareas;

    public GestorTareas() {
        tareas = new Tarea[MAX_TAREAS];
        numTareas = 0;
    }

    public boolean agregarTarea(String descripcion) {
        if (numTareas >= MAX_TAREAS) {
            return false;
        }
        tareas[numTareas++] = new Tarea(descripcion);
        return true;
    }

    public int contarCompletadas() {
        int contador = 0;
        for (int i = 0; i < numTareas; i++) {
            if (tareas[i].isCompletada()) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        System.out.println("Gestor de Tareas v2.0");

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Descripcion de la nueva tarea: ");
                    String descripcion = sc.nextLine();
                    if (gestor.agregarTarea(descripcion)) {
                        System.out.println("Tarea añadida correctamente.");
                    } else {
                        System.out.println("ERROR: No se pueden añadir más tareas.");
                    }
                    break;

                case 2:
                    marcarTarea(sc, gestor);
                    break;

                case 3:
                    mostrarPendientes(gestor);
                    break;

                case 4:
                    mostrarEstadisticas(gestor);
                    break;

                case 5:
                    System.out.println("Saliendo del gestor de tareas.");
                    salir = true;
                    break;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n[1] Añadir tarea");
        System.out.println("[2] Marcar tarea como completada");
        System.out.println("[3] Ver tareas pendientes");
        System.out.println("[4] Ver estadisticas");
        System.out.println("[5] Salir");
        System.out.print("Opcion: ");
    }

    private static void marcarTarea(Scanner sc, GestorTareas gestor) {

        if (gestor.numTareas == 0) {
            System.out.println("No hay tareas para marcar.");
            return;
        }

        for (int i = 0; i < gestor.numTareas; i++) {
            Tarea t = gestor.tareas[i];
            System.out.println(
                (i + 1) + ". " + t.getDescripcion() +
                " [" + (t.isCompletada() ? "Completada" : "Pendiente") + "]"
            );
        }

        System.out.print("Numero de tarea a marcar como completada: ");
        int num = sc.nextInt();

        if (num < 1 || num > gestor.numTareas) {
            System.out.println("Numero de tarea invalido.");
            return;
        }

        Tarea tarea = gestor.tareas[num - 1];
        if (tarea.isCompletada()) {
            System.out.println("Esta tarea ya estaba completada.");
        } else {
            tarea.completar();
            System.out.println("Tarea marcada como completada.");
        }
    }

    private static void mostrarPendientes(GestorTareas gestor) {

        System.out.println("Tareas Pendientes");
        boolean hayPendientes = false;

        for (int i = 0; i < gestor.numTareas; i++) {
            Tarea t = gestor.tareas[i];
            if (!t.isCompletada()) {
                System.out.println((i + 1) + ". " + t.getDescripcion());
                hayPendientes = true;
            }
        }

        if (!hayPendientes) {
            System.out.println("(No hay tareas pendientes)");
        }
    }

    private static void mostrarEstadisticas(GestorTareas gestor) {

        int total = gestor.numTareas;
        int completadas = gestor.contarCompletadas();

        System.out.println("Estadisticas");
        System.out.println("Total de tareas: " + total);
        System.out.println("Tareas completadas: " + completadas);
        System.out.println("Tareas pendientes: " + (total - completadas));

        if (total > 0) {
            double porcentaje = (completadas * 100.0) / total;
            System.out.println("Porcentaje de completacion: " + porcentaje + "%");
        }
    }
}
