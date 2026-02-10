import java.util.*;

public class PyEdlin {

    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineas = new String[MAX_LINEAS];
        Arrays.fill(lineas, "");

        String[] copia = new String[MAX_LINEAS];

        int lineaActiva = 0;
        boolean salir = false;

        while (salir == false) {
            mostrar(lineas, lineaActiva);

            System.out.println("L cambiar | E editar | B borrar | I intercambiar | D deshacer | S salir");
            String cmd = sc.nextLine();

            if (cmd.equalsIgnoreCase("L")) {
                System.out.print("Numero de linea: ");
                lineaActiva = Integer.parseInt(sc.nextLine());
            }

            if (cmd.equalsIgnoreCase("E")) {
                copia = Arrays.copyOf(lineas, lineas.length);
                System.out.print("Nuevo texto: ");
                lineas[lineaActiva] = sc.nextLine();
            }

            if (cmd.equalsIgnoreCase("B")) {
                copia = Arrays.copyOf(lineas, lineas.length);
                lineas[lineaActiva] = "";
            }

            if (cmd.equalsIgnoreCase("I")) {
                copia = Arrays.copyOf(lineas, lineas.length);

                System.out.print("Linea 1: ");
                int a = Integer.parseInt(sc.nextLine());
                System.out.print("Linea 2: ");
                int b = Integer.parseInt(sc.nextLine());

                String temp = lineas[a];
                lineas[a] = lineas[b];
                lineas[b] = temp;
            }

            if (cmd.equalsIgnoreCase("D")) {
                lineas = Arrays.copyOf(copia, copia.length);
            }

            if (cmd.equalsIgnoreCase("S")) {
                salir = true;
            }
        }
    }

    static void mostrar(String[] lineas, int activa) {
        System.out.println("------ EDLIN ------");
        for (int i = 0; i < lineas.length; i++) {
            if (i == activa)
                System.out.println(i + ":*| " + lineas[i]);
            else
                System.out.println(i + ": | " + lineas[i]);
        }
    }
}







