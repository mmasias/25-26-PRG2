import java.util.Scanner;

public class ConversorUnidades {

    private static final double METROS_POR_KILOMETRO = 1000.0;
    private static final double METROS_POR_MILLA = 1609.34;
    private static final double MILLAS_POR_METRO = 0.000621371;
    private static final double CENTIMETROS_POR_PULGADA = 2.54;
    private static final double PULGADAS_POR_CENTIMETRO = 0.393701;

    private static final double KILOGRAMOS_POR_GRAMO = 1000.0;
    private static final double LIBRAS_POR_KILOGRAMO = 2.20462;
    private static final double KILOGRAMOS_POR_LIBRA = 0.453592;
    private static final double ONZAS_POR_GRAMO = 0.035274;
    private static final double GRAMOS_POR_ONZA = 28.3495;

    private static final double CERO_ABSOLUTO = 273.15;
    private static final double FACTOR_CELSIUS_FAHRENHEIT = 9.0/5.0;
    private static final double FACTOR_FAHRENHEIT_CELSIUS = 5.0/9.0;
    private static final double DESPLAZAMIENTO_FAHRENHEIT = 32.0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Conversor de Unidades - Version 2.1");
            System.out.println("[1] Longitud");
            System.out.println("[2] Peso");
            System.out.println("[3] Temperatura");
            System.out.print("Tipo de conversion: ");
            int tipo = sc.nextInt();

            if (tipo == 1) {
                System.out.println("Conversion de longitud:");
                System.out.println("[1] Metros a Kilometros");
                System.out.println("[2] Kilometros a Metros");
                System.out.println("[3] Metros a Millas");
                System.out.println("[4] Millas a Metros");
                System.out.println("[5] Centimetros a Pulgadas");
                System.out.println("[6] Pulgadas a Centimetros");
                System.out.print("Opcion: ");
                int opcion = sc.nextInt();
                System.out.print("Valor: ");
                double valor = sc.nextDouble();

                convertirLongitud(opcion, valor);
            } else if (tipo == 2) {
                System.out.println("Conversion de peso:");
                System.out.println("[1] Kilogramos a Gramos");
                System.out.println("[2] Gramos a Kilogramos");
                System.out.println("[3] Kilogramos a Libras");
                System.out.println("[4] Libras a Kilogramos");
                System.out.println("[5] Gramos a Onzas");
                System.out.println("[6] Onzas a Gramos");
                System.out.print("Opcion: ");
                int opcion = sc.nextInt();
                System.out.print("Valor: ");
                double valor = sc.nextDouble();
                convertirPeso(opcion, valor);
            } else if (tipo == 3) {
                System.out.println("Conversion de temperatura:");
                System.out.println("[1] Celsius a Fahrenheit");
                System.out.println("[2] Fahrenheit a Celsius");
                System.out.println("[3] Celsius a Kelvin");
                System.out.println("[4] Kelvin a Celsius");
                System.out.print("Opcion: ");
                int opcion = sc.nextInt();
                System.out.print("Valor: ");
                double valor = sc.nextDouble();
                convertirTemperatura(opcion, valor);
            } else {
                System.out.println("Tipo no valido");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada no valida. Introduzca números cuando se le solicite.");
        }
    }

    private static void convertirLongitud(int opcion, double valor) {
        if (opcion == 1) {
            System.out.println(valor + " m = " + (valor / METROS_POR_KILOMETRO) + " km");
        } else if (opcion == 2) {
            System.out.println(valor + " km = " + (valor * METROS_POR_KILOMETRO) + " m");
        } else if (opcion == 3) {
            System.out.println(valor + " m = " + (valor * MILLAS_POR_METRO) + " mi");
        } else if (opcion == 4) {
            System.out.println(valor + " mi = " + (valor * METROS_POR_MILLA) + " m");
        } else if (opcion == 5) {
            System.out.println(valor + " cm = " + (valor * PULGADAS_POR_CENTIMETRO) + " in");
        } else if (opcion == 6) {
            System.out.println(valor + " in = " + (valor * CENTIMETROS_POR_PULGADA) + " cm");
        } else {
            System.out.println("Opcion no valida");
        }
    }

    private static void convertirPeso(int opcion, double valor) {
        if (opcion == 1) {
            System.out.println(valor + " kg = " + (valor * KILOGRAMOS_POR_GRAMO) + " g");
        } else if (opcion == 2) {
            System.out.println(valor + " g = " + (valor / KILOGRAMOS_POR_GRAMO) + " kg");
        } else if (opcion == 3) {
            System.out.println(valor + " kg = " + (valor * LIBRAS_POR_KILOGRAMO) + " lb");
        } else if (opcion == 4) {
            System.out.println(valor + " lb = " + (valor * KILOGRAMOS_POR_LIBRA) + " kg");
        } else if (opcion == 5) {
            System.out.println(valor + " g = " + (valor * ONZAS_POR_GRAMO) + " oz");
        } else if (opcion == 6) {
            System.out.println(valor + " oz = " + (valor * GRAMOS_POR_ONZA) + " g");
        } else {
            System.out.println("Opcion no valida");
        }
    }

    private static void convertirTemperatura(int opcion, double valor) {
        if (opcion == 1) {
            System.out.println(valor + " C = " + (valor * FACTOR_CELSIUS_FAHRENHEIT + DESPLAZAMIENTO_FAHRENHEIT) + " F");
        } else if (opcion == 2) {
            System.out.println(valor + " F = " + ((valor - DESPLAZAMIENTO_FAHRENHEIT) * FACTOR_FAHRENHEIT_CELSIUS) + " C");
        } else if (opcion == 3) {
            System.out.println(valor + " C = " + (valor + CERO_ABSOLUTO) + " K");
        } else if (opcion == 4) {
            System.out.println(valor + " K = " + (valor - CERO_ABSOLUTO) + " C");
        } else {
            System.out.println("Opcion no valida");
        }
    }
}
