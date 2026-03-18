public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    private void simplificar() {
        int mcd = calcularMCD(numerador, denominador);
        numerador = numerador / mcd;
        denominador = denominador / mcd;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public Fraccion crearInversa() {
        int nuevoNumerador = denominador;
        int nuevoDenominador = numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion crearOpuesta() {
        int nuevoNumerador = numerador * -1;
        return new Fraccion(nuevoNumerador, denominador);
    }

    public boolean esIgual(Fraccion otraFraccion) {
        if (this.numerador == otraFraccion.numerador && this.denominador == otraFraccion.denominador) {
            return true;
        } else {
            return false;
        }
    }

    public Fraccion multiplicar(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.numerador;
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.denominador;
        int nuevoDenominador = this.denominador * otraFraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(Fraccion otraFraccion) {
        int nuevoNumerador;
        int nuevoDenominador;
        if (this.denominador == otraFraccion.denominador) {
            nuevoNumerador = this.numerador + otraFraccion.numerador;
            return new Fraccion(nuevoNumerador, denominador);
        } else {
            nuevoNumerador = (this.numerador * otraFraccion.denominador) + (this.denominador * otraFraccion.numerador);
            nuevoDenominador = this.denominador * otraFraccion.denominador;
            return new Fraccion(nuevoNumerador, nuevoDenominador);
        }
    }

    public Fraccion restar(Fraccion otraFraccion) {
        int nuevoNumerador;
        int nuevoDenominador;
        if (this.denominador == otraFraccion.denominador) {
            nuevoNumerador = this.numerador - otraFraccion.numerador;
            return new Fraccion(nuevoNumerador, denominador);
        } else {
            nuevoNumerador = (this.numerador * otraFraccion.denominador) - (this.denominador * otraFraccion.numerador);
            nuevoDenominador = this.denominador * otraFraccion.denominador;
            return new Fraccion(nuevoNumerador, nuevoDenominador);
        }
    }
}
