import java.util.Scanner;

class MipyEdlin {
    public static void main(String[] args) {

        Boolean edlinEncendido = true;
        String[][] lineas = {
                { "Bienvenido a Edlin" },
                { "Un editor de texto" },
                { "donde puedes escribir hasta 10 líneas de texto." },
                { "" },
                { "" },
                { "" },
                { "" },
                { "" },
                { "" },
                { "" }
        };
        int lineaElegida = 0;
        Scanner sc = new Scanner(System.in);

        do {
            mostrarLineas(lineas);
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1" -> modificarLinea(lineas, lineaElegida, sc);

                case "2" -> borrarLinea(lineas, lineaElegida, sc);

                case "3" -> {
                    System.out.println("Modificando línea...");
                }

                case "4" -> {
                    edlinEncendido = false;
                    System.out.println("Apagando Edlin...");
                }
                default -> System.out.println(""); 
            }

        } while (edlinEncendido);
                sc.close();
    }

    static void mostrarLineas(String[][] lineas) {
        if (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("0|" + (lineas[0][0]));
            System.out.println("1|" + (lineas[1][0]));
            System.out.println("2|" + (lineas[2][0]));
            System.out.println("3|" + (lineas[3][0]));
            System.out.println("4|" + (lineas[4][0]));
            System.out.println("5|" + (lineas[5][0]));
            System.out.println("6|" + (lineas[6][0]));
            System.out.println("7|" + (lineas[7][0]));
            System.out.println("8|" + (lineas[8][0]));
            System.out.println("9|" + (lineas[9][0]));
            System.out.println("------------------------------------------------------------------");

            System.out.print(
                    "Elegir un comando: [1]Añadir linea, [2]Quitar linea, [3]Moficar linea, [4]Salir: ");
        }
    }

    static void modificarLinea(String[][] lineas, int lineaElegida, Scanner sc) {
        System.out.println("Añadiendo línea...");
        System.out.println("Elija en que línea desea añadir el texto (0-9): ");
        lineaElegida = sc.nextInt();
        Scanner lineaAñadida = new Scanner(System.in);
        if (lineaElegida < lineas.length) {
            System.out.print("Escribe la línea que deseas añadir: ");
            lineas[lineaElegida][0] = lineaAñadida.nextLine();
        } else {
            System.out.println("No se pueden añadir más líneas. El límite es de 10 líneas.");
        }

    }

    static void borrarLinea(String[][] lineas, int lineaElegida, Scanner sc) {
        System.out.println("Borrando línea...");
        System.out.println("Elija en que línea desea borrar el texto (0-9): ");
        lineaElegida = sc.nextInt();
        if (lineaElegida < lineas.length) {lineas[lineaElegida][0] = "";
        } else {
            System.out.println("error al borrar la línea. El número de línea debe estar entre 0 y 9.");
        }
    }

}
