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
    }
}


