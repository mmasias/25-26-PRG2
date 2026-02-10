import java.util.Scanner;

public class Edlin {

    static final int MAX_LINEAS = 10;

    static String[] lineas = new String[MAX_LINEAS];
    static String[] backup = new String[MAX_LINEAS];

    static int lineaActiva = 0;
    static boolean hayBackup = false;

    static Scanner sc = new Scanner(System.in);

    static void guardarEstado() {
        for (int i = 0; i < MAX_LINEAS; i++) {
            backup[i] = lineas[i];
        }
        hayBackup = true;
    }

    
    static void mostrar() {
        System.out.println("\n--------------------------------------------------");
        for (int i = 0; i < MAX_LINEAS; i++) {
            if (i == lineaActiva) {
                System.out.println(i + ":*| " + lineas[i]);
            } else {
                System.out.println(i + ": | " + lineas[i]);
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]ínea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    
    static void definirLinea() {
        System.out.print("Ingrese línea activa (0-9): ");
        int n = sc.nextInt();
        sc.nextLine();

        if (n >= 0 && n < MAX_LINEAS) {
            lineaActiva = n;
        } else {
            System.out.println("Línea inválida");
        }
    }

    
    static void editar() {
        guardarEstado();
        System.out.print("Nuevo contenido: ");
        lineas[lineaActiva] = sc.nextLine();
    }

    
    static void borrar() {
        guardarEstado();
        lineas[lineaActiva] = "";
    }

    
    static void intercambiar() {
        System.out.print("Primera línea (0-9): ");
        int a = sc.nextInt();
        System.out.print("Segunda línea (0-9): ");
        int b = sc.nextInt();
        sc.nextLine();

        if (a >= 0 && a < MAX_LINEAS && b >= 0 && b < MAX_LINEAS) {
            guardarEstado();
            String temp = lineas[a];
            lineas[a] = lineas[b];
            lineas[b] = temp;
        } else {
            System.out.println("Líneas inválidas");
        }
    }

    
    static void deshacer() {
        if (hayBackup) {
            for (int i = 0; i < MAX_LINEAS; i++) {
                lineas[i] = backup[i];
            }
            hayBackup = false;
        } else {
            System.out.println("No hay acciones para deshacer");
        }
    }

    public static void main(String[] args) {

        
        for (int i = 0; i < MAX_LINEAS; i++) {
            lineas[i] = "";
        }

        System.out.println("Bienvenidos al editor EDLIN");
        System.out.println("Utilice el menú inferior para editar el texto");

        char comando;

        do {
            mostrar();
            System.out.print("Comando: ");
            comando = sc.nextLine().toUpperCase().charAt(0);

            switch (comando) {
                case 'L': definirLinea(); break;
                case 'E': editar(); break;
                case 'B': borrar(); break;
                case 'I': intercambiar(); break;
                case 'D': deshacer(); break;
                case 'S': System.out.println("Saliendo del editor..."); break;
                default: System.out.println("Comando no válido");
            }

        } while (comando != 'S');

        sc.close();
    }
}



