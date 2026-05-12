import java.util.Scanner;

public class Console {
    private Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public void write(String text) {
        System.out.print(text);
    }

    public void writeln(String text) {
        System.out.println(text);
    }

    public void writeln() {
        System.out.println();
    }

    public String readString() {
        return scanner.nextLine();
    }
}