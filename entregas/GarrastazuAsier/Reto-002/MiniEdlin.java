import java.util.Scanner;

public class MiniEdlin {

    static String[] texto = new String[10];
    static int lineaActiva = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) texto[i] = "";

        int opcion;

        do {
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) mostrar();
            else if (opcion == 2) cambiar(sc);
            else if (opcion == 3) editar(sc);
            else if (opcion == 4) borrar(sc);

        } while (opcion != 5);
    }

    static void menu() {
        System.out.println("1 mostrar");
        System.out.println("2 activa");
        System.out.println("3 editar");
        System.out.println("4 borrar");
        System.out.println("5 salir");
    }

    static void mostrar() {
        for (int i = 0; i < 10; i++) {
            if (i == lineaActiva)
                System.out.println(">" + (i + 1) + ":" + texto[i]);
            else
                System.out.println(" " + (i + 1) + ":" + texto[i]);
        }
    }

    static void cambiar(Scanner sc) {
        int n = sc.nextInt();
        sc.nextLine();

        if (n > 0 && n <= 10)
            lineaActiva = n - 1;
    }

    static void editar(Scanner sc) {
        texto[lineaActiva] = sc.nextLine();
    }

    static void borrar(Scanner sc) {
        int n = sc.nextInt();
        sc.nextLine();

        if (n > 0 && n <= 10)
            texto[n - 1] = "";
    }
}