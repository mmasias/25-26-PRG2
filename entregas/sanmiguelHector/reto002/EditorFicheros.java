package entregas.sanmiguelHector.reto002;

import java.util.Scanner;

public class EditorFicheros {

    static String[] fichero;
    static int lineaActiva = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcionElegidaPorUsuario;

        CrearFichero();

        do {
            MostrarMenu();
            MostrarFichero();

            opcionElegidaPorUsuario = scanner.next();

            switch (opcionElegidaPorUsuario) {
                case "S":
                    System.out.println("Saliendo del editor...");
                    break;
                case "L":
                    int nuevaLinea = DefinirLineaActiva();
                    if (nuevaLinea != -1) {
                        lineaActiva = nuevaLinea;
                    }
                    break;
            }

        } while (!opcionElegidaPorUsuario.equals("S"));
    }

    static int DefinirLineaActiva() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione línea (1-10): ");
        int linea = scanner.nextInt();

        if (linea < 1 || linea > 10) {
            System.out.println("Línea no válida.");
            return -1;
        }

        System.out.println("Línea activa establecida en: " + linea);
        return linea - 1;
    }

    static void MostrarMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("0: | Bienvenidos al editor EDLIN");
        System.out.println("1:*| Utilice el menu inferior para editar el texto");
        System.out.println("2: | ------");
        System.out.println("3: | [L] permite definir la linea activa");
        System.out.println("4: | [E] permite editar la linea activa");
        System.out.println("5: | [I] permite intercambiar dos lineas");
        System.out.println("6: | [B] borra el contenido de la linea activa");
        System.out.println("7: | [S] sale del programa");
        System.out.println("8: | ");
        System.out.println("9: | ");
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
        System.out.println();
    }

    static void CrearFichero() {
        fichero = new String[10];
        for (int i = 0; i < fichero.length; i++) {
            fichero[i] = "";
        }
    }

    static void MostrarFichero() {
        System.out.println("------------------Fichero Actual------------------");
        for (int i = 0; i < fichero.length; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.println(i + marca + ": " + fichero[i]);
        }
    }
}
