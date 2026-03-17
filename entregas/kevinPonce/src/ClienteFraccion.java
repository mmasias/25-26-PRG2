public class ClienteFraccion {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(2, 3);
        Fraccion f2 = new Fraccion(3, 4);
        Fraccion f3 = new Fraccion(5);
        Fraccion f4 = new Fraccion(f1);

        System.out.println("f1: " + f1);
        System.out.println("f2: " + f2);
        System.out.println("f3: " + f3);
        System.out.println("f4 (copia de f1): " + f4);

        Fraccion suma = f1.sumar(f2);
        Fraccion resta = f1.restar(f2);
        Fraccion mult = f1.multiplicar(f2);
        Fraccion div = f1.dividir(f2);

        System.out.println("Suma f1 + f2: " + suma);
        System.out.println("Resta f1 - f2: " + resta);
        System.out.println("Multiplicación f1 * f2: " + mult);
        System.out.println("División f1 / f2: " + div);

        System.out.println("Decimal f1: " + f1.toDecimal());
        System.out.println("Decimal f2: " + f2.toDecimal());
        System.out.println("Inversa f1: " + f1.inversa());
        System.out.println("Opuesta f2: " + f2.opuesta());
        System.out.println("f1 es propia? " + f1.esPropia());
        System.out.println("f3 es propia? " + f3.esPropia());

        System.out.println("f1 es igual a f4? " + f1.esIgual(f4));
        System.out.println("f1 es igual a f2? " + f1.esIgual(f2));

        Fraccion sumaCadenas = new Fraccion(1, 2).sumar(new Fraccion(2, 3)).sumar(new Fraccion(3, 4));
        System.out.println("Suma de varias fracciones: " + sumaCadenas);

        Fraccion restaCadenas = new Fraccion(7, 8).restar(new Fraccion(1, 4)).restar(new Fraccion(1, 8));
        System.out.println("Resta de varias fracciones: " + restaCadenas);
    }
}