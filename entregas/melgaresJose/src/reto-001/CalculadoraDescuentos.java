import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");
		int menuOpt = 1;
        while (menuOpt != 2) {
            imprimirMenu();
            int menuOpt = scanner.nextInt();
			
            if (menuOpt != 1) {
                System.out.println("Opcion no valida.");
                continue;
            }
            
            // Carrito de compra y precios
            String[] productosEnCarrito = new String[10];
            double[] preciosEnCarrito = new double[10];
            int[] cantidadesPorProducto = new int[10];
            int cantidadProductos = hacerLaCompra(productosEnCarrito, preciosEnCarrito, cantidadesPorProducto)
			
            

            if(cantidadProductos == 0){
                System.out.println("Carrito vacio, no se puede calcular el descuento.");
                continue;
            }

            // Calcular total del carrito
            double precioTotal = 0;
            int cantidadTotalProductos = 0;
            for(int i=0; i < cantidadProductos; i++) {
                precioTotal += preciosEnCarrito[i] * cantidadesPorProducto[i];
                cantidadTotalProductos += cantidadesPorProducto[i];
            }

            System.out.println("Configuracion del Descuento");
            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            int tipoCliente = scanner.nextInt();

            System.out.print("Es temporada de rebajas? (s/n): ");
            boolean hayRebajas = scanner.next().charAt(0) == 's';
            
            double precioFinal = precioTotal * calcularDescuento(cantidadTotalProductos, tipoCliente, hayRebajas);
			

            if (precioFinal > 500) {
                precioFinal = precioFinal - 50;
            }

            System.out.println("Resumen de Compra");
            System.out.println("Precio original total: " + precioTotal + " euros");
            System.out.println("Numero total de productos: " + cantidadTotalProductos);
            System.out.println("Precio final con descuento: " + precioFinal + " euros");
            System.out.println("Ahorro total: " + (precioTotal - precioFinal) + " euros");
            if (precioTotal > 0) {
                double porcentaje = ((precioTotal - precioFinal) / precioTotal) * 100;
                System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
            }
        }
		System.out.println("Saliendo del sistema.");
        scanner.close();
    }
	
	private void imprimirMenu() {
		System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
	}
	
	private static double calcularDescuento(int cantidadTotalProductos, int tipoCliente, boolean hayRebajas) {
		double descuento = 1;
		
		if (tipoCliente == 1) {
			descuento = hayRebajas ? descuento : 0.9;
		}
		else if (tipoCliente == 2) {
			descuento = hayRebajas ? 0.9*0.85 : 0.85 ;
		}
		else if (tipoCliente == 3) {
			descuento = hayRebajas ? 0.8*0.85 : 0.8;
		}
		else if (tipoCliente == 4) {
			descuento = hayRebajas ? 0.7*0.8: 0.7;
		}
		
		return descuento;
	}
	
	private int hacerLaCompra(String[] productosEnCarrito, double[] preciosEnCarrito, int[] cantidadesPorProducto ) {
		int cantidadProductos = 0;
		System.out.println("Carrito de Compra");
		string nombre = "";
        while(cantidadProductos < 10 && !nombre.equalsIgnoreCase("fin")) {
            System.out.print("Nombre del producto (o 'fin' para terminar): ");
            nombre = scanner.nextLine();	
            productosEnCarrito[cantidadProductos] = nombre;
            
            System.out.print("Precio de '" + nombre + "': ");
            preciosEnCarrito[cantidadProductos] = scanner.nextDouble();
            
            System.out.print("Cantidad de '" + nombre + "': ");
            cantidadesPorProducto[cantidadProductos] = scanner.nextInt();
            scanner.nextLine(); 

            cantidadProductos++;
        }
		return cantidadProductos;
	}
}