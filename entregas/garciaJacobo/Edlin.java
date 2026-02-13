package entregas.garciaJacobo;

import java.util.Scanner;

public class Edlin {
    public static void main(String[] args) {
        String[] fichero = {
                "Bienvenidos al editor EDLIN",
                "Utilice el menu inferior para editar el texto",
                "------",
                "[L] permite definir la linea activa",
                "[E] permite editar la linea activa",
                "[I] permite intercambiar dos lineas",
                "[B] borra el contenido de la linea activa",
                "[D] deshace la última acción realizada",
                "[S] sale del programa",
                ""
        };

        int[] lineaActiva = new int[1];

        do {
            mostrarMenu(fichero, lineaActiva);

        } while (botonesAccion(fichero, lineaActiva));

    }

    private static void intercambiarFilas(String[] fichero) {
        int linea1;
        int linea2;
        do {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Que linea deseas intercambiar?");
            linea1 = scanner.nextInt();
            System.out.println("por que linea la intercambias?");
            linea2 = scanner.nextInt();
        } while (validarLineas(fichero, linea1, linea2));

        String temporal1 = fichero[linea1];

        fichero[linea1] = fichero[linea2];
        fichero[linea2] = temporal1;

    }

    private static boolean validarLineas(String[] fichero, int linea1, int linea2) {
        boolean lineasInvalidas = linea1 < 0 || linea1 >= fichero.length || linea2 < 0 || linea2 >= fichero.length;
        if (lineasInvalidas) {
            System.out.println("lineas erroneas escoge otras entre 0 y 9");
        } 
            return false;

    }

    private static boolean botonesAccion(String[] fichero, int[] lineaActiva) {
        boolean estaFuncionando = true;
        switch (askChar()) {
            case 'l', 'L' -> preguntarLineaActiva(lineaActiva);
            case 'e', 'E' -> editar(lineaActiva, fichero);
            case 'i', 'I' -> intercambiarFilas(fichero);
            case 's', 'S' -> estaFuncionando = false;

        }
        return estaFuncionando;
    }

    private static char askChar() {
        return new Scanner(System.in).next().charAt(0);
    }

    private static void preguntarLineaActiva(int[] lineaActiva) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("que linea activa eliges?");
        lineaActiva[0] = scanner.nextInt();

    }

    private static void editar(int[] lineaActiva, String[] fichero) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Editando la linea " + lineaActiva[0]);
        fichero[lineaActiva[0]] = scanner.nextLine();
    }

    private static void mostrarMenu(String[] fichero, int[] lineaActiva) {
        imprimirBordeHorizontal();
        for (int i = 0; i < fichero.length; i++) {

            String separador = i + ((lineaActiva[0] == i) ? "*" : " ") + "|";
            if (fichero[i] != null) {

                System.out.println(separador + fichero[i]);
            } else {
                System.out.println(separador);
            }

        }
        imprimirBordeHorizontal();
        imprimirComandos();
    }

    private static void imprimirComandos() {
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    private static void imprimirBordeHorizontal() {
        System.out.println("---------------------------------------------------");
    }

}
