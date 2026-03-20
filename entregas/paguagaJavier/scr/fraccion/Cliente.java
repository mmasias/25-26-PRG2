package entregas.paguagaJavier.scr.fraccion;

public class Cliente {
    public static void main(String[] args) {
        Fraccion tresQuintos = new Fraccion(3, 5);
        Fraccion dosCuartos = new Fraccion(2, 4);

        System.out.println("tresQuintos = " + tresQuintos);
        System.out.println("dosCuartos = " + dosCuartos);

        Fraccion suma = tresQuintos.clonar();
        suma.sumar(dosCuartos);
        System.out.println("Suma: " + suma);

        Fraccion resta = tresQuintos.clonar();
        resta.restar(dosCuartos);
        System.out.println("Resta: " + resta);

        Fraccion multiplicar = tresQuintos.clonar();
        multiplicar.multiplicar(dosCuartos);
        System.out.println("Multiplicación: " + multiplicar);

        Fraccion dividir = tresQuintos.clonar();
        dividir.dividir(dosCuartos);
        System.out.println("División: " + dividir);

        Fraccion pottenciar = tresQuintos.clonar();
        pottenciar.potenciar(2);
        System.out.println("Potencia de tresQuintos^2: " + pottenciar);

        System.out.println("tresQuintos es mayor que dosCuartos? " + tresQuintos.esMayor(dosCuartos));
        System.out.println("tresQuintos es menor que dosCuartos? " + tresQuintos.esMenor(dosCuartos));
        System.out.println("tresQuintos es igual que dosCuartos? " + tresQuintos.equals(dosCuartos));

        Fraccion inv = tresQuintos.clonar();
        inv.invertir();
        System.out.println("Invertida tresQuintos: " + inv);

        Fraccion oponer = tresQuintos.clonar();
        oponer.oponer();
        System.out.println("Opuesta tresQuintos: " + oponer);

        Fraccion decimal = tresQuintos.clonar();;
        System.out.println("tresQuintos a decimal: " + decimal.aDecimal());
    }
}
