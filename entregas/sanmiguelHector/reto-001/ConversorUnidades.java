import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MenuPrincipal();
        int opcionElegidaPorUsuario = scanner.nextInt();

        switch (opcionElegidaPorUsuario) {
            case 1:
                MenuLongitud();
                int opcionLongitud = scanner.nextInt();
                System.out.print("Valor: ");
                double valorLongitud = scanner.nextDouble();

                switch (opcionLongitud) {
                    case 1:
                        System.out.println(valorLongitud + " m = " + (valorLongitud / 1000) + " km");
                        break;
                    case 2:
                        System.out.println(valorLongitud + " km = " + (valorLongitud * 1000) + " m");
                        break;
                    case 3:
                        System.out.println(valorLongitud + " m = " + (valorLongitud * 0.000621371) + " mi");
                        break;
                    case 4:
                        System.out.println(valorLongitud + " mi = " + (valorLongitud * 1609.34) + " m");
                        break;
                    case 5:
                        System.out.println(valorLongitud + " cm = " + (valorLongitud * 0.393701) + " in");
                        break;
                    case 6:
                        System.out.println(valorLongitud + " in = " + (valorLongitud * 2.54) + " cm");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            case 2:
                MenuPeso();
                int opcionPeso = scanner.nextInt();
                System.out.print("Valor: ");
                double valorPeso = scanner.nextDouble();

                switch (opcionPeso) {
                    case 1:
                        System.out.println(valorPeso + " kg = " + (valorPeso * 1000) + " g");
                        break;
                    case 2:
                        System.out.println(valorPeso + " g = " + (valorPeso / 1000) + " kg");
                        break;
                    case 3:
                        System.out.println(valorPeso + " kg = " + (valorPeso * 2.20462) + " lb");
                        break;
                    case 4:
                        System.out.println(valorPeso + " lb = " + (valorPeso * 0.453592) + " kg");
                        break;
                    case 5:
                        System.out.println(valorPeso + " g = " + (valorPeso * 0.035274) + " oz");
                        break;
                    case 6:
                        System.out.println(valorPeso + " oz = " + (valorPeso * 28.3495) + " g");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            case 3:
                MenuTemperatura();
                int opcionTemp = scanner.nextInt();
                System.out.print("Valor: ");
                double valorTemp = scanner.nextDouble();

                switch (opcionTemp) {
                    case 1:
                        System.out.println(valorTemp + " C = " + (valorTemp * 9 / 5 + 32) + " F");
                        break;
                    case 2:
                        System.out.println(valorTemp + " F = " + ((valorTemp - 32) * 5 / 9) + " C");
                        break;
                    case 3:
                        System.out.println(valorTemp + " C = " + (valorTemp + 273.15) + " K");
                        break;
                    case 4:
                        System.out.println(valorTemp + " K = " + (valorTemp - 273.15) + " C");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
                break;

            default:
                System.out.println("Tipo no valido");
        }
    }

    static void MenuPeso() {
        System.out.println("Conversion de peso:");
        System.out.println("[1] Kilogramos a Gramos");
        System.out.println("[2] Gramos a Kilogramos");
        System.out.println("[3] Kilogramos a Libras");
        System.out.println("[4] Libras a Kilogramos");
        System.out.println("[5] Gramos a Onzas");
        System.out.println("[6] Onzas a Gramos");
        System.out.print("Opcion: ");
    }

    static void MenuLongitud() {
        System.out.println("Conversion de longitud:");
        System.out.println("[1] Metros a Kilometros");
        System.out.println("[2] Kilometros a Metros");
        System.out.println("[3] Metros a Millas");
        System.out.println("[4] Millas a Metros");
        System.out.println("[5] Centimetros a Pulgadas");
        System.out.println("[6] Pulgadas a Centimetros");
        System.out.print("Opcion: ");
    }

    static void MenuTemperatura() {
        System.out.println("Conversion de temperatura:");
        System.out.println("[1] Celsius a Fahrenheit");
        System.out.println("[2] Fahrenheit a Celsius");
        System.out.println("[3] Celsius a Kelvin");
        System.out.println("[4] Kelvin a Celsius");
        System.out.print("Opcion: ");
    }

    static void MenuPrincipal() {
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.print("Tipo de conversion: ");
    }
}