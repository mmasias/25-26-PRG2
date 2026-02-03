import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        int unidadElegida = eleccionUnidad();
        System.out.println("Has elegido la opción: " + unidadElegida);

        
    }
    private static int eleccionUnidad() {
       Scanner sc = new Scanner(System.in);
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.print("Tipo de conversion: ");
        int unidadElegida = scanner.nextInt();
        return unidadElegida; 
    }
    private static void ValorUnidadElegido(int unidadElegida) {
        if (unidadElegida == 1) {
            System.out.println("Conversion de longitud:");
            System.out.println("[1] Metros a Kilometros");
            System.out.println("[2] Kilometros a Metros");
            System.out.println("[3] Metros a Millas");
            System.out.println("[4] Millas a Metros");
            System.out.println("[5] Centimetros a Pulgadas");
            System.out.println("[6] Pulgadas a Centimetros");
            System.out.print("Opcion: ");
            int opcionElegida = sc.nextInt();
            System.out.print("Valor: ");
            double valorElegido = sc.nextDouble();

            if (opcionElegida == 1) {
                System.out.println(valorElegido + " m = " + (valorElegido / 1000) + " km");
            } else if (opcionElegida == 2) {
                System.out.println(valorElegido + " km = " + (valorElegido * 1000) + " m");
            } else if (opcionElegida == 3) {
                System.out.println(valorElegido + " m = " + (valorElegido * 0.000621371) + " mi");
            } else if (opcionElegida == 4) {
                System.out.println(valorElegido + " mi = " + (valorElegido * 1609.34) + " m");
            } else if (opcionElegida == 5) {
                System.out.println(valorElegido + " cm = " + (valorElegido * 0.393701) + " in");
            } else if (opcionElegida == 6) {
                System.out.println(valorElegido + " in = " + (valorElegido * 2.54) + " cm");
            } else {
                System.out.println("Opcion no valida");
                
            }
        } else if (unidadElegida == 2) {
            System.out.println("Conversion de peso:");
            System.out.println("[1] Kilogramos a Gramos");
            System.out.println("[2] Gramos a Kilogramos");
            System.out.println("[3] Kilogramos a Libras");
            System.out.println("[4] Libras a Kilogramos");
            System.out.println("[5] Gramos a Onzas");
            System.out.println("[6] Onzas a Gramos");
            System.out.print("Opcion: ");
            int opcionElegida = sc.nextInt();
            System.out.print("Valor: ");
            double valorElegido = sc.nextDouble();

            if (opcionElegida == 1) {
                System.out.println(valorElegido + " kg = " + (valorElegido * 1000) + " g");
            } else if (opcionElegida == 2) {
                System.out.println(valorElegido + " g = " + (valorElegido / 1000) + " kg");
            } else if (opcionElegida == 3) {
                System.out.println(valorElegido + " kg = " + (valorElegido * 2.20462) + " lb");
            } else if (opcionElegida == 4) {
                System.out.println(valorElegido + " lb = " + (valorElegido * 0.453592) + " kg");
            } else if (opcionElegida == 5) {
                System.out.println(valorElegido + " g = " + (valorElegido * 0.035274) + " oz");
            } else if (opcionElegida == 6) {
                System.out.println(valorElegido + " oz = " + (valorElegido * 28.3495) + " g");
            } else {
                System.out.println("Opcion no valida");
                
            }
        } else if (unidadElegida == 3) {
            System.out.println("Conversion de temperatura:");
            System.out.println("[1] Celsius a Fahrenheit");
            System.out.println("[2] Fahrenheit a Celsius");
            System.out.println("[3] Celsius a Kelvin");
            System.out.println("[4] Kelvin a Celsius");
            System.out.print("Opcion: ");
            int opcionElegida = sc.nextInt();
            System.out.print("Valor: ");
            double valorElegido = sc.nextDouble();

            if (opcionElegida == 1) {
                System.out.println(valorElegido + " C = " + (valorElegido * 9 / 5 + 32) + " F");
            } else if (opcionElegida == 2) {
                System.out.println(valorElegido + " F = " + ((valorElegido - 32) * 5 / 9) + " C");
            } else if (opcionElegida == 3) {
                System.out.println(valorElegido + " C = " + (valorElegido + 273.15) + " K");
            } else if (opcionElegida == 4) {
                System.out.println(valorElegido + " K = " + (valorElegido - 273.15) + " C");
            } else {
                System.out.println("Opcion no valida");
            }
        } else {
            System.out.println("Tipo no valido");
        }
    }

}








