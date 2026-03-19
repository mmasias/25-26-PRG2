package vistas.fraccion;

public class Cliente {
    public static void main(String[] args) {
        Fraccion tresQuintos = new Fraccion(3, 5);
        Fraccion dosCuartos = new Fraccion(2, 4); 

        System.out.println("Fracción 1: "); tresQuintos.mostrar();
        System.out.println("Fracción 2 : "); dosCuartos.mostrar();

        
        tresQuintos.sumar(dosCuartos);
        System.out.println("Resultado de la suma: ");
        tresQuintos.mostrar();

        
        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(1, 3);
        System.out.println("¿1/2 es mayor que 1/3? " + f1.esMayor(f2));
    }
}