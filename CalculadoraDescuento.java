import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculadoraDescuentos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 2) break;
            if (opcion != 1) continue;

            List<Producto> carrito = leerCarrito(scanner);

            if (carrito.isEmpty()) {
                System.out.println("Carrito vacio, no se puede calcular el descuento.");
                continue;
            }

            int tipoCliente = leerTipoCliente(scanner);
            boolean rebajas = leerRebajas(scanner);

            double totalOriginal = calcularTotal(carrito);
            int totalCantidad = calcularCantidad(carrito);
            double totalFinal = calcularPrecioFinal(totalOriginal, totalCantidad, tipoCliente, rebajas);

            mostrarResumen(totalOriginal, totalFinal, totalCantidad);
        }

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println("Calculadora de Descuentos - Tienda Online");
        System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
    }

    static List<Producto> leerCarrito(Scanner scanner) {
        List<Producto> carrito = new ArrayList<>();

        while (true) {
            System.out.print("Nombre del producto (o 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;

            System.out.print("Precio de '" + nombre + "': ");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad de '" + nombre + "': ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            carrito.add(new Producto(nombre, precio, cantidad));
        }

        return carrito;
    }

    static int leerTipoCliente(Scanner scanner) {
        System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
        return scanner.nextInt();
    }

    static boolean leerRebajas(Scanner scanner) {
        System.out.print("Es temporada de rebajas? (s/n): ");
        return scanner.next().equalsIgnoreCase("s");
    }

    static double calcularTotal(List<Producto> carrito) {
        return carrito.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
    }

    static int calcularCantidad(List<Producto> carrito) {
        return carrito.stream()
                .mapToInt(Producto::getCantidad)
                .sum();
    }

    static double calcularPrecioFinal(double total, int cantidad, int tipoCliente, boolean rebajas) {
        double descuento = obtenerDescuentoBase(tipoCliente);

        if (rebajas) {
            descuento += obtenerDescuentoRebajas(tipoCliente);
        }

        descuento += obtenerDescuentoPorCantidad(tipoCliente, cantidad);

        double resultado = total * (1 - descuento);

        if (resultado > 500) {
            resultado -= 50;
        }

        return resultado;
    }

    static double obtenerDescuentoBase(int tipoCliente) {
        switch (tipoCliente) {
            case 2: return 0.15;
            case 3: return 0.20;
            case 4: return 0.30;
            default: return 0.0;
        }
    }

    static double obtenerDescuentoRebajas(int tipoCliente) {
        switch (tipoCliente) {
            case 1: return 0.10;
            case 2: return 0.10;
            case 3: return 0.15;
            case 4: return 0.20;
            default: return 0.0;
        }
    }

    static double obtenerDescuentoPorCantidad(int tipoCliente, int cantidad) {
        switch (tipoCliente) {
            case 1: return cantidad >= 5 ? 0.05 : 0.0;
            case 2: return cantidad >= 3 ? 0.08 : 0.0;
            case 3: return cantidad >= 2 ? 0.10 : 0.0;
            case 4: return cantidad >= 1 ? 0.15 : 0.0;
            default: return 0.0;
        }
    }

    static void mostrarResumen(double original, double finalPrecio, int cantidad) {
        System.out.println("Resumen de Compra");
        System.out.println("Precio original total: " + original + " euros");
        System.out.println("Numero total de productos: " + cantidad);
        System.out.println("Precio final con descuento: " + finalPrecio + " euros");
        System.out.println("Ahorro total: " + (original - finalPrecio) + " euros");

        if (original > 0) {
            System.out.println("Porcentaje de ahorro: " + ((original - finalPrecio) / original * 100) + "%");
        }
    }
}

class Producto {
    private final String nombre;
    private final double precio;
    private final int cantidad;

    Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    double getPrecio() {
        return precio;
    }

    int getCantidad() {
        return cantidad;
    }
}
