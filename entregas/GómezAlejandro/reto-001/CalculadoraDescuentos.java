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

        System.out.println(
            calcularPrecioTotal(precios, cantidades, numProductos)
        );

        sc.close();
    }
}
