import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        } else if (tipo == 2) {
            System.out.println("Conversion de peso:");
            System.out.println("[1] Kilogramos a Gramos");
            System.out.println("[2] Gramos a Kilogramos");
            System.out.println("[3] Kilogramos a Libras");
            System.out.println("[4] Libras a Kilogramos");
            System.out.println("[5] Gramos a Onzas");
            System.out.println("[6] Onzas a Gramos");
        } else if (tipo == 3) {
            System.out.println("Conversion de temperatura:");
            System.out.println("[1] Celsius a Fahrenheit");
            System.out.println("[2] Fahrenheit a Celsius");
            System.out.println("[3] Celsius a Kelvin");
            System.out.println("[4] Kelvin a Celsius");
        } else {
            System.out.println("Tipo no valido");
            return;
        }

        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        if (tipo == 1) {
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
            }
        } else if (tipo == 2) {
            if (opcion == 1) {
                System.out.println(valor + " kg = " + (valor * 1000) + " g");
            } else if (opcion == 2) {
                System.out.println(valor + " g = " + (valor / 1000) + " kg");
            } else if (opcion == 3) {
                System.out.println(valor + " kg = " + (valor * 2.20462) + " lb");
            } else if (opcion == 4) {
                System.out.println(valor + " lb = " + (valor * 0.453592) + " kg");
            } else if (opcion == 5) {
                System.out.println(valor + " g = " + (valor * 0.035274) + " oz");
            } else if (opcion == 6) {
                System.out.println(valor + " oz = " + (valor * 28.3495) + " g");
            } else {
                System.out.println("Opcion no valida");
            }
        } else if (tipo == 3) {
            if (opcion == 1) {
                System.out.println(valor + " C = " + (valor * 9 / 5 + 32) + " F");
            } else if (opcion == 2) {
                System.out.println(valor + " F = " + ((valor - 32) * 5 / 9) + " C");
            } else if (opcion == 3) {
                System.out.println(valor + " C = " + (valor + 273.15) + " K");
            } else if (opcion == 4) {
                System.out.println(valor + " K = " + (valor - 273.15) + " C");
            } else {
                System.out.println("Opcion no valida");
            }
        }
    }
}
