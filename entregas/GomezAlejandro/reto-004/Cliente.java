package gomezAlejandro;

public class Cliente {

    public static void main(String[] args) {

        System.out.println("=== Fracciones iniciales ===");
        Fraccion f1 = new Fraccion(3, 5);
        Fraccion f2 = new Fraccion(2, 7);
        Fraccion f3 = new Fraccion(4);
        Fraccion f4 = new Fraccion(3, 5);

        f1.mostrar();
        f2.mostrar();
        f3.mostrar();
        f4.mostrar();

        System.out.println("=== Suma ===");
        Fraccion suma = new Fraccion(f1);
        suma.sumar(f2);
        System.out.print("f1 + f2 = ");
        suma.mostrar();

        System.out.println("=== Resta ===");
        Fraccion resta = new Fraccion(f3);
        resta.restar(new Fraccion(f2));
        System.out.print("f3 - f2 = ");
        resta.mostrar();

        System.out.println("=== Multiplicación ===");
        Fraccion mult = new Fraccion(f2);
        mult.multiplicar(new Fraccion(f4));
        System.out.print("f2 * f4 = ");
        mult.mostrar();

        System.out.println("=== División ===");
        Fraccion div = new Fraccion(f4);
        div.dividir(new Fraccion(f2));
        System.out.print("f4 / f2 = ");
        div.mostrar();

        System.out.println("=== Comparaciones ===");
        System.out.println("f1 > f3? " + f1.esMayor(f3));
        System.out.println("f1 < f3? " + f1.esMenor(f3));
        System.out.println("f1 == f4? " + f1.esIgual(f4));

        System.out.println("=== Inversa y signo ===");
        Fraccion copia = new Fraccion(f1);
        copia.invertir();
        System.out.print("Inversa f1: ");
        copia.mostrar();

        copia.cambiarSigno();
        System.out.print("Opuesta f1: ");
        copia.mostrar();

        System.out.println("=== Simplificar ===");
        Fraccion f5 = new Fraccion(8, 12);
        System.out.print("Antes: ");
        f5.mostrar();
        f5.reducir();
        System.out.print("Después: ");
        f5.mostrar();
    }
}
