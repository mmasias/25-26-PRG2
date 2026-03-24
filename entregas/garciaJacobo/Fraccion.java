
public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0;
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public void simplificar() {
        int maximoComunDivisor = calcularMCD(numerador, denominador);
        this.numerador = this.numerador / maximoComunDivisor;
        this.denominador = this.denominador / maximoComunDivisor;
    }

    private int calcularMCD(int numerador, int denominador) {
        while (denominador != 0) {
            int temporal = denominador;
            denominador = numerador % denominador;
            numerador = temporal;
        }
        return numerador;
    }

    public Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    public Fraccion(Fraccion fraccion) {
        this.numerador = fraccion.numerador;
        this.denominador = fraccion.denominador;
    }

    public Fraccion clonar() {
        return new Fraccion(this);
    }

    public void sumar(Fraccion fraccion) {
        int nuevoNumerador = (this.numerador * fraccion.denominador + fraccion.numerador * this.denominador);
        int nuevoDenominador = (this.denominador * fraccion.denominador);
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        this.simplificar();
    }

    public void restar(Fraccion fraccion) {
        int numerador = (this.numerador * fraccion.denominador - fraccion.numerador * this.denominador);
        int denominador = (this.denominador * fraccion.denominador);
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public void multiplicar(Fraccion fraccion) {
        int nuevoNumerador = (this.numerador * fraccion.numerador);
        int nuevoDenominador = (this.denominador * fraccion.denominador);
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        this.simplificar();
    }

    public void dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0;
        int nuevoNumerador = (this.numerador * fraccion.denominador);
        int nuevoDenominador = (this.denominador * fraccion.numerador);
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        this.simplificar();
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean equals(Fraccion fraccion) {
        return !this.esMayor(fraccion) && !this.esMenor(fraccion);
    }

    public void mostrar() {
        System.out.println(this.numerador + "/" + this.denominador);
    }

    public void inversa() {
        assert this.numerador != 0;
        int numeradorTemporal = this.numerador;

        this.numerador = this.denominador;
        this.denominador = numeradorTemporal;

    }

    public void oponer() {
        this.numerador = this.numerador * -1;
    }

}
