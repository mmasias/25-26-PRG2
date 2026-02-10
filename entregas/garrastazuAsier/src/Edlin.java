
import java.util.Scanner;

class Edlin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] lineas = new String[10];

        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        while (true) {

            System.out.println("\nArchivo:");
            for (int i = 0; i < 10; i++) {
                System.out.println((i + 1) + ": " + lineas[i]);
            }

            System.out.println("\nEscribe texto para la línea 1 (0 para salir):");
            String texto = sc.nextLine();

            if (texto.equals("0")) break;

            lineas[0] = texto;
        }
    }
}
