import java.util.Scanner;

public class ConversorUnidades {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
        sc.close();
    }

    static void menuPrincipal() {
        System.out.println("Conversor de Unidades - Version 2.1");
        System.out.println("Opciones: longitud, peso, temperatura");
        System.out.print("Tipo de conversion: ");

        String tipo = sc.next().toLowerCase();

        if (tipo.equals("longitud")) {
            convertirLongitud();
        } else if (tipo.equals("peso")) {
            convertirPeso();
        } else if (tipo.equals("temperatura")) {
            convertirTemperatura();
        } else {
            System.out.println("Tipo no valido");
        }
    }

    static void convertirLongitud() {
        System.out.println("Conversion de longitud:");
        System.out.println("Opciones:");
        System.out.println("metros_kilometros");
        System.out.println("kilometros_metros");
        System.out.println("metros_millas");
        System.out.println("millas_metros");
        System.out.println("centimetros_pulgadas");
        System.out.println("pulgadas_centimetros");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (opcion.equals("metros_kilometros")) {
            System.out.println(v + " m = " + (v / 1000) + " km");
        } else if (opcion.equals("kilometros_metros")) {
            System.out.println(v + " km = " + (v * 1000) + " m");
        } else if (opcion.equals("metros_millas")) {
            System.out.println(v + " m = " + (v * 0.000621371) + " mi");
        } else if (opcion.equals("millas_metros")) {
            System.out.println(v + " mi = " + (v * 1609.34) + " m");
        } else if (opcion.equals("centimetros_pulgadas")) {
            System.out.println(v + " cm = " + (v * 0.393701) + " in");
        } else if (opcion.equals("pulgadas_centimetros")) {
            System.out.println(v + " in = " + (v * 2.54) + " cm");
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void convertirPeso() {
        System.out.println("Conversion de peso:");
        System.out.println("Opciones:");
        System.out.println("kg_g");
        System.out.println("g_kg");
        System.out.println("kg_lb");
        System.out.println("lb_kg");
        System.out.println("g_oz");
        System.out.println("oz_g");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (opcion.equals("kg_g")) {
            System.out.println(v + " kg = " + (v * 1000) + " g");
        } else if (opcion.equals("g_kg")) {
            System.out.println(v + " g = " + (v / 1000) + " kg");
        } else if (opcion.equals("kg_lb")) {
            System.out.println(v + " kg = " + (v * 2.20462) + " lb");
        } else if (opcion.equals("lb_kg")) {
            System.out.println(v + " lb = " + (v * 0.453592) + " kg");
        } else if (opcion.equals("g_oz")) {
            System.out.println(v + " g = " + (v * 0.035274) + " oz");
        } else if (opcion.equals("oz_g")) {
            System.out.println(v + " oz = " + (v * 28.3495) + " g");
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void convertirTemperatura() {
        System.out.println("Conversion de temperatura:");
        System.out.println("Opciones:");
        System.out.println("c_f");
        System.out.println("f_c");
        System.out.println("c_k");
        System.out.println("k_c");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (opcion.equals("c_f")) {
            System.out.println(v + " C = " + (v * 9 / 5 + 32) + " F");
        } else if (opcion.equals("f_c")) {
            System.out.println(v + " F = " + ((v - 32) * 5 / 9) + " C");
        } else if (opcion.equals("c_k")) {
            System.out.println(v + " C = " + (v + 273.15) + " K");
        } else if (opcion.equals("k_c")) {
            System.out.println(v + " K = " + (v - 273.15) + " C");
        } else {
            System.out.println("Opcion no valida");
        }
    }
}