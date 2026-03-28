import java.util.Scanner;

public class Reto002 {

    static final int MAX = 10;
    static String[] texto = new String[MAX];
    static int activa = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 0; i < MAX; i++) {
            texto[i] = "";
        }

        texto[0] = "Bienvenidos al editor EDLIN";
        texto[1] = "Utilice el menu inferior para editar el texto";
        texto[2] = "------";
        texto[3] = "[L] Define la linea seleccionada";
        texto[4] = "[E] Edita la linea seleccionada";
        texto[5] = "[I] Intercambiar dos lineas";
        texto[6] = "[B] Elimina la linea seleccionada";
        texto[7] = "[S] Salir del app";

        boolean fin = false;

        while (!fin) {
            mostrar();
            System.out.print("Comando: ");
            String cmd = sc.nextLine().toUpperCase();

            switch (cmd) {
                case "L":
                    Defina();
                    break;
                case "E":
                    edita();
                    break;
                case "B":
                    elimina();
                    break;
                case "I":
                    intercambiar();
                    break;
                case "S":
                    fin = true;
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Comando incorrecto");
            }
        }
    }

    static void mostrar() {
        System.out.println("----------------------------------------");
        for (int i = 0; i < MAX; i++) {
            if (i == activa) {
                System.out.println(i + ":*| " + texto[i]);
            } else {
                System.out.println(i + ": | " + texto[i]);
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("[L] [E] [I] [B] [S]");
    }

    static void cambiarLinea() {
        System.out.print("Linea (0-9): ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n >= 0 && n < MAX) {
                activa = n;
            }
        } catch (NumberFormatException e) {
            System.out.println("Dato no valido");
        }
    }

    static void editar() {
        System.out.print("Texto nuevo: ");
        texto[activa] = sc.nextLine();
    }

    static void borrar() {
        texto[activa] = "";
    }

    static void intercambiar() {
        try {
            System.out.print("Linea 1: ");
            int a = Integer.parseInt(sc.nextLine());
            System.out.print("Linea 2: ");
            int b = Integer.parseInt(sc.nextLine());

            if (a >= 0 && a < MAX && b >= 0 && b < MAX) {
                String tmp = texto[a];
                texto[a] = texto[b];
                texto[b] = tmp;
            }
        } catch (NumberFormatException e) {
            System.out.println("Dato no valido");
        }
    }
}
