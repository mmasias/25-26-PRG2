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
            menuLongitud();
        } else if (tipo.equals("peso")) {
            menuPeso();
        } else if (tipo.equals("temperatura")) {
            menuTemperatura();
        } else {
            System.out.println("Tipo no valido");
        }
    }

    static void menuLongitud() {
        System.out.println("Conversion de longitud:");
        System.out.println("metros_kilometros");
        System.out.println("kilometros_metros");
        System.out.println("metros_millas");
        System.out.println("millas_metros");
        System.out.println("centimetros_pulgadas");
        System.out.println("pulgadas_centimetros");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        if (opcion.equals("metros_kilometros")) {
            metrosAKilometros(valor);
        } else if (opcion.equals("kilometros_metros")) {
            kilometrosAMetros(valor);
        } else if (opcion.equals("metros_millas")) {
            metrosAMillas(valor);
        } else if (opcion.equals("millas_metros")) {
            millasAMetros(valor);
        } else if (opcion.equals("centimetros_pulgadas")) {
            centimetrosAPulgadas(valor);
        } else if (opcion.equals("pulgadas_centimetros")) {
            pulgadasACentimetros(valor);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void metrosAKilometros(double valor) {
        System.out.println(valor + " m = " + (valor / 1000) + " km");
    }

    static void kilometrosAMetros(double valor) {
        System.out.println(valor + " km = " + (valor * 1000) + " m");
    }

    static void metrosAMillas(double valor) {
        System.out.println(valor + " m = " + (valor * 0.000621371) + " mi");
    }

    static void millasAMetros(double valor) {
        System.out.println(valor + " mi = " + (valor * 1609.34) + " m");
    }

    static void centimetrosAPulgadas(double valor) {
        System.out.println(valor + " cm = " + (valor * 0.393701) + " in");
    }

    static void pulgadasACentimetros(double valor) {
        System.out.println(valor + " in = " + (valor * 2.54) + " cm");
    }

    static void menuPeso() {
        System.out.println("Conversion de peso:");
        System.out.println("kg_g");
        System.out.println("g_kg");
        System.out.println("kg_lb");
        System.out.println("lb_kg");
        System.out.println("g_oz");
        System.out.println("oz_g");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        if (opcion.equals("kg_g")) {
            kgAG(valor);
        } else if (opcion.equals("g_kg")) {
            gAKg(valor);
        } else if (opcion.equals("kg_lb")) {
            kgALb(valor);
        } else if (opcion.equals("lb_kg")) {
            lbAKg(valor);
        } else if (opcion.equals("g_oz")) {
            gAOz(valor);
        } else if (opcion.equals("oz_g")) {
            ozAG(valor);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void kgAG(double valor) {
        System.out.println(valor + " kg = " + (valor * 1000) + " g");
    }

    static void gAKg(double valor) {
        System.out.println(valor + " g = " + (valor / 1000) + " kg");
    }

    static void kgALb(double valor) {
        System.out.println(valor + " kg = " + (valor * 2.20462) + " lb");
    }

    static void lbAKg(double valor) {
        System.out.println(valor + " lb = " + (valor * 0.453592) + " kg");
    }

    static void gAOz(double valor) {
        System.out.println(valor + " g = " + (valor * 0.035274) + " oz");
    }

    static void ozAG(double valor) {
        System.out.println(valor + " oz = " + (valor * 28.3495) + " g");
    }

    static void menuTemperatura() {
        System.out.println("Conversion de temperatura:");
        System.out.println("c_f");
        System.out.println("f_c");
        System.out.println("c_k");
        System.out.println("k_c");
        System.out.print("Opcion: ");

        String opcion = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double valor = sc.nextDouble();

        if (opcion.equals("c_f")) {
            cAF(valor);
        } else if (opcion.equals("f_c")) {
            fAC(valor);
        } else if (opcion.equals("c_k")) {
            cAK(valor);
        } else if (opcion.equals("k_c")) {
            kAC(valor);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void cAF(double valor) {
        System.out.println(valor + " C = " + (valor * 9 / 5 + 32) + " F");
    }

    static void fAC(double valor) {
        System.out.println(valor + " F = " + ((valor - 32) * 5 / 9) + " C");
    }

    static void cAK(double valor) {
        System.out.println(valor + " C = " + (valor + 273.15) + " K");
    }

    static void kAC(double valor) {
        System.out.println(valor + " K = " + (valor - 273.15) + " C");
    }
}