public class Cliente {
    public static void main(String[] args) {
        Console console = new Console();

        console.writeln("Introduce la primera fracción:");
        int numerador1 = console.readInt("Numerador: ");
        int denominador1 = console.readInt("Denominador: ");

        console.writeln("Introduce la segunda fracción:");
        int numerador2 = console.readInt("Numerador: ");
        int denominador2 = console.readInt("Denominador: ");

        Fraccion fraccion1 = new Fraccion(numerador1, denominador1);
        Fraccion fraccion2 = new Fraccion(numerador2, denominador2);

        Fraccion resultado1 = fraccion1.sumar(fraccion2);
        console.writeln("Resultado al sumar: " + resultado1);
            
        Fraccion resultado2 = fraccion1.restar(fraccion2);
        console.writeln("Resultado al restar: " + resultado2);

        Fraccion resultado21 = fraccion1.restar(fraccion2).valorAbsoluto();
        console.writeln("Resultado al restar y estar en valor absoluto: " + resultado21);

        Fraccion resultado3 = fraccion1.multiplicar(fraccion2);
        console.writeln("Resultado al multiplicar: " + resultado3);

        Fraccion resultado4 = fraccion1.dividir(fraccion2);
        console.writeln("Resultado al dividir: " + resultado4);

        int exponente = console.readInt("Introduce el exponente para la primera fracción: ");
        Fraccion resultado5 = fraccion1.exponenciar(exponente);
        console.writeln("Resultado al exponenciar: " + resultado5);

    }
}