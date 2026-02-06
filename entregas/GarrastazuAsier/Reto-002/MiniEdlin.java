import java.util.Scanner;

public class MiniEdlin {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        String[] a = new String[10];
        int x = 0;
        int o = 0;

        for (int i = 0; i < 10; i++) a[i] = "";

        do {

            System.out.println("1 mostrar");
            System.out.println("2 activa");
            System.out.println("3 editar");
            System.out.println("4 borrar");
            System.out.println("5 salir");

            o = s.nextInt();
            s.nextLine();

            if (o == 1) {

                for (int i = 0; i < 10; i++) {
                    if (i == x)
                        System.out.println(">" + (i + 1) + ":" + a[i]);
                    else
                        System.out.println(" " + (i + 1) + ":" + a[i]);
                }
            }

            else if (o == 2) {

                int n = s.nextInt();
                s.nextLine();

                if (n > 0 && n <= 10)
                    x = n - 1;
            }

            else if (o == 3) {

                a[x] = s.nextLine();
            }

            else if (o == 4) {

                int b = s.nextInt();
                s.nextLine();

                if (b > 0 && b <= 10)
                    a[b - 1] = "";
            }

        } while (o != 5);
    }
}
