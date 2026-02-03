import java.util.Scanner;

public class ConversorUnidades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("[1] Longitud\n[2] Peso\n[3] Temperatura");
        System.out.print("Tipo de conversion: ");
        int tipo = sc.nextInt();
    
         switch (tipo) {
            case 1:
                System.out.println("Conversion de longitud:");
                System.out.println("[1] M a Km\n[2] Km a M\n[3] M a Mi\n[4] Mi a M\n[5] Cm a In\n[6] In a Cm");
                procesarConversion(sc, 1);
                break;
            case 2:
                System.out.println("Conversion de peso:");
                System.out.println("[1] Kg a G\n[2] G a Kg\n[3] Kg a Lb\n[4] Lb a Kg\n[5] G a Oz\n[6] Oz a G");
                procesarConversion(sc, 2);
                break;
            case 3:
                System.out.println("Conversion de temperatura:");
                System.out.println("[1] C a F\n[2] F a C\n[3] C a K\n[4] K a C");
                procesarConversion(sc, 3);
                break;
            default:
                System.out.println("Tipo no valido");
        }
    }

    private static void procesarConversion(Scanner sc, int tipo) {
        System.out.print("Opcion: ");
        int o = sc.nextInt();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

            if (tipo == 1) {
            if (o == 1) System.out.println(v + " m = " + (v / 1000) + " km");
            else if (o == 2) System.out.println(v + " km = " + (v * 1000) + " m");
            else if (o == 3) System.out.println(v + " m = " + (v * 0.000621371) + " mi");
            else if (o == 4) System.out.println(v + " mi = " + (v * 1609.34) + " m");
            else if (o == 5) System.out.println(v + " cm = " + (v * 0.393701) + " in");
            else if (o == 6) System.out.println(v + " in = " + (v * 2.54) + " cm");
        } 
        } 
        
    }

