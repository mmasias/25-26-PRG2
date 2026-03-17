import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Numerador de la primera fracción: ");
            int n1 = sc.nextInt();
            System.out.print("Denominador de la primera fracción: ");
            int d1 = sc.nextInt();

            System.out.print("Numerador de la segunda fracción: ");
            int n2 = sc.nextInt();
            System.out.print("Denominador de la segunda fracción: ");
            int d2 = sc.nextInt();

            Fraccion a = new Fraccion(n1, d1);
            Fraccion b = new Fraccion(n2, d2);

            System.out.println("1) Sumar");
            System.out.println("2) Restar");
            System.out.println("3) Multiplicar");
            System.out.println("4) Dividir");
            System.out.println("5) Comparar");
            System.out.println("6) Inversa de ambas");
            System.out.println("7) Opuesta de ambas");
            System.out.println("8) Salir");
            System.out.print("Elige operación: ");
            int op = sc.nextInt();

            if (op == 8) break;

            if (op == 5) {
                int c = a.compareTo(b);
                if (c == 0) System.out.println("Son iguales");
                else if (c < 0) System.out.println("La primera es menor");
                else System.out.println("La primera es mayor");
                System.out.println();
                continue;
            }

            if (op == 6) {
                System.out.println("Inversa de la primera: " + a.inversa());
                System.out.println("Inversa de la segunda: " + b.inversa());
                System.out.println();
                continue;
            }

            if (op == 7) {
                System.out.println("Opuesta de la primera: " + a.opuesta());
                System.out.println("Opuesta de la segunda: " + b.opuesta());
                System.out.println();
                continue;
            }

            Fraccion r = null;

            if (op == 1) r = a.sumar(b);
            else if (op == 2) r = a.restar(b);
            else if (op == 3) r = a.multiplicar(b);
            else if (op == 4) r = a.dividir(b);

            System.out.println("Resultado: " + r);
            System.out.println();
        }
    }
}

class Fraccion implements Comparable<Fraccion> {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) throw new IllegalArgumentException();
        this.numerador = numerador;
        this.denominador = denominador;
        normalizar();
    }

    private void normalizar() {
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
        int m = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= m;
        denominador /= m;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public Fraccion sumar(Fraccion o) {
        return new Fraccion(numerador * o.denominador + o.numerador * denominador,
                            denominador * o.denominador);
    }

    public Fraccion restar(Fraccion o) {
        return new Fraccion(numerador * o.denominador - o.numerador * denominador,
                            denominador * o.denominador);
    }

    public Fraccion multiplicar(Fraccion o) {
        return new Fraccion(numerador * o.numerador,
                            denominador * o.denominador);
    }

    public Fraccion dividir(Fraccion o) {
        if (o.numerador == 0) throw new ArithmeticException();
        return new Fraccion(numerador * o.denominador,
                            denominador * o.numerador);
    }

    public Fraccion inversa() {
        if (numerador == 0) throw new ArithmeticException();
        return new Fraccion(denominador, numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public int compareTo(Fraccion o) {
        long a = (long) numerador * o.denominador;
        long b = (long) o.numerador * denominador;
        return Long.compare(a, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Fraccion)) return false;
        Fraccion o = (Fraccion) obj;
        return numerador == o.numerador && denominador == o.denominador;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }
}