import java.util.Scanner;

public class Reto002 {
    private final String[] Lineas = new String[10];
    private int lineaActiva = 1;

    public Reto002() {
        Lineas[0] = "Bienvenidos al editor EDLIN";
        Lineas[1] = "Utilice el menu inferior para editar el texto";
        Lineas[2] = "------";
        Lineas[3] = "[L] permite definir la linea activa";
        Lineas[4] = "[E] permite editar la linea activa";
        Lineas[5] = "[I] permite intercambiar dos lineas";
        Lineas[6] = "[B] borra el contenido de la linea activa";
        Lineas[7] = "[S] sale del programa";
        Lineas[8] = "";
        Lineas[9] = "";
    }

    public void mostrar() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            String marca = (i + 1 == lineaActiva) ? "*" : " ";
            System.out.println(i + ": " + marca + "| " + Lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    public void setLineaActiva(int n) {
        if (n >= 1 && n <= 10) lineaActiva = n;
    }

    public void editarLineaActiva(String texto) {
        Lineas[lineaActiva - 1] = texto;
    }

    public void eliminarLineaActiva() {
        Lineas[lineaActiva - 1] = "";
    }

    public void intercambiar(int a, int b) {
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            String tmp = Lineas[a - 1];
            Lineas[a - 1] = Lineas[b - 1];
            Lineas[b - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Reto002 e = new Reto002();
        Scanner sc = new Scanner(System.in);

        while (true) {
            e.mostrar();
            String cmd = sc.nextLine().trim().toUpperCase();

            if (cmd.equals("S")) break;

            if (cmd.equals("L")) {
                int n = Integer.parseInt(sc.nextLine());
                e.setLineaActiva(n);
            } 
            else if (cmd.equals("E")) {
                String texto = sc.nextLine();
                e.editarLineaActiva(texto);
            } 
            else if (cmd.equals("B")) {
                e.eliminarLineaActiva();
            } 
            else if (cmd.equals("I")) {
                int a = Integer.parseInt(sc.nextLine());
                int b = Integer.parseInt(sc.nextLine());
                e.intercambiar(a, b);
            }
        }
    }
}