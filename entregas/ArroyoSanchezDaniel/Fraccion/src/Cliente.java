public class Cliente {

    public static void main(String[] args) {
        Console console = new Console();
        Fraccion unTercio = new Fraccion(1, 3);

        console.writeln(" > Constructores");
        Fraccion tresQuintos = new Fraccion(3, 5);
        tresQuintos.mostrar();
        new Fraccion(3).mostrar();
        new Fraccion().mostrar();
        new Fraccion(tresQuintos).mostrar();
        tresQuintos.clonar().mostrar();
        console.writeln();

        console.writeln(" > Suma y Resta");
        console.writeln("Fracción 1: " + tresQuintos);
        console.writeln("Fracción 2: " + unTercio);
        unTercio.sumar(tresQuintos);
        console.writeln("Suma: " + unTercio);
        unTercio = new Fraccion(1, 3);
        unTercio.restar(tresQuintos);
        console.writeln("Resta: " + unTercio);
        console.writeln();

        console.writeln(" > Multiplicación y División");
        unTercio = new Fraccion(1, 3);
        console.writeln("Fracción 1: " + tresQuintos);
        console.writeln("Fracción 2: " + unTercio);
        unTercio.multiplicar(tresQuintos);
        console.writeln("Multiplicación: " + unTercio);
        unTercio = new Fraccion(1, 3);
        unTercio.dividir(tresQuintos);
        console.writeln("División: " + unTercio);
        console.writeln();

        console.writeln(" > Potencia ");
        Fraccion cuatroNovenos = new Fraccion(4, 9);
        console.writeln("Fracción: " + cuatroNovenos);
        console.writeln("Exponente: 2");
        cuatroNovenos.potenciar(2);
        console.writeln("Fracción al cuadrado: " + cuatroNovenos);
        cuatroNovenos = new Fraccion(4, 9);
        console.writeln();

        console.writeln(" > Comparación Fracciones");
        unTercio = new Fraccion(1, 3);
        console.writeln("Fracción 1: " + tresQuintos);
        console.writeln("Fracción 2: " + unTercio);
        console.writeln("¿Es " + unTercio + " mayor que " + tresQuintos + "?: " + unTercio.esMayor(tresQuintos));
        console.writeln("¿Es " + unTercio + " menor que " + tresQuintos + "?: " + unTercio.esMenor(tresQuintos));
        console.writeln("¿Es " + unTercio + " igual que " + tresQuintos + "?: " + unTercio.equals(tresQuintos));
        console.writeln();

        console.writeln(" > Inversión y oposición");
        console.writeln("Fracción: " + unTercio);
        unTercio.invertir();
        console.writeln("Inversión: " + unTercio);
        unTercio.invertir();
        unTercio.oponer();
        console.writeln("Oposición" + unTercio);
    }

}
