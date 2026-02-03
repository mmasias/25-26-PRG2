import java.util.Scanner;

public class CalculadoraDescuentos {
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
            String[] nombres_p = new String[10];
            double[] precios_p = new double[10];
            int[] cants_p = new int[10];
            int n_prods = 0;

            System.out.println("Carrito de Compra");
            while(n_prods < 10) {
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
            double p_total = 0;
            int c_total = 0;
            for(int i=0; i < n_prods; i++) {
                p_total += precios_p[i] * cants_p[i];
                c_total += cants_p[i];
            }

            System.out.println("Configuracion del Descuento");
            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            int t = sc.nextInt();

            System.out.print("Es temporada de rebajas? (s/n): ");
            char r = sc.next().charAt(0);
            
            double pf = p_total;

            if (t == 1) { // Normal
                if (r == 's') { pf = pf - (pf * 0.10); }
                if (c_total >= 5) { pf = pf - (pf * 0.05); }
            } else if (t == 2) { // Estudiante
                pf = pf - (pf * 0.15);
                if (r == 's') { pf = pf - (pf * 0.10); }
                if (c_total >= 3) { pf = pf - (pf * 0.08); }
            } else if (t == 3) { // Jubilado
                pf = pf - (pf * 0.20);
                if (r == 's') { pf = pf - (pf * 0.15); }
                if (c_total >= 2) { pf = pf - (pf * 0.10); }
            } else if (t == 4) { // VIP
                pf = pf - (pf * 0.30);
                if (r == 's') { pf = pf - (pf * 0.20); }
                if (c_total >= 1) { pf = pf - (pf * 0.15); }
            }

            if (pf > 500) {
                pf = pf - 50;
            }

            System.out.println("Resumen de Compra");
            System.out.println("Precio original total: " + p_total + " euros");
            System.out.println("Numero total de productos: " + c_total);
            System.out.println("Precio final con descuento: " + pf + " euros");
            System.out.println("Ahorro total: " + (p_total - pf) + " euros");
            if (p_total > 0) {
                double porcentaje = ((p_total - pf) / p_total) * 100;
                System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
            }
        }
        sc.close();
    }
}