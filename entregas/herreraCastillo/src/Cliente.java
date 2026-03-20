public class Cliente {
    public static void main(String[] args) {
        probarOperacionesAritmeticas();
        probarComparaciones();
        probarUtilidades();

    }

    public static void probarOperacionesAritmeticas() {
        Fraccion fraccionBase = new Fraccion(1, 2);
        Fraccion fraccionSuma = new Fraccion(1, 4);

        System.out.println("--- Operaciones ---");
        System.out.println("Original: " + fraccionBase.toString());
        
        fraccionBase.sumar(fraccionSuma);
        System.out.println("Despues de sumar 1/4: " + fraccionBase.toString());

        fraccionBase.multiplicar(new Fraccion(2, 3));
        System.out.println("Despues de multiplicar por 2/3: " + fraccionBase.toString());
    }

    public static void probarComparaciones() {
        Fraccion fraccionUno = new Fraccion(1, 2);
        Fraccion fraccionDos = new Fraccion(2, 4);
        Fraccion fraccionTres = new Fraccion(3, 4);

        System.out.println("\n--- Comparaciones ---");
        System.out.println(fraccionUno.toString() + " es igual a " + fraccionDos.toString() + "? " + fraccionUno.equals(fraccionDos));
        System.out.println(fraccionTres.toString() + " es mayor que " + fraccionUno.toString() + "? " + fraccionTres.esMayor(fraccionUno));
    }

    public static void probarUtilidades() {
        Fraccion fraccionParaSimplificar = new Fraccion(10, 20);
        
        System.out.println("\n--- Utilidades ---");
        Fraccion fraccionSimplificada = fraccionParaSimplificar.simplificar(fraccionParaSimplificar);
        
        System.out.println("Fraccion original: " + fraccionParaSimplificar.toString());
        System.out.println("Fraccion simplificada: " + fraccionSimplificada.toString());
        System.out.println("Valor decimal: " + fraccionParaSimplificar.decimal(fraccionParaSimplificar));
    }
}



