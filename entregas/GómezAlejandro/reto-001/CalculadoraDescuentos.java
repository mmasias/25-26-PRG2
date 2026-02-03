import java.util.Scanner;

public class CalculadoraDescuentos {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] precios = new double[10];
        int[] cantidades = new int[10];
        int numProductos = 0;

        while (numProductos < 10) {
            System.out.print("Precio: ");
            precios[numProductos] = sc.nextDouble();
            System.out.print("Cantidad: ");
            cantidades[numProductos] = sc.nextInt();
            sc.nextLine();
            numProductos++;
        }

        double precioTotal = calcularPrecioTotal(precios, cantidades, numProductos);
        int cantidadTotal = calcularCantidadTotal(cantidades, numProductos);

        System.out.println("Precio total: " + precioTotal);
        System.out.println("Cantidad total: " + cantidadTotal);

        sc.close();
    }
}
