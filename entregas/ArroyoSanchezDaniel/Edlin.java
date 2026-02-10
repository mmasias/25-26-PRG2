import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salirPrograma = false;
        int lineaActiva = 0;
        String[] filasEditables = { "", "", "", "", "", "", "", "", "", "" };
        String[] filasAnterior = { "", "", "", "", "", "", "", "", "", "" };
        boolean puedeDeshacer = false;

        do {

            MostrarPantalla(filasEditables, lineaActiva);
            String opcionUsuario;
            int nuevaLinea;
            System.out.println("¿Qué quiere hacer?");
            opcionUsuario = scanner.nextLine().toUpperCase();

            switch (opcionUsuario) {
                case "L":
                    System.out.print("Introduzca número de línea (0-9): ");
                    nuevaLinea = scanner.nextInt();
                    if (nuevaLinea >= 0 && nuevaLinea <= 9) {
                        lineaActiva = nuevaLinea;
                    } else {
                        System.out.println("Línea fuera de rango");
                    }

                    break;

                case "E":
                    System.out.print("Editando línea " + lineaActiva + ". Nuevo texto: ");
                    filasAnterior[lineaActiva] = filasEditables[lineaActiva];
                    puedeDeshacer = true;
                    filasEditables[lineaActiva] = scanner.nextLine();

                    break;

                case "I":
                    System.out.println("¿Qué línea desea intercambiar con la línea " + lineaActiva + "? (0-9)");
                    boolean líneasCambiadas = false;
                    while (!líneasCambiadas) {
                        if (lineaActiva >= 0 && lineaActiva <= 9) {
                            int lineaCambio = scanner.nextInt();
                            String temporal = filasEditables[lineaActiva];
                            filasEditables[lineaActiva] = filasEditables[lineaCambio];

                            filasEditables[lineaCambio] = temporal;
                            filasAnterior[lineaCambio] = filasEditables[lineaActiva];
                            filasAnterior[lineaActiva] = filasEditables[lineaCambio];

                            System.out.println("Cambio realizado");
                            líneasCambiadas = true;
                        } else {
                            System.out.println("Cambio no realizado");
                        }
                    }

                    break;

                case "S":
                    System.out.println("Saliendo del programa");
                    salirPrograma = true;
                    break;

                case "D":
                    if (puedeDeshacer) {
                        for (int i = 0; i < 10; i++) {
                            filasEditables[i] = filasAnterior[i];
                        }
                    }
                    break;

                case "B":
                    filasEditables[lineaActiva] = "";
                    System.out.println("Línea borrada");
                    break;

                default:
                    System.out.println("Comando no reconocido");
                    break;

            }
            System.out.println();
        } while (!salirPrograma);

    }

    static void MostrarPantalla(String[] filasEditables, int lineaActiva) {
        String linea = "--------------------------------------------------";
        System.out.println(linea);
        for (int i = 0; i < 10; i++) {
            if (lineaActiva == i) {
                System.out.println(i + ":*| " + filasEditables[i]);
            } else {
                System.out.println(i + ": | " + filasEditables[i]);
            }
        }
        System.out.println(linea);
        System.out.println("Comandos: [L]inea Activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir ");
        System.out.println();

    }

}