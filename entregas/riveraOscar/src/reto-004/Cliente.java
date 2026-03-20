package entregas.riveraOscar.src.Fraccion;

public class Cliente {
    public static void main(String[] args){

        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(6, 8);

        System.out.print("f1 = ");
        f1.mostrar();
        f1.sumar(f2);
        System.out.print("f1 + f2 = ");
        f1.mostrar();
        f1.simplificar();
        System.out.print("f1 simplificado = ");
        f1.mostrar();

        Fraccion f3 = new Fraccion(5);
        System.out.println("¿Es f3 mayor a f2? " + f3.esMayor(f2));
        System.out.println("¿Es f3 igual a f1? " + f3.equals(f1));

        System.out.print("f2 = ");
        f2.mostrar();
        f2.invertir();
        System.out.print("Opuesto de f2 = ");
        f2.mostrar();
    }
}