import java .util.Scanner;

public class pyEdlin {
    public static void main(String[] args) {

    Boolean edlinEncendido = true;
    String[] lineas = new String[10];
    lineas[0] = "Bienvenido a Edlin";
    lineas[1] = "Un editor de texto";
    lineas[2] = "donde puedes escribir hasta 10 líneas de texto.";
    lineas[3] = "";
    lineas[4] = "";
    lineas[5] = "";
    lineas[6] = "";
    lineas[7] = "";
    lineas[8] = "";
    lineas[9] = "";
    Scanner comando = new Scanner(System.in);

    do {
        System.out.println("------------------------------------------------------------------");
        System.out.println("0|" + (lineas[0]));
        System.out.println("1|" + (lineas[1]));
        System.out.println("2|" + (lineas[2]));
        System.out.println("3|" + (lineas[3]));
        System.out.println("4|" + (lineas[4]));
        System.out.println("5|" + (lineas[5]));
        System.out.println("6|" + (lineas[6]));
        System.out.println("7|" + (lineas[7]));
        System.out.println("8|" + (lineas[8]));
        System.out.println("9|" + (lineas[9]));
        System.out.println("------------------------------------------------------------------");

        System.out.print("Elegir un comando: [1]Añadir linea, [2]Quitar linea, [3]Moficar linea, [4]Salir: ");
        String comandoElegido = comando.nextLine();
        switch (comandoElegido) {
            case "1" -> {
                System.out.println("Añadiendo línea...");
            }

            case "2" -> {
                System.out.println("Borrando línea...");
            }

            case "3" -> {
                System.out.println("Modificando línea...");
            }

            case "4" -> {
                edlinEncendido = false;
                System.out.println("Apagando Edlin...");
            }
            default -> System.out.println("Comando no reconocido. Por favor, elige un comando válido.");
        }
        } while (edlinEncendido);
    comando.close();
    }
}