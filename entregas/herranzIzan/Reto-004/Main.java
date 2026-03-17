public class Main {
    public static void main(String[] args) {
        Fraccion f1 = new Fraccion(2, 4);
        Fraccion f2 = new Fraccion(3, 5);
        Fraccion f3 = new Fraccion(-6, -8);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);

        System.out.println("Suma = " + f1.sumar(f2));
        System.out.println("Resta = " + f1.restar(f2));
        System.out.println("Multiplicación = " + f1.multiplicar(f2));
        System.out.println("División = " + f1.dividir(f2));
    }
}
