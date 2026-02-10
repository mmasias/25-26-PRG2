package ejercicios.conversor;

import java.util.Scanner;

class ConversorUnidades {
     public static void main(String[] args) {

        boolean salirPrograma = false;
        int opcionElegida;

        while (salirPrograma == false) {

            opcionElegida = mostrarMenuPrincipal();

            if (opcionElegida == 4) {
                System.out.println("Gracias por usar el conversor de unidades");
                salirPrograma = true;
            } else {
                System.out.println("Opción no válida");
            }
        }
        static int mostrarMenuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("1 - Conversión de longitud");
        System.out.println("2 - Conversión de peso");
        System.out.println("3 - Conversión de temperatura");
        System.out.println("4 - Salir");
        System.out.println("-----------------------------------");
        System.out.println("Seleccione una opción:");
        return entrada.nextInt();
        }
        private static void convertirLongitud() {
        Scanner entrada = new Scanner(System.in);

        String[] opciones = {
            "Metros a Kilómetros",
            "Kilómetros a Metros",
            "Metros a Millas",
            "Millas a Metros",
            "Centímetros a Pulgadas",
            "Pulgadas a Centímetros"
        };

        double[] factores = {
            1.0 / 1000,
            1000,
            0.000621371,
            1609.34,
            0.393701,
            2.54
        };

        System.out.println("Conversión de longitud");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + " - " + opciones[i]);
        }

        int opcion = entrada.nextInt();
        System.out.println("Introduzca el valor:");
        double valor = entrada.nextDouble();

        if (opcion >= 1 && opcion <= opciones.length) {
            System.out.println("Resultado: " + (valor * factores[opcion - 1]));
        } else {
            System.out.println("Opción no válida");
        }
        }
     }
}


