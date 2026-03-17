public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(2, 4);
        Fraccion f2 = new Fraccion(3, 5);
        Fraccion f3 = new Fraccion(-6, -8);
        Fraccion f4 = new Fraccion(1, 2);
        Fraccion copia = f1.clone();

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);

        System.out.println("Suma = " + f1.sumar(f2));
        System.out.println("Resta = " + f1.restar(f2));
        System.out.println("Multiplicación = " + f1.multiplicar(f2));
        System.out.println("División = " + f1.dividir(f2));

        System.out.println("Opuesta de f1 = " + f1.opuesta());
        System.out.println("Inversa de f2 = " + f2.inversa());
        System.out.println("Decimal de f1 = " + f1.aDecimal());
        System.out.println("¿f1 es cero? " + f1.esCero());

        System.out.println("compareTo entre f1 y f2 = " + f1.compareTo(f2));
        System.out.println("¿f1 < f2? " + f1.menorQue(f2));
        System.out.println("¿f1 > f2? " + f1.mayorQue(f2));
        System.out.println("¿f1 <= f2? " + f1.menorOIgualQue(f2));
        System.out.println("¿f1 >= f2? " + f1.mayorOIgualQue(f2));

        System.out.println("¿f1 es igual a f4? " + f1.equals(f4));
        System.out.println("Copia de f1 = " + copia);
    }
}
