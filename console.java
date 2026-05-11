import java.util.Scanner;

public class Console {

    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public int leerOpcion() {

        System.out.print("Elige una opción: ");
        return scanner.nextInt();
    }
}
