import java .util.Scanner;

public class pyEdlin {
    public static void main(String[] args) {

    Boolean edlinEncendido = true;
    Scanner comando = new Scanner(System.in);
    do {
        System.out.print("Elegir un comando: [1]Mirar lineas, [2]Agredar linea, [3]Moficar linea, [4]Salir: ");
        String comandoElegido = comando.nextLine();
        switch (comandoElegido) {
            case "1" -> {
                System.out.println("Mostrando líneas...");
            }
            case "2" -> {
                System.out.println("Agregando línea...");
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