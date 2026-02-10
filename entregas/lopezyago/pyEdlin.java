import java.util.*;

public class PyEdlin {

    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineas = new String[MAX_LINEAS];
        Arrays.fill(lineas, "");

        int lineaActiva = 0;
        boolean salir = false;

        while (!salir) {
            mostrar(lineas, lineaActiva);
            System.out.println("[L] Linea | [S] Salir");

            String cmd = sc.nextLine().toUpperCase();

            if (cmd.equals("L")) {
                System.out.print("Numero linea: ");
                lineaActiva = Integer.parseInt(sc.nextLine());
            }

            if (cmd.equals("S")) salir = true;
        }
    }

    static void mostrar(String[] lineas, int activa) {
        System.out.println("------ EDLIN ------");
        for (int i = 0; i < lineas.length; i++) {
            String marca = (i == activa) ? "*" : " ";
            System.out.println(i + ":" + marca + "| " + lineas[i]);
        }
    }
}




