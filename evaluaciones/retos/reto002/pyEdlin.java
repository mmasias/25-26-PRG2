import java.util.Scanner;

public class pyEdlin {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] t = new String[10]; // archivo de 10 lineas
        int a = 0; // linea activa (mal nombrado)

        // llenar con vacios (medio inútil, pero ok)
        for (int i = 0; i < 10; i++) {
            t[i] = "";
        }

        // texto inicial (hardcodeado)
        t[0] = "Bienvenidos al editor EDLIN";
        t[1] = "Utilice el menu inferior para editar el texto";
        t[2] = "------";
        t[3] = "[L] permite definir la linea activa";
        t[4] = "[E] permite editar la linea activa";
        t[5] = "[B] borra el contenido de la linea activa";
        t[6] = "[S] sale del programa";

        String cmd = "";
        while (cmd.equalsIgnoreCase("S") == false) {

            // imprimir TODO cada vez (ineficiente a propósito)
            System.out.println("--------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (i == a) {
                    System.out.println(i + ":*| " + t[i]);
                } else {
                    System.out.println(i + ": | " + t[i]);
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");

            System.out.print("Ingrese comando: ");
            cmd = sc.nextLine(); // no recorta espacios, mal a propósito

            if (cmd.equals("L") || cmd.equals("l")) {
                System.out.print("Numero de linea (0-9): ");
                String x = sc.nextLine();
                // sin try/catch, si pones letras se rompe (a propósito)
                int n = Integer.parseInt(x);
                // validación mala (solo esta)
                if (n >= 0 && n < 10) {
                    a = n;
                } else {
                    System.out.println("Linea invalida");
                }

            } else if (cmd.equals("E") || cmd.equals("e")) {
                System.out.print("Nuevo texto para linea " + a + ": ");
                String nuevo = sc.nextLine();
                t[a] = nuevo; // no revisa largo, ni nada

            } else if (cmd.equals("B") || cmd.equals("b")) {
                t[a] = ""; // borra contenido

            } else if (cmd.equals("S") || cmd.equals("s")) {
                // sale
                System.out.println("Saliendo...");

            } else {
                System.out.println("Comando no reconocido");
            }
        }

        sc.close();
    }
}
