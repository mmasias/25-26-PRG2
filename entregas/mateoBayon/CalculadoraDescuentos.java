import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sistemaActivo = true;

        System.out.println("Calculadora de Descuentos - Tienda Online");

        while (sistemaActivo == true) {
            System.out.println("[1] Realizar Nueva Compra");
            System.out.println("[2] Salir");
            System.out.print("Opcion: ");
            int menuOpt = scanner.nextInt();
            scanner.nextLine(); 

            if (menuOpt == 2) {
                System.out.println("Saliendo del sistema.");
                sistemaActivo = false;
            }
            else if (menuOpt != 1) {
                System.out.println("Opcion no valida.");
            }
            
            String[] nombresProductos = new String[10];
            double[] preciosProductos = new double[10];
            int[] cants_p = new int[10];
            int numeroProductos = 0;

            System.out.println("Carrito de Compra");
            while(numeroProductos < 10) {
                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = scanner.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                nombresProductos[numeroProductos] = nombre;
                
                System.out.print("Precio de '" + nombre + "': ");
                preciosProductos[numeroProductos] = scanner.nextDouble();
                
                System.out.print("Cantidad de '" + nombre + "': ");
                cants_p[numeroProductos] = scanner.nextInt();
                scanner.nextLine(); 

                numeroProductos++;
            }

            if(numeroProductos == 0){
                System.out.println("Carrito vacio, no se puede calcular el descuento.");
                continue;
            }

            double precioTotal = 0;
            int cantidadTotal = 0;
            for(int i=0; i < numeroProductos; i++) {
                precioTotal += preciosProductos[i] * cants_p[i];
                cantidadTotal += cants_p[i];
            }

            System.out.println("Configuracion del Descuento");
            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            int t = scanner.nextInt();

            System.out.print("Es temporada de rebajas? (s/n): ");
            char r = scanner.next().charAt(0);
            
            double precioFinal = precioTotal;

            if (t == 1) { 
                if (r == 's') { precioFinal = precioFinal - (precioFinal * 0.10); }
                if (cantidadTotal >= 5) { precioFinal = precioFinal - (precioFinal * 0.05); }
            } else if (t == 2) { 
                precioFinal = precioFinal - (precioFinal * 0.15);
                if (r == 's') { precioFinal = precioFinal - (precioFinal * 0.10); }
                if (cantidadTotal >= 3) { precioFinal = precioFinal - (precioFinal * 0.08); }
            } else if (t == 3) { 
                precioFinal = precioFinal - (precioFinal * 0.20);
                if (r == 's') { precioFinal = precioFinal - (precioFinal * 0.15); }
                if (cantidadTotal >= 2) { precioFinal = precioFinal - (precioFinal * 0.10); }
            } else if (t == 4) { 
                precioFinal = precioFinal - (precioFinal * 0.30);
                if (r == 's') { precioFinal = precioFinal - (precioFinal * 0.20); }
                if (cantidadTotal >= 1) { precioFinal = precioFinal - (precioFinal * 0.15); }
            }

            if (precioFinal > 500) {
                precioFinal = precioFinal - 50;
            }

            System.out.println("Resumen de Compra");
            System.out.println("Precio original total: " + precioTotal + " euros");
            System.out.println("Numero total de productos: " + cantidadTotal);
            System.out.println("Precio final con descuento: " + precioFinal + " euros");
            System.out.println("Ahorro total: " + (precioTotal - precioFinal) + " euros");
            if (precioTotal > 0) {
                double porcentaje = ((precioTotal - precioFinal) / precioTotal) * 100;
                System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
            }
        }
        scanner.close();
    }
}
