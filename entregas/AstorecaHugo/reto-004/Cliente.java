

public class Cliente {
    public static void main(String[] args) {

        System.out.println("=== Fracciones iniciales ===");
        Fraccion fraccion1 = new Fraccion(3, 5);
        Fraccion fraccion2 = new Fraccion(2, 7);
        Fraccion fraccion3 = new Fraccion(4);
        Fraccion fraccion4 = new Fraccion(3, 5);

        fraccion1.mostrar();
        fraccion2.mostrar();
        fraccion3.mostrar();
        fraccion4.mostrar();

        System.out.println("=== Suma ===");
        Fraccion suma = new Fraccion(fraccion1);
        suma.sumar(fraccion2);

        System.out.print("f1 + f2 = ");
        suma.mostrar();

        System.out.println("=== Resta ===");
        Fraccion resta = new Fraccion(fraccion3);
        resta.restar(new Fraccion(fraccion2));
        System.out.print("fraccion3 - fraccion2 = ");
        resta.mostrar();

        System.out.println("=== Multiplicación ===");
        Fraccion multiplicacion = new Fraccion(fraccion2);
        multiplicacion.multiplicar(new Fraccion(fraccion4));
        System.out.print("fraccion2 * fraccion4 = ");
        multiplicacion.mostrar();

        System.out.println("=== División ===");
        Fraccion division = new Fraccion(fraccion4);
        division.dividir(new Fraccion(fraccion2));
        System.out.print("fraccion4 / fraccion2 = ");
        division.mostrar();

        System.out.println("=== Comparaciones ===");
        System.out.println("fraccion1 > fraccion3? " + fraccion1.esMayor(fraccion3));
        System.out.println("fraccion1 < fraccion3? " + fraccion1.esMenor(fraccion3));
        System.out.println("fraccion1 == fraccion4? " + fraccion1.equals(fraccion4));

        System.out.println("\n=== Inversa y Oponer ===");
        Fraccion fraccion1Copia = new Fraccion(fraccion1);
        fraccion1Copia.inversa();
        System.out.print("Inversa fraccion1: ");
        fraccion1Copia.mostrar();

        fraccion1Copia.oponer();
        System.out.print("Oponer fraccion1: ");
        fraccion1Copia.mostrar();

        System.out.println("=== Simplificar ===");
        Fraccion fraccion5 = new Fraccion(8, 12);
        System.out.print("Antes de simplificar fraccion5: ");
        fraccion5.mostrar();
        fraccion5.simplificar();
        System.out.print("Después de simplificar fraccion5: ");
        fraccion5.mostrar();
    }
}

