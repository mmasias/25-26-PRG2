import java.util.Scanner;

public class Edlin {
    private String[] lineas = new String[10];
    private int lineaActiva = 1;

    public Edlin() {
        lineas[0] = "Bienvenidos al editor EDLIN";
        lineas[1] = "Utilice el menu inferior para editar el texto";
        lineas[2] = "------";
        lineas[3] = "[L] permite definir la linea activa";
        lineas[4] = "[E] permite editar la linea activa";
        lineas[5] = "[I] permite intercambiar dos lineas";
        lineas[6] = "[B] borra el contenido de la linea activa";
        lineas[7] = "[S] sale del programa";
        lineas[8] = "";
        lineas[9] = "";
    }

    public void mostrar() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            String marca = (i + 1 == lineaActiva) ? "*" : " ";
            System.out.println(i + ": " + marca + "| " + lineas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    public void setLineaActiva(int n) {
        if (n >= 1 && n <= 10) lineaActiva = n;
    }

    public void editarLineaActiva(String texto) {
        lineas[lineaActiva - 1] = texto;
    }

    public void eliminarLineaActiva() {
        lineas[lineaActiva - 1] = "";
    }

    public void intercambiar(int a, int b) {
        if (a >= 1 && a <= 10 && b >= 1 && b <= 10) {
            String tmp = lineas[a - 1];
            lineas[a - 1] = lineas[b - 1];
            lineas[b - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Edlin e = new Edlin();
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