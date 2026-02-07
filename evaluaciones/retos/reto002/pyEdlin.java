import java.util.Scanner;

public class pyEdlin {

    

    public static void main(String[] args) {
        final int MAX_LINEAS = 10;
        String[] lineas = new String[MAX_LINEAS];
        int[] contadorDeLineas = {0};
        boolean estaFuncionando = true;
        Scanner scanner = new Scanner(System.in);
        int a = 0; 

        iniciarEditor();

        String cmd = "";
        while (cmd.equalsIgnoreCase("S") == false) {

            System.out.println("--------------------------------------------------");
            for (int i = 0; i < 10; i++) {
                if (i == a) {
                    System.out.println(i + ":*| " + lineas[i]);
                } else {
                    System.out.println(i + ": | " + lineas[i]);
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("Comandos: [L]inea activa | [E]ditar | [B]orrar | [S]alir");

            System.out.print("Ingrese comando: ");
            cmd = scanner.nextLine(); 

            definirLineaActiva();


            if (cmd.equals("B") || cmd.equals("b")) {
                lineas[a] = ""; 

            } else if (cmd.equals("S") || cmd.equals("s")) {
                System.out.println("Saliendo...");

            } else {
                System.out.println("Comando no reconocido");
            }
        }

        scanner.close();
    }

    static void iniciarEditor() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            lineas[i] = "";
        }

        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[B] borra el contenido de la linea activa";
        lineas[6] = "[S] sale del programa";
    }

    static void definirLineaActiva() {
        if (cmd.equals("L") || cmd.equals("l")) {
                System.out.print("Numero de linea (0-9): ");
                String x = scanner.nextLine();
                int n = Integer.parseInt(x);
                if (n >= 0 && n < 10) {
                    a = n;
                } else {
                    System.out.println("Linea invalida");
                }

            }
    }


}
