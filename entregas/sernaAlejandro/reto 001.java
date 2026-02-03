
           import java.util.ArrayList;
import java.util.Scanner;

public class CalculadoraDescuentos {

    enum TipoCliente {
        NORMAL, ESTUDIANTE, JUBILADO, VIP
    }

    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        double subtotal() {
            return precio * cantidad;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

        while (true) {
            System.out.println("[1] Realizar Nueva Compra");
            System.out.println("[2] Salir");
            System.out.print("Opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 2) break;
            if (opcion != 1) {
                System.out.println("Opcion no valida.");
                continue;
            }

            ArrayList<Producto> carrito = cargarCarrito(scanner);

            if (carrito.isEmpty()) {
                System.out.println("Carrito vacio.");
                continue;
            }

            double precioTotal = carrito.stream().mapToDouble(Producto::subtotal).sum();
            int cantidadTotal = carrito.stream().mapToInt(p -> p.cantidad).sum();

            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            TipoCliente tipoCliente = TipoCliente.values()[scanner.nextInt() - 1];

            System.out.print("Es temporada de rebajas? (s/n): ");
            boolean rebaja = scanner.next().equalsIgnoreCase("s");

            double precioFinal = calcularPrecioFinal(precioTotal, cantidadTotal, tipoCliente, rebaja);

            mostrarResumen(precioTotal, precioFinal, cantidadTotal);
        }

        scanner.close();
    }

    private static ArrayList<Producto> cargarCarrito(Scanner scanner) {
        ArrayList<Producto> carrito = new ArrayList<>();

        while (true) {
            System.out.print("Nombre del producto (o 'fin'): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            System.out.print("Precio: ");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            carrito.add(new Producto(nombre, precio, cantidad));
        }
        return carrito;
    }

    private static double calcularPrecioFinal(double precio, int cantidad, TipoCliente tipo, boolean rebaja) {
        double resultado = precio;

        switch (tipo) {
            case NORMAL -> {
                if (rebaja) resultado *= 0.90;
                if (cantidad >= 5) resultado *= 0.95;
            }
            case ESTUDIANTE -> {
                resultado *= 0.85;
                if (rebaja) resultado *= 0.90;
                if (cantidad >= 3) resultado *= 0.92;
            }
            case JUBILADO -> {
                resultado *= 0.80;
                if (rebaja) resultado *= 0.85;
                if (cantidad >= 2) resultado *= 0.90;
            }
            case VIP -> {
                resultado *= 0.70;
                if (rebaja) resultado *= 0.80;
                resultado *= 0.85;
            }
        }

        if (resultado > 500) resultado -= 50;
        return resultado;
    }

    private static void mostrarResumen(double original, double finalPrecio, int cantidad) {
        System.out.println("Resumen de Compra");
        System.out.println("Precio original: " + original);
        System.out.println("Cantidad total: " + cantidad);
        System.out.println("Precio final: " + finalPrecio);
        System.out.println("Ahorro: " + (original - finalPrecio));
    }
}
