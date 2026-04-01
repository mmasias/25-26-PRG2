import java.util.Scanner;

public class MiniEdlin {

    static final int MAX = 10;
    static String[] texto = new String[MAX];
    static int lineaActiva = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < MAX; i++)
            texto[i] = "";

        int opcion = 0;
        String entrada;

        do {

            menu();
            entrada = sc.nextLine();

            if (esNumero(entrada))
                opcion = Integer.parseInt(entrada);
            else
                opcion = 0;

            if (opcion == 1)
                mostrar();
            else if (opcion == 2)
                cambiar(sc);
            else if (opcion == 3)
                editar(sc);
            else if (opcion == 4)
                borrar(sc);
            else if (opcion == 5)
                System.out.println("Saliendo...");
            else
                System.out.println("Opción inválida");

        } while (opcion != 5);

        sc.close();
    }

    static void menu() {
        System.out.println("\n1 Mostrar");
        System.out.println("2 Cambiar línea activa");
        System.out.println("3 Editar línea activa");
        System.out.println("4 Borrar línea");
        System.out.println("5 Salir");
        System.out.print("Opción: ");
    }

    static void mostrar() {

        System.out.println("\nContenido:");

        for (int i = 0; i < MAX; i++) {
            String marca = (i == lineaActiva) ? ">" : " ";
            System.out.println(marca + (i + 1) + ": " + texto[i]);
        }
    }

    static void cambiar(Scanner sc) {

        System.out.print("Nueva línea activa: ");
        String entrada = sc.nextLine();

        if (esNumero(entrada)) {
            int n = Integer.parseInt(entrada);

            if (n >= 1 && n <= MAX)
                lineaActiva = n - 1;
            else
                System.out.println("Fuera de rango");
        } else {
            System.out.println("Entrada inválida");
        }
    }

    static void editar(Scanner sc) {

        System.out.print("Nuevo contenido: ");
        texto[lineaActiva] = sc.nextLine();
    }

    static void borrar(Scanner sc) {

        System.out.print("Línea a borrar: ");
        String entrada = sc.nextLine();

        if (esNumero(entrada)) {
            int n = Integer.parseInt(entrada);

            if (n >= 1 && n <= MAX)
                texto[n - 1] = "";
            else
                System.out.println("Fuera de rango");
        } else {
            System.out.println("Entrada inválida");
        }
    }

    static boolean esNumero(String s) {

        if (s.length() == 0)
            return false;

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }

        return true;
    }
}