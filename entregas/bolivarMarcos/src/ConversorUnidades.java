import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eleccionConversion = 0;
        double valorConversion = 0.0;
        pedirConversion(sc, eleccionConversion);
        boolean operacionValida = true;
        while (operacionValida) {

            eleccionConversion = pedirConversion(sc, eleccionConversion);

            if (eleccionConversion == 1) {
                 convertirLongitud(sc, eleccionConversion, valorConversion, operacionValida);
            } else if (eleccionConversion == 2) {
                convertirPeso(sc, eleccionConversion, valorConversion, operacionValida);
            } else if (eleccionConversion == 3) {
             convertirTemperatura(sc, eleccionConversion, valorConversion, operacionValida);
            }else if (eleccionConversion==4){
                System.out.println("Saliendo del conversor de unidades...");
                operacionValida=false; 
            }else {
                System.out.println("Tipo no valido");
            }
        }
    }

    static int pedirConversion(Scanner sc, int eleccionConversion) {
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud");
        System.out.println("[2] Peso");
        System.out.println("[3] Temperatura");
        System.out.println("[4] Salir");
        System.out.print("Tipo de conversion: ");
        eleccionConversion = sc.nextInt();
        return eleccionConversion;
    }

    static double convertirLongitud(Scanner sc, int eleccion, double conversion, boolean operacionValida) {
        while (operacionValida) {
            System.out.println("Conversion de longitud:");
            System.out.println("[1] Metros a Kilometros");
            System.out.println("[2] Kilometros a Metros");
            System.out.println("[3] Metros a Millas");
            System.out.println("[4] Millas a Metros");
            System.out.println("[5] Centimetros a Pulgadas");
            System.out.println("[6] Pulgadas a Centimetros");
            System.out.println("[7] Volver al menu principal");
            System.out.print("Opcion: ");
            eleccion = sc.nextInt();
            if (eleccion >= 7) {
                System.out.println("Volviendo al menu principal...");
                operacionValida = false;
                break;
            }
            System.out.print("Valor: ");
            conversion = sc.nextDouble();

            if (eleccion == 1) {
                System.out.println(conversion + " m = " + (conversion / 1000) + " km");
            } else if (eleccion == 2) {
                System.out.println(conversion + " km = " + (conversion * 1000) + " m");
            } else if (eleccion == 3) {
                System.out.println(conversion + " m = " + (conversion * 0.000621371) + " mi");
            } else if (eleccion == 4) {
                System.out.println(conversion + " mi = " + (conversion * 1609.34) + " m");
            } else if (eleccion == 5) {
                System.out.println(conversion + " cm = " + (conversion * 0.393701) + " in");
            } else if (eleccion == 6) {
                System.out.println(conversion + " in = " + (conversion * 2.54) + " cm");
            } else {
                System.out.println("Volviendo al menu principal...");
                operacionValida = false;
            }
            return conversion;
        }
        return conversion;
    }

    static double convertirPeso(Scanner sc, int eleccion, double conversion, boolean operacionValida) {
        while (operacionValida) {
            System.out.println("Conversion de peso:");
            System.out.println("[1] Kilogramos a Gramos");
            System.out.println("[2] Gramos a Kilogramos");
            System.out.println("[3] Kilogramos a Libras");
            System.out.println("[4] Libras a Kilogramos");
            System.out.println("[5] Gramos a Onzas");
            System.out.println("[6] Onzas a Gramos");
            System.out.println("[7] Volver al menu principal");
            System.out.print("Opcion: ");
            eleccion = sc.nextInt();
            if (eleccion >= 7) {
                System.out.println("Volviendo al menu principal...");
                operacionValida = false;
                break;
            }
            System.out.print("Valor: ");
            conversion = sc.nextDouble();

            if (eleccion == 1) {
                System.out.println(conversion + " kg = " + (conversion * 1000) + " g");
            } else if (eleccion == 2) {
                System.out.println(conversion + " g = " + (conversion / 1000) + " kg");
            } else if (eleccion == 3) {
                System.out.println(conversion + " kg = " + (conversion * 2.20462) + " lb");
            } else if (eleccion == 4) {
                System.out.println(conversion + " lb = " + (conversion * 0.453592) + " kg");
            } else if (eleccion == 5) {
                System.out.println(conversion + " g = " + (conversion * 0.035274) + " oz");
            } else if (eleccion == 6) {
                System.out.println(conversion + " oz = " + (conversion * 28.3495) + " g");
            } else {
                System.out.println("volviendo al menu principal...");
                operacionValida = false;
            }
            return conversion;
        }
        return conversion;

    }
    static double convertirTemperatura(Scanner sc, int eleccion, double conversion, boolean operacionValida) {
        while (operacionValida) {
            System.out.println("Conversion de temperatura:");
            System.out.println("[1] Celsius a Fahrenheit");
            System.out.println("[2] Fahrenheit a Celsius");
            System.out.println("[3] Celsius a Kelvin");
            System.out.println("[4] Kelvin a Celsius");
            System.out.println("[5] Volver al menu principal");
            System.out.print("Opcion: ");
            eleccion = sc.nextInt();
            if (eleccion >= 5) {
                System.out.println("Volviendo al menu principal...");
                operacionValida = false;
                break;
            }
            System.out.print("Valor: ");
            conversion = sc.nextDouble();

            if (eleccion == 1) {
                System.out.println(conversion + " C = " + (conversion * 9 / 5 + 32) + " F");
            } else if (eleccion == 2) {
                System.out.println(conversion + " F = " + ((conversion - 32) * 5 / 9) + " C");
            } else if (eleccion == 3) {
                System.out.println(conversion + " C = " + (conversion + 273.15) + " K");
            } else if (eleccion == 4) {
                System.out.println(conversion + " K = " + (conversion - 273.15) + " C");
            } else {
                System.out.println("volviendo al menu principal...");
                operacionValida = false;
            }
            return conversion;
        }
        return conversion;
    }

}
