public class ClienteFraccion {
    public static void main(String[] args) {
        Console console = new Console();

        Fraccion unMedio = new Fraccion(1, 2);
        Fraccion unCuarto = new Fraccion(1, 4);

        Fraccion cero = new Fraccion();
        Fraccion entero = new Fraccion(5);
        Fraccion clon = unMedio.clonar();

        console.writeln("Las fracciones iniciales son: " + unMedio + " Y " + unCuarto);
        console.writeln();
        console.writeln("La suma es: " + unMedio.sumar(unCuarto));
        console.writeln("La resta es: " + unMedio.restar(unCuarto));
        console.writeln("La multiplicacion es: " + unMedio.multiplicar(unCuarto));
        console.writeln("La division es: " + unMedio.dividir(unCuarto));
        console.writeln("La fraccion cero = " + cero);
        console.writeln("La fraccion entera = " + entero);
        console.writeln("La fraccion clon es " + clon);
        console.writeln("La fraccion opuesta:  " + unMedio.oponer());
        console.writeln("La fraccion invertida es: " + unMedio.invertir());
        console.writeln();
        console.writeln("Confirmacion de inmutabilidad:");
        console.writeln("unMedio sigue siendo: " + unMedio);

    }
}
