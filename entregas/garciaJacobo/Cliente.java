
public class Cliente {

    public static void main(String[] args) {

        System.out.println("=== Fracciones iniciales ===");
        Fraccion fraccionPrueba1 = new Fraccion(3, 5);
        Fraccion fraccionPrueba2 = new Fraccion(2, 7);
        Fraccion fraccionPrueba3 = new Fraccion(4);
        Fraccion fraccionPrueba4 = new Fraccion(3, 5);
        Fraccion fraccionPrueba = new Fraccion(3, 5);

        fraccionPrueba1.mostrar();
        fraccionPrueba2.mostrar();
        fraccionPrueba3.mostrar();
        fraccionPrueba4.mostrar();

        System.out.println("=== Suma ===");
        Fraccion suma = new Fraccion(fraccionPrueba1);
        suma.sumar(fraccionPrueba2);

        System.out.print("f1 + f2 = ");
        suma.mostrar();

        System.out.println("=== Resta ===");
        Fraccion resta = new Fraccion(fraccionPrueba3);
        resta.restar(new Fraccion(fraccionPrueba2));
        System.out.print("f3 - f2 = ");
        resta.mostrar();

        System.out.println("=== Multiplicación ===");
        Fraccion multiplicacion = new Fraccion(fraccionPrueba2);
        multiplicacion.multiplicar(new Fraccion(fraccionPrueba4));
        System.out.print("f2 * f4 = ");
        multiplicacion.mostrar();

        System.out.println("=== División ===");
        Fraccion division = new Fraccion(fraccionPrueba4);
        division.dividir(new Fraccion(fraccionPrueba2));
        System.out.print("f4 / f2 = ");
        division.mostrar();

        System.out.println("=== Comparaciones ===");
        System.out.println("f1 > f3? " + fraccionPrueba1.esMayor(fraccionPrueba3));
        System.out.println("f1 < f3? " + fraccionPrueba1.esMenor(fraccionPrueba3));
        System.out.println("f1 == f4? " + fraccionPrueba1.equals(fraccionPrueba4));

        System.out.println("\n=== Inversa y Oponer ===");
        Fraccion f1Copia = new Fraccion(fraccionPrueba1);
        f1Copia.inversa();
        System.out.print("Inversa f1: ");
        f1Copia.mostrar();

        f1Copia.oponer();
        System.out.print("Oponer f1: ");
        f1Copia.mostrar();

        System.out.println("=== Simplificar ===");
        Fraccion f5 = new Fraccion(8, 12);
        System.out.print("Antes de simplificar f5: ");
        f5.mostrar();
        f5.simplificar();
        System.out.print("Después de simplificar f5: ");
        f5.mostrar();
    }
}
