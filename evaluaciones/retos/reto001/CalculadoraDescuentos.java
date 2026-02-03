import java.util.Scanner;

public class CalculadoraDescuentos {

    static final int MAX_PROD = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

        while (true) {
            System.out.println("[1] Realizar Nueva Compra");
            System.out.println("[2] Salir");
            System.out.print("Opcion: ");
            int menuOpt = sc.nextInt();
            sc.nextLine(); 

            if (menuOpt == 2) {
                System.out.println("Saliendo del sistema.");
                break;
            }
            if (menuOpt != 1) {
                System.out.println("Opcion no valida.");
                continue;
            }
            
            // Carrito de compra y precios
            String[] nombres_p = new String[MAX_PROD];
            double[] precios_p = new double[MAX_PROD];
            int[] cants_p = new int[MAX_PROD];
            int n_prods = 0;

            System.out.println("Carrito de Compra");
            while(n_prods < MAX_PROD) {
                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                nombres_p[n_prods] = nombre;
                
                System.out.print("Precio de '" + nombre + "': ");
                precios_p[n_prods] = sc.nextDouble();
                
                System.out.print("Cantidad de '" + nombre + "': ");
                cants_p[n_prods] = sc.nextInt();
                sc.nextLine(); 

                n_prods++;
            }

            if(n_prods == 0){
                System.out.println("Carrito vacio, no se puede calcular el descuento.");
                continue;
            }

            // Calcular total del carrito
            double p_total = calcularTotal(precios_p, cants_p, n_prods);
            int c_total = calcularCantidad(cants_p, n_prods);

            System.out.println("Configuracion del Descuento");
            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            int t = sc.nextInt();

            System.out.print("Es temporada de rebajas? (s/n): ");
            char r = sc.next().charAt(0);
            
            double pf = aplicarDescuentos(p_total, c_total, t, r);

            mostrarResumen(p_total, c_total, pf);

            
        }
        sc.close();
    }

    static double calcularTotal(double[] precios, int[] cantidades, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += precios[i] * cantidades[i];
        }
        return total;
    }

    static int calcularCantidad(int[] cantidades, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cantidades[i];
        }
        return total;
    }

    static double aplicarDescuentos(double total, int cant, int tipo, char rebajas) {
        double pf = total;

        if (tipo == 1) {
            if (rebajas == 's') pf -= pf * 0.10;
            if (cant >= 5) pf -= pf * 0.05;
        } 
        else if (tipo == 2) {
            pf -= pf * 0.15;
            if (rebajas == 's') pf -= pf * 0.10;
            if (cant >= 3) pf -= pf * 0.08;
        } 
        else if (tipo == 3) {
            pf -= pf * 0.20;
            if (rebajas == 's') pf -= pf * 0.15;
            if (cant >= 2) pf -= pf * 0.10;
        } 
        else if (tipo == 4) {
            pf -= pf * 0.30;
            if (rebajas == 's') pf -= pf * 0.20;
            if (cant >= 1) pf -= pf * 0.15;
        }

        if (pf > 500) {
            pf -= 50;
        }

        return pf;
    }

    static void mostrarResumen(double total, int cant, double finalP) {
        System.out.println("\nResumen de Compra");
        System.out.println("Total original: " + total);
        System.out.println("Cantidad productos: " + cant);
        System.out.println("Precio final: " + finalP);
        System.out.println("Ahorro: " + (total - finalP));
    }
}
