 Updated upstream:entregas/villedaAbner/src/CalculadoraDescuentos.java
import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

        if (DesplegarMenu() == 2) {
            System.out.println("Saliendo del sistema.");
        } else {
            while (true) {

                String[] NombresDeProductos = new String[10];
                double[] PreciosDeProductos = new double[10];
                int[] CantidadDeProductos = new int[10];
                int NumeroDeProductos = 0;

                System.out.println("Carrito de Compra");

                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                NombresDeProductos[NumeroDeProductos] = nombre;

                System.out.print("Precio de '" + nombre + "': ");
                PreciosDeProductos[NumeroDeProductos] = sc.nextDouble();

                System.out.print("Cantidad de '" + nombre + "': ");
                CantidadDeProductos[NumeroDeProductos] = sc.nextInt();
                sc.nextLine();

                NumeroDeProductos++;

                if (NumeroDeProductos == 0) {
                    System.out.println("Carrito vacio, no se puede calcular el descuento.");
                    continue;
                }
                double PrecioTotal = 0;
                int CantidadTotal = 0;
                for (int i = 0; i < NumeroDeProductos; i++) {
                    PrecioTotal += PreciosDeProductos[i] * CantidadDeProductos[i];
                    CantidadTotal += CantidadDeProductos[i];
                }

                
                

                System.out.println("Configuracion del Descuento");  
                System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
                int TipoCliente = sc.nextInt();

                System.out.print("Es temporada de rebajas? (s/n): ");
                char Rebaja = sc.next().charAt(0);

                double PrecioFinal = ValidarCliente(TipoCliente, Rebaja, PrecioTotal, CantidadTotal);

                

                System.out.println("Resumen de Compra");
                System.out.println("Precio original total: " + PrecioTotal + " euros");
                System.out.println("Numero total de productos: " + CantidadTotal);
                System.out.println("Precio final con descuento: " + PrecioFinal + " euros");
                System.out.println("Ahorro total: " + (PrecioTotal - PrecioFinal) + " euros");
                if (PrecioTotal > 0) {
                    double porcentaje = ((PrecioTotal - PrecioFinal) / PrecioTotal) * 100;
                    System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
                }
            }

        }
    }

    static int DesplegarMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
        int OpcionDeMenu = sc.nextInt();
        sc.nextLine();

        return OpcionDeMenu;

    }

    static double  ValidarCliente(int TipoCliente, char Rebaja, double PrecioFinal, int CantidadTotal){

        switch (TipoCliente) {
            
                    case 1:
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   if (CantidadTotal >= 5) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.05);
                        }   break;
                    case 2:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   if (CantidadTotal >= 3) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.08);
                        }   break;
                    case 3:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.20);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        }   if (CantidadTotal >= 2) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   break;
                    case 4:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.30);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.20);
                        }   if (CantidadTotal >= 1) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        }   break;
                    default:
                        break;
                }

                if (PrecioFinal > 500) {
                    PrecioFinal = PrecioFinal - 50;
                    
                }
         return PrecioFinal;       
    }

}
=======
import java.util.Scanner;

public class CalculadoraDescuentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de Descuentos - Tienda Online");

        if (DesplegarMenu() == 2) {
            System.out.println("Saliendo del sistema.");
        } else {
            while (true) {

                String[] NombresDeProductos = new String[10];
                double[] PreciosDeProductos = new double[10];
                int[] CantidadDeProductos = new int[10];
                int NumeroDeProductos = 0;

                System.out.println("Carrito de Compra");

                System.out.print("Nombre del producto (o 'fin' para terminar): ");
                String nombre = sc.nextLine();
                if (nombre.equalsIgnoreCase("fin")) {
                    break;
                }
                NombresDeProductos[NumeroDeProductos] = nombre;

                System.out.print("Precio de '" + nombre + "': ");
                PreciosDeProductos[NumeroDeProductos] = sc.nextDouble();

                System.out.print("Cantidad de '" + nombre + "': ");
                CantidadDeProductos[NumeroDeProductos] = sc.nextInt();
                sc.nextLine();

                NumeroDeProductos++;

                if (NumeroDeProductos == 0) {
                    System.out.println("Carrito vacio, no se puede calcular el descuento.");
                    continue;
                }
                double PrecioTotal = 0;
                int CantidadTotal = 0;
                for (int i = 0; i < NumeroDeProductos; i++) {
                    PrecioTotal += PreciosDeProductos[i] * CantidadDeProductos[i];
                    CantidadTotal += CantidadDeProductos[i];
                }

                
                

                System.out.println("Configuracion del Descuento");  
                System.out.print("Tipo de cliente (1=Normal, 2=Estudiante, 3=Jubilado, 4=VIP): ");
                int TipoCliente = sc.nextInt();

                System.out.print("Es temporada de rebajas? (s/n): ");
                char Rebaja = sc.next().charAt(0);

                double PrecioFinal = ValidarCliente(TipoCliente, Rebaja, PrecioTotal, CantidadTotal);

                

                System.out.println("Resumen de Compra");
                System.out.println("Precio original total: " + PrecioTotal + " euros");
                System.out.println("Numero total de productos: " + CantidadTotal);
                System.out.println("Precio final con descuento: " + PrecioFinal + " euros");
                System.out.println("Ahorro total: " + (PrecioTotal - PrecioFinal) + " euros");
                if (PrecioTotal > 0) {
                    double porcentaje = ((PrecioTotal - PrecioFinal) / PrecioTotal) * 100;
                    System.out.println("Porcentaje de ahorro: " + porcentaje + "%");
                }
            }

        }
    }

    static int DesplegarMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1] Realizar Nueva Compra");
        System.out.println("[2] Salir");
        System.out.print("Opcion: ");
        int OpcionDeMenu = sc.nextInt();
        sc.nextLine();

        return OpcionDeMenu;

    }

    static double  ValidarCliente(int TipoCliente, char Rebaja, double PrecioFinal, int CantidadTotal){

        switch (TipoCliente) {
            
                    case 1:
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   if (CantidadTotal >= 5) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.05);
                        }   break;
                    case 2:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   if (CantidadTotal >= 3) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.08);
                        }   break;
                    case 3:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.20);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        }   if (CantidadTotal >= 2) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.10);
                        }   break;
                    case 4:
                        PrecioFinal = PrecioFinal - (PrecioFinal * 0.30);
                        if (Rebaja == 's') {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.20);
                        }   if (CantidadTotal >= 1) {
                            PrecioFinal = PrecioFinal - (PrecioFinal * 0.15);
                        }   break;
                    default:
                        break;
                }

                if (PrecioFinal > 500) {
                    PrecioFinal = PrecioFinal - 50;
                    
                }
         return PrecioFinal;       
    }

}
>>>>>>> Stashed changes:evaluaciones/retos/reto001/CalculadoraDescuentos.java
