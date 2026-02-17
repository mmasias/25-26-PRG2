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
            
            String[] nombresP = new String[10];
            double[] preciosP = new double[10];
            int[] cantsP = new int[10];
            int nProds = 0;

            System.out.println("Carrito de Compra");
            while(nProds < 10) {
                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                nombresP[nProds] = nombre;
                
                System.out.print("Precio de '" + nombre + "': ");
                preciosP[nProds] = sc.nextDouble();
                
                System.out.print("Cantidad de '" + nombre + "': ");
                cantsP[nProds] = sc.nextInt();
                sc.nextLine(); 

                nProds++;
            }

            if(nProds == 0){
                System.out.println("Carrito vacio, no se puede calcular el descuento.");
                continue;
            }
            
            double pTotal = 0;
            int cTotal = 0;
            for(int i=0; i < nProds; i++) {
                pTotal += preciosP[i] * cantsP[i];
                cTotal += cantsP[i];
            }

            System.out.println("Configuracion del Descuento");
            System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
            int t = sc.nextInt();

            System.out.print("Es temporada de rebajas? (s/n): ");
            char r = sc.next().charAt(0);
            
            double pf = pTotal;

            if (t == 1) { 
                if (r == 's') { pf = pf - (pf * 0.10); }
                if (cTotal >= 5) { pf = pf - (pf * 0.05); }
            } else if (t == 2) { 
                pf = pf - (pf * 0.15);
                if (r == 's') { pf = pf - (pf * 0.10); }
                if (cTotal >= 3) { pf = pf - (pf * 0.08); }
            } else if (t == 3) { 
                pf = pf - (pf * 0.20);
                if (r == 's') { pf = pf - (pf * 0.15); }
                if (cTotal >= 2) { pf = pf - (pf * 0.10); }
            } else if (t == 4) { 
                pf = pf - (pf * 0.30);
                if (r == 's') { pf = pf - (pf * 0.20); }
                if (cTotal >= 1) { pf = pf - (pf * 0.15); }
            }

            if (pf > 500) {
                pf = pf - 50;
            }

            System.out.println("Resumen de Compra");
            System.out.println("Precio original total: " + pTotal + " euros");
            System.out.println("Numero total de productos: " + cTotal);
            System.out.println("Precio final con descuento: " + pf + " euros");
            System.out.println("Ahorro total: " + (pTotal - pf) + " euros");
            if (pTotal > 0) {
                double porcentaje = ((pTotal - pf) / pTotal) * 100;
                System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
            }
        }
        sc.close();
    }
}
