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

        String op = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (op.equals("metros_kilometros")) {
            metrosAKilometros(v);
        } else if (op.equals("kilometros_metros")) {
            kilometrosAMetros(v);
        } else if (op.equals("metros_millas")) {
            metrosAMillas(v);
        } else if (op.equals("millas_metros")) {
            millasAMetros(v);
        } else if (op.equals("centimetros_pulgadas")) {
            centimetrosAPulgadas(v);
        } else if (op.equals("pulgadas_centimetros")) {
            pulgadasACentimetros(v);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void metrosAKilometros(double v) {
        System.out.println(v + " m = " + (v / 1000) + " km");
    }

    static void kilometrosAMetros(double v) {
        System.out.println(v + " km = " + (v * 1000) + " m");
    }

    static void metrosAMillas(double v) {
        System.out.println(v + " m = " + (v * 0.000621371) + " mi");
    }

    static void millasAMetros(double v) {
        System.out.println(v + " mi = " + (v * 1609.34) + " m");
    }

    static void centimetrosAPulgadas(double v) {
        System.out.println(v + " cm = " + (v * 0.393701) + " in");
    }

    static void pulgadasACentimetros(double v) {
        System.out.println(v + " in = " + (v * 2.54) + " cm");
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

        String op = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (op.equals("kg_g")) {
            kgAG(v);
        } else if (op.equals("g_kg")) {
            gAKg(v);
        } else if (op.equals("kg_lb")) {
            kgALb(v);
        } else if (op.equals("lb_kg")) {
            lbAKg(v);
        } else if (op.equals("g_oz")) {
            gAOz(v);
        } else if (op.equals("oz_g")) {
            ozAG(v);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void kgAG(double v) {
        System.out.println(v + " kg = " + (v * 1000) + " g");
    }

    static void gAKg(double v) {
        System.out.println(v + " g = " + (v / 1000) + " kg");
    }

    static void kgALb(double v) {
        System.out.println(v + " kg = " + (v * 2.20462) + " lb");
    }

    static void lbAKg(double v) {
        System.out.println(v + " lb = " + (v * 0.453592) + " kg");
    }

    static void gAOz(double v) {
        System.out.println(v + " g = " + (v * 0.035274) + " oz");
    }

    static void ozAG(double v) {
        System.out.println(v + " oz = " + (v * 28.3495) + " g");
    }

    static void menuTemperatura() {
        System.out.println("Conversion de temperatura:");
        System.out.println("c_f");
        System.out.println("f_c");
        System.out.println("c_k");
        System.out.println("k_c");
        System.out.print("Opcion: ");

        String op = sc.next().toLowerCase();
        System.out.print("Valor: ");
        double v = sc.nextDouble();

        if (op.equals("c_f")) {
            cAF(v);
        } else if (op.equals("f_c")) {
            fAC(v);
        } else if (op.equals("c_k")) {
            cAK(v);
        } else if (op.equals("k_c")) {
            kAC(v);
        } else {
            System.out.println("Opcion no valida");
        }
    }

    static void cAF(double v) {
        System.out.println(v + " C = " + (v * 9 / 5 + 32) + " F");
    }

    static void fAC(double v) {
        System.out.println(v + " F = " + ((v - 32) * 5 / 9) + " C");
    }

    static void cAK(double v) {
        System.out.println(v + " C = " + (v + 273.15) + " K");
    }

    static void kAC(double v) {
        System.out.println(v + " K = " + (v - 273.15) + " C");
    }
}