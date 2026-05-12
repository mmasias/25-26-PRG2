package vistas.fraccion;

import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);

    public void writeln(String mensaje) {
        System.out.println(mensaje);
    }

    public int readInt(String mensaje) {
        System.out.print(mensaje + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Error: Debe ser un número entero. " + mensaje + " ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}