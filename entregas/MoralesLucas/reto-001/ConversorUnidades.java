import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        boolean valido = true;

        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.print("Tipo de conversion: ");
        int tipo = scanner.nextInt();
        

        if (tipo == 1) {
            System.out.println("Conversion de longitud:");
            System.out.println("[1] Metros a Kilometros");
            System.out.println("[2] Kilometros a Metros");
            System.out.println("[3] Metros a Millas");
            System.out.println("[4] Millas a Metros");
            System.out.println("[5] Centimetros a Pulgadas");
            System.out.println("[6] Pulgadas a Centimetros");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            if (opcion == 1) {
                System.out.println(valor + " m = " + (valor / 1000) + " km");
            } else if (opcion == 2) {
                System.out.println(valor + " km = " + (valor * 1000) + " m");
            } else if (opcion == 3) {
                System.out.println(valor + " m = " + (valor * 0.000621371) + " mi");
            } else if (opcion == 4) {
                System.out.println(valor + " mi = " + (valor * 1609.34) + " m");
            } else if (opcion == 5) {
                System.out.println(valor + " cm = " + (valor * 0.393701) + " in");
            } else if (opcion == 6) {
                System.out.println(valor + " in = " + (valor * 2.54) + " cm");
            } else {
                System.out.println("Opcion no valida");
                valido = false;
            }
        } else if (tipo == 2) {
            System.out.println("Conversion de peso:");
            System.out.println("[1] Kilogramos a Gramos");
            System.out.println("[2] Gramos a Kilogramos");
            System.out.println("[3] Kilogramos a Libras");
            System.out.println("[4] Libras a Kilogramos");
            System.out.println("[5] Gramos a Onzas");
            System.out.println("[6] Onzas a Gramos");
            System.out.print("Opcion: ");
            int o = scanner.nextInt();
            System.out.print("Valor: ");
            double v = scanner.nextDouble();

            if (o == 1) {
                System.out.println(v + " kg = " + (v * 1000) + " g");
            } else if (o == 2) {
                System.out.println(v + " g = " + (v / 1000) + " kg");
            } else if (o == 3) {
                System.out.println(v + " kg = " + (v * 2.20462) + " lb");
            } else if (o == 4) {
                System.out.println(v + " lb = " + (v * 0.453592) + " kg");
            } else if (o == 5) {
                System.out.println(v + " g = " + (v * 0.035274) + " oz");
            } else if (o == 6) {
                System.out.println(v + " oz = " + (v * 28.3495) + " g");
            } else {
                System.out.println("Opcion no valida");
                valido = false;
            }
        } else if (tipo == 3) {
            System.out.println("Conversion de temperatura:");
            System.out.println("[1] Celsius a Fahrenheit");
            System.out.println("[2] Fahrenheit a Celsius");
            System.out.println("[3] Celsius a Kelvin");
            System.out.println("[4] Kelvin a Celsius");
            System.out.print("Opcion: ");
            int o = scanner.nextInt();
            System.out.print("Valor: ");
            double v = scanner.nextDouble();

            if (o == 1) {
                System.out.println(v + " C = " + (v * 9 / 5 + 32) + " F");
            } else if (o == 2) {
                System.out.println(v + " F = " + ((v - 32) * 5 / 9) + " C");
            } else if (o == 3) {
                System.out.println(v + " C = " + (v + 273.15) + " K");
            } else if (o == 4) {
                System.out.println(v + " K = " + (v - 273.15) + " C");
            } else {
                System.out.println("Opcion no valida");
                valido = false;
            }
        } else {
            System.out.println("Tipo no valido");
        }
    }
}