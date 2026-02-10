import java.util.Arrays;

public class pyEdlin {

    static final int MAX_LINEAS = 10;

    public static void main(String[] args) {

        String[] lineas = new String[MAX_LINEAS];
        Arrays.fill(lineas, "");

        mostrar(lineas);
    }

    static void mostrar(String[] lineas) {
        System.out.println("------ EDLIN ------");
        for (int i = 0; i < lineas.length; i++) {
            System.out.println(i + ": | " + lineas[i]);
        }
    }
}
