import java.util.*;

public class PyEdlin {

    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineas = new String[MAX_LINEAS];
        Arrays.fill(lineas, "");

        int lineaActiva = 0;
        boolean salir = false;

        while (salir == false) {
            mostrar(lineas, lineaActiva);

            System.out.println("L cambiar | E editar | B borrar | S salir");
            String cmd = sc.nextLine();

            if (cmd.equalsIgnoreCase("L")) {
                System.out.print("Numero de linea: ");
                lineaActiva = Integer.parseInt(sc.nextLine());
            }

            if (cmd.equalsIgnoreCase("E")) {
                System.out.print("Nuevo texto: ");
                lineas[lineaActiva] = sc.nextLine();
            }

            if (cmd.equalsIgnoreCase("B")) {
                lineas[lineaActiva] = "";
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





