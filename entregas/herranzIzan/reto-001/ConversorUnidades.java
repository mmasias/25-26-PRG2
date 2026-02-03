import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorUnidades {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenuPrincipal();
        int tipo = leerEntero();

        switch (tipo) {
            case 1 -> convertirLongitud();
            case 2 -> convertirPeso();
            case 3 -> convertirTemperatura();
            default -> System.out.println("Tipo de conversión no válido.");
        }

        scanner.close();
    }

    // ================= MENÚS =================

    private static void mostrarMenuPrincipal() {
        System.out.println("==============================");
        System.out.println(" Conversor de Unidades v2.2");
        System.out.println("==============================");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.print("Tipo de conversión: ");
    }

    private static void convertirLongitud() {
        System.out.println("\n--- Conversión de longitud ---");
        System.out.println("[1] Metros a Kilómetros");
        System.out.println("[2] Kilómetros a Metros");
        System.out.println("[3] Metros a Millas");
        System.out.println("[4] Millas a Metros");
        System.out.println("[5] Centímetros a Pulgadas");
        System.out.println("[6] Pulgadas a Centímetros");
        System.out.print("Opción: ");

        int opcion = leerEntero();
        System.out.print("Valor: ");
        double valor = leerDouble();

        switch (opcion) {
            case 1 -> System.out.println(valor + " m = " + (valor / 1000) + " km");
            case 2 -> System.out.println(valor + " km = " + (valor * 1000) + " m");
            case 3 -> System.out.println(valor + " m = " + (valor * 0.000621371) + " mi");
            case 4 -> System.out.println(valor + " mi = " + (valor * 1609.34) + " m");
            case 5 -> System.out.println(valor + " cm = " + (valor * 0.393701) + " in");
            case 6 -> System.out.println(valor + " in = " + (valor * 2.54) + " cm");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void convertirPeso() {
        System.out.println("\n--- Conversión de peso ---");
        System.out.println("[1] Kilogramos a Gramos");
        System.out.println("[2] Gramos a Kilogramos");
        System.out.println("[3] Kilogramos a Libras");
        System.out.println("[4] Libras a Kilogramos");
        System.out.println("[5] Gramos a Onzas");
        System.out.println("[6] Onzas a Gramos");
        System.out.print("Opción: ");

        int opcion = leerEntero();
        System.out.print("Valor: ");
        double valor = leerDouble();

        switch (opcion) {
            case 1 -> System.out.println(valor + " kg = " + (valor * 1000) + " g");
            case 2 -> System.out.println(valor + " g = " + (valor / 1000) + " kg");
            case 3 -> System.out.println(valor + " kg = " + (valor * 2.20462) + " lb");
            case 4 -> System.out.println(valor + " lb = " + (valor * 0.453592) + " kg");
            case 5 -> System.out.println(valor + " g = " + (valor * 0.035274) + " oz");
            case 6 -> System.out.println(valor + " oz = " + (valor * 28.3495) + " g");
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void convertirTemperatura() {
        System.out.println("\n--- Conversión de temperatura ---");
        System.out.println("[1] Celsius a Fahrenheit");
        System.out.println("[2] Fahrenheit a Celsius");
        System.out.println("[3] Celsius a Kelvin");
        System.out.println("[4] Kelvin a Celsius");
        System.out.print("Opción: ");

        int opcion = leerEntero();
        System.out.print("Valor: ");
        double valor = leerDouble();

        switch (opcion) {
            case 1 -> System.out.println(valor + " °C = " + (valor * 9 / 5 + 32) + " °F");
            case 2 -> System.out.println(valor + " °F = " + ((valor - 32) * 5 / 9) + " °C");
            case 3 -> System.out.println(valor + " °C = " + (valor + 273.15) + " K");
            case 4 -> System.out.println(valor + " K = " + (valor - 273.15) + " °C");
            default -> System.out.println("Opción no válida.");
        }
    }

    // ================= UTILIDADES =================

    private static int leerEntero() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Introduce un número entero: ");
                scanner.next();
            }
        }
    }

    private static double leerDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Entrada inválida. Introduce un número válido: ");
                scanner.next();
            }
        }
    }
}
