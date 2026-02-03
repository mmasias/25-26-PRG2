import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Conversor de Unidades - Version 2.1");

        int tipo = 0;
        while (true) {
            System.out.println("[1] Longitud");
            System.out.println("[2] Peso");
            System.out.println("[3] Temperatura");
            System.out.print("Tipo de conversion: ");
            tipo = sc.nextInt();
            if (tipo >= 1 && tipo <= 3) {
                break;
            } else {
                System.out.println("Tipo no valido. Intenta de nuevo.");
            }
        }

        String[] menuOpciones;

        if (tipo == 1) {
            System.out.println("Conversion de longitud:");
            menuOpciones = new String[]{
                "[1] Metros a Kilometros",
                "[2] Kilometros a Metros",
                "[3] Metros a Millas",
                "[4] Millas a Metros",
                "[5] Centimetros a Pulgadas",
                "[6] Pulgadas a Centimetros"
            };
        } else if (tipo == 2) {
            System.out.println("Conversion de peso:");
            menuOpciones = new String[]{
                "[1] Kilogramos a Gramos",
                "[2] Gramos a Kilogramos",
                "[3] Kilogramos a Libras",
                "[4] Libras a Kilogramos",
                "[5] Gramos a Onzas",
                "[6] Onzas a Gramos"
            };
        } else {
            System.out.println("Conversion de temperatura:");
            menuOpciones = new String[]{
                "[1] Celsius a Fahrenheit",
                "[2] Fahrenheit a Celsius",
                "[3] Celsius a Kelvin",
                "[4] Kelvin a Celsius"
            };
        }

        for (String opcionTexto : menuOpciones) {
            System.out.println(opcionTexto);
        }

        int opcion = 0;
        int maxOpcion = menuOpciones.length;
        while (true) {
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            if (opcion >= 1 && opcion <= maxOpcion) {
                break;
            } else {
                System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        }

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
            } else {
                System.out.println(valor + " in = " + (valor * 2.54) + " cm");
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
            } else {
                System.out.println(valor + " oz = " + (valor * 28.3495) + " g");
            }
        } else {
            if (opcion == 1) {
                System.out.println(valor + " C = " + (valor * 9 / 5 + 32) + " F");
            } else if (opcion == 2) {
                System.out.println(valor + " F = " + ((valor - 32) * 5 / 9) + " C");
            } else if (opcion == 3) {
                System.out.println(valor + " C = " + (valor + 273.15) + " K");
            } else {
                System.out.println(valor + " K = " + (valor - 273.15) + " C");
            }
        }
    }
}
