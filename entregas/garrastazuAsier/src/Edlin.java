import java.util.Scanner;

public class Edlin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] lineas = new String[10];
        int activa = 0;

        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        while (true) {

            System.out.println("\nArchivo:");
            for (int i = 0; i < 10; i++) {
                if (i == activa)
                    System.out.println("> " + (i + 1) + ": " + lineas[i]);
                else
                    System.out.println("  " + (i + 1) + ": " + lineas[i]);
            }

            System.out.println("\n1 Seleccionar línea");
            System.out.println("2 Editar");
            System.out.println("0 Salir");

            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) activa = sc.nextInt() - 1;
            if (op == 2) lineas[activa] = sc.nextLine();
            if (op == 0) break;
        }
    }
}
