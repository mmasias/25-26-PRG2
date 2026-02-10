import java.util.Scanner;

public class CalculadoraDescuentos {

    static final int MAX_PRODUCTOS = 10;

    static double calcularPrecioTotal(double[] precios, int[] cantidades, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += precios[i] * cantidades[i];
        }
        return total;
    }

    static int calcularCantidadTotal(int[] cantidades, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cantidades[i];
        }
        return total;
    }

    static double aplicarDescuentos(double precio, int tipo, char rebajas, int cantidad) {
        double finalPrecio = precio;

        if (tipo == 1) {
            if (rebajas == 's') finalPrecio -= finalPrecio * 0.10;
            if (cantidad >= 5) finalPrecio -= finalPrecio * 0.05;
        } else if (tipo == 2) {
            finalPrecio -= finalPrecio * 0.15;
            if (rebajas == 's') finalPrecio -= finalPrecio * 0.10;
            if (cantidad >= 3) finalPrecio -= finalPrecio * 0.08;
        } else if (tipo == 3) {
            finalPrecio -= finalPrecio * 0.20;
            if (rebajas == 's') finalPrecio -= finalPrecio * 0.15;
            if (cantidad >= 2) finalPrecio -= finalPrecio * 0.10;
        } else if (tipo == 4) {
            finalPrecio -= finalPrecio * 0.30;
            if (rebajas == 's') finalPrecio -= finalPrecio * 0.20;
            if (cantidad >= 1) finalPrecio -= finalPrecio * 0.15;
        }

        if (finalPrecio > 500) finalPrecio -= 50;

        return finalPrecio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] precios = new double[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];
        int numProductos = 0;

        while (numProductos < MAX_PRODUCTOS) {
            System.out.print("Precio: ");
            precios[numProductos] = sc.nextDouble();
            System.out.print("Cantidad: ");
            cantidades[numProductos] = sc.nextInt();
            sc.nextLine();
            numProductos++;
        }

        double precioTotal = calcularPrecioTotal(precios, cantidades, numProductos);
        int cantidadTotal = calcularCantidadTotal(cantidades, numProductos);

        System.out.print("Tipo cliente: ");
        int tipo = sc.nextInt();
        System.out.print("Rebajas (s/n): ");
        char rebajas = sc.next().charAt(0);

        double precioFinal = aplicarDescuentos(precioTotal, tipo, rebajas, cantidadTotal);

        System.out.println("Precio final: " + precioFinal);

        sc.close();
    }
}
