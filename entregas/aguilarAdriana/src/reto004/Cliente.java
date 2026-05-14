import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = imprimirMenu(scanner);

        System.out.println();
        System.out.println("Ingresa dos fracciones para probar metodos.");
        Fraccion primeraFraccion = leerFraccion(scanner, "Primera fraccion");
        Fraccion segundaFraccion = leerFraccion(scanner, "Segunda fraccion");

        System.out.println();
        System.out.println("Fracciones ingresadas: " + primeraFraccion + " y " + segundaFraccion);

        switch (opcion) {
            case 1:
                mostrarComparaciones(primeraFraccion, segundaFraccion);
                break;
            case 2:
                mostrarOperaciones(primeraFraccion, segundaFraccion);
                break;
            case 3:
                mostrarSimplificacion(primeraFraccion);
                break;
            case 4:
                mostrarComparaciones(primeraFraccion, segundaFraccion);
                mostrarOperaciones(primeraFraccion, segundaFraccion);
                mostrarSimplificacion(primeraFraccion);
                break;
            default:
                System.out.println("Opcion no valida.");
                break;
        }

        System.out.println("=== Fin ===");
        scanner.close();
    }

    private static int imprimirMenu(Scanner scanner) {
        System.out.println("=== Cliente de Fracciones ===");
        System.out.println("1) Comparaciones");
        System.out.println("2) Operaciones");
        System.out.println("3) Simplificar");
        System.out.println("4) Todo");
        System.out.print("Elige una opcion: ");
        return scanner.nextInt();
    }

    private static void mostrarComparaciones(Fraccion primeraFraccion, Fraccion segundaFraccion) {
        System.out.println("menorQue: " + primeraFraccion.menorQue(segundaFraccion));
        System.out.println("mayorQue: " + primeraFraccion.mayorQue(segundaFraccion));
        System.out.println("equals: " + primeraFraccion.equals(segundaFraccion));
    }

    private static void mostrarOperaciones(Fraccion primeraFraccion, Fraccion segundaFraccion) {
        Fraccion suma = new Fraccion(primeraFraccion.getNumerador(), primeraFraccion.getDenominador());
        suma.sumar(segundaFraccion);
        System.out.println("suma: " + suma);

        Fraccion resta = new Fraccion(primeraFraccion.getNumerador(), primeraFraccion.getDenominador());
        resta.restar(segundaFraccion);
        System.out.println("resta: " + resta);

        Fraccion multiplicacion = new Fraccion(primeraFraccion.getNumerador(), primeraFraccion.getDenominador());
        multiplicacion.multiplicar(segundaFraccion);
        System.out.println("multiplicacion: " + multiplicacion);

        if (segundaFraccion.getNumerador() != 0) {
            Fraccion division = new Fraccion(primeraFraccion.getNumerador(), primeraFraccion.getDenominador());
            division.dividir(segundaFraccion);
            System.out.println("division: " + division);
        } else {
            System.out.println("division: no se puede dividir entre 0");
        }
    }

    private static void mostrarSimplificacion(Fraccion primeraFraccion) {
        Fraccion simplificada = new Fraccion(primeraFraccion.getNumerador(), primeraFraccion.getDenominador());
        simplificada.simplificar();
        System.out.println("primera simplificada: " + simplificada);
    }

    private static Fraccion leerFraccion(Scanner scanner, String etiqueta) {
        int numerador;
        int denominador;

        System.out.println();
        System.out.println(etiqueta + ":");
        System.out.print("Numerador: ");
        numerador = scanner.nextInt();

        do {
            System.out.print("Denominador (distinto de 0): ");
            denominador = scanner.nextInt();
            if (denominador == 0) {
                System.out.println("El denominador no puede ser 0. Intenta otra vez.");
            }
        } while (denominador == 0);

        return new Fraccion(numerador, denominador);
    }
}
