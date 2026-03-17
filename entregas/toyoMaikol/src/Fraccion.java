public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero.";
        
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        int mcd = calcularMCD(valorAbsoluto(numerador), valorAbsoluto(denominador));
        this.numerador = numerador / mcd;
        this.denominador = denominador / mcd;
    }

    private int valorAbsoluto(int numero) {
        if (numero < 0) {
            return -numero;
        }
        return numero;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a; 
    }

    public Fraccion sumar(Fraccion fraccion) {
        int nuevoNum = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        int nuevoDen = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion restar(Fraccion fraccion) {
        int nuevoNum = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        int nuevoDen = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        int nuevoNum = this.numerador * fraccion.numerador;
        int nuevoDen = this.denominador * fraccion.denominador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0 : "No se puede dividir por cero.";
        int nuevoNum = this.numerador * fraccion.denominador;
        int nuevoDen = this.denominador * fraccion.numerador;
        return new Fraccion(nuevoNum, nuevoDen);
    }

}