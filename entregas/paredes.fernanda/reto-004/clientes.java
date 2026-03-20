package vistas.fraccion;

public class Cliente {
    public static void main(String[] args) {
        Console console = new Console();

        console.writeln("> Pruebas de Constructores y toString");
        Fraccion f1 = new Fraccion(1, 2);
        console.writeln("Constructor (1,2): " + f1.toString());
        
        Fraccion f2 = new Fraccion(3);
        console.writeln("Constructor entero (3): " + f2.toString());
        
        Fraccion f3 = new Fraccion();
        console.writeln("Constructor defecto: " + f3.toString());
        
        Fraccion copia = new Fraccion(f1);
        console.writeln("Constructor copia de f1: " + copia.toString());

        Fraccion clon = f1.clonar();
        console.writeln("Metodo clonar de f1: " + clon.toString());

        console.writeln("> Operaciones Aritmeticas");
        Fraccion a = new Fraccion(1, 2);
        Fraccion b = new Fraccion(1, 4);

        console.write(a + " + " + b + " = ");
        a.sumar(b);
        console.writeln(a.toString()); 

        a = new Fraccion(3, 4);
        console.write(a + " - " + b + " = ");
        a.restar(b);
        console.writeln(a.toString()); 

        a = new Fraccion(1, 2);
        console.write(a + " * " + b + " = ");
        a.multiplicar(b);
        console.writeln(a.toString()); 

        a = new Fraccion(1, 2);
        console.write(a + " / " + b + " = ");
        a.dividir(b);
        console.writeln(a.toString()); 
        console.writeln("> Comparaciones");
        Fraccion mayor = new Fraccion(3, 4);
        Fraccion menor = new Fraccion(1, 4);
        console.writeln(mayor + " es mayor que " + menor + ": " + mayor.esMayor(menor));
        console.writeln(menor + " es menor que " + mayor + ": " + menor.esMenor(mayor));
        console.writeln(mayor + " es igual a 6/8: " + mayor.equals(new Fraccion(6, 8)));

        console.writeln("> Utilidades");
        Fraccion util = new Fraccion(2, 5);
        console.write("Original: " + util + " -> Invertida: ");
        util.invertir();
        console.writeln(util.toString()); 
        console.write("Actual: " + util + " -> Opuesta: ");
        util.oponer();
        console.writeln(util.toString()); 
    }
}