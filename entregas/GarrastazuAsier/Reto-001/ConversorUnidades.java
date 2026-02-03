import java.util.Scanner;

public class ConversorUnidades {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
        sc.close();
    }

    static void menuPrincipal() {
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.print("Tipo de conversion: ");

        int t = sc.nextInt();

        switch (t) {
            case 1 -> convertirLongitud();
            case 2 -> convertirPeso();
            case 3 -> convertirTemperatura();
            default -> System.out.println("Tipo no valido");
        }
    }

    static void convertirLongitud() {
        System.out.println("Conversion de longitud:");
        System.out.println("[1] Metros a Kilometros");
        System.out.println("[2] Kilometros a Metros");
        System.out.println("[3] Metros a Millas");
        System.out.println("[4] Millas a Metros");
        System.out.println("[5] Centimetros a Pulgadas");
        System.out.println("[6] Pulgadas a Centimetros");
        System.out.print("Opcion: ");

        int o = sc.nextInt();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        switch (o) {
            case 1 -> System.out.println(v + " m = " + (v / 1000) + " km");
            case 2 -> System.out.println(v + " km = " + (v * 1000) + " m");
            case 3 -> System.out.println(v + " m = " + (v * 0.000621371) + " mi");
            case 4 -> System.out.println(v + " mi = " + (v * 1609.34) + " m");
            case 5 -> System.out.println(v + " cm = " + (v * 0.393701) + " in");
            case 6 -> System.out.println(v + " in = " + (v * 2.54) + " cm");
            default -> System.out.println("Opcion no valida");
        }
    }

    static void convertirPeso() {
        System.out.println("Conversion de peso:");
        System.out.println("[1] Kilogramos a Gramos");
        System.out.println("[2] Gramos a Kilogramos");
        System.out.println("[3] Kilogramos a Libras");
        System.out.println("[4] Libras a Kilogramos");
        System.out.println("[5] Gramos a Onzas");
        System.out.println("[6] Onzas a Gramos");
        System.out.print("Opcion: ");

        int o = sc.nextInt();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        switch (o) {
            case 1 -> System.out.println(v + " kg = " + (v * 1000) + " g");
            case 2 -> System.out.println(v + " g = " + (v / 1000) + " kg");
            case 3 -> System.out.println(v + " kg = " + (v * 2.20462) + " lb");
            case 4 -> System.out.println(v + " lb = " + (v * 0.453592) + " kg");
            case 5 -> System.out.println(v + " g = " + (v * 0.035274) + " oz");
            case 6 -> System.out.println(v + " oz = " + (v * 28.3495) + " g");
            default -> System.out.println("Opcion no valida");
        }
    }

    static void convertirTemperatura() {
        System.out.println("Conversion de temperatura:");
        System.out.println("[1] Celsius a Fahrenheit");
        System.out.println("[2] Fahrenheit a Celsius");
        System.out.println("[3] Celsius a Kelvin");
        System.out.println("[4] Kelvin a Celsius");
        System.out.print("Opcion: ");

        int o = sc.nextInt();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        switch (o) {
            case 1 -> System.out.println(v + " C = " + (v * 9 / 5 + 32) + " F");
            case 2 -> System.out.println(v + " F = " + ((v - 32) * 5 / 9) + " C");
            case 3 -> System.out.println(v + " C = " + (v + 273.15) + " K");
            case 4 -> System.out.println(v + " K = " + (v - 273.15) + " C");
            default -> System.out.println("Opcion no valida");
        }
    }
}