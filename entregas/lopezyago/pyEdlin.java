import java.util.*;

public class PyEdlin {

    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] lineas = new String[MAX_LINEAS];
        Arrays.fill(lineas, "");

        boolean salir = false;

        while (!salir) {
            mostrar(lineas);
            System.out.println("[S] Salir");

            String cmd = sc.nextLine().toUpperCase();
            if (cmd.equals("S")) salir = true;
        }
    }

    static void mostrar(String[] lineas) {
        System.out.println("------ EDLIN ------");
        for (int i = 0; i < lineas.length; i++) {
            System.out.println(i + ": | " + lineas[i]);
        }
    }
}



