import java.util.Scanner;

public class Menu {
    private Scanner entrada;

    public Menu() {
        entrada = new Scanner(System.in);
    }

    public int obtenerOpcion() {
        this.mostrarOpciones();
        return this.leerOpcionValida();
    }

    private void mostrarOpciones() {
        System.out.println("--------------------");
        System.out.println("1. Pedir");
        System.out.println("2. Empezar de nuevo");
        System.out.println("3. Salir");
        System.out.println("--------------------");
    }

    private int leerOpcionValida() {
        int opcion = 0;
        boolean esValida = false;

        while (!esValida) {
            System.out.print("Introduce una opción: ");

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1, 2, 3 -> esValida = true;
                    default -> System.out.println("Error: El número debe ser 1, 2 o 3.");
                }
            } else {
                System.out.println("Error: ¡Debes introducir un NÚMERO!");
                entrada.next();
            }
        }

        assert opcion >= 1 && opcion <= 3 : "Error lógico: Se intentó devolver una opción inválida: " + opcion;

        return opcion;
    }
}
