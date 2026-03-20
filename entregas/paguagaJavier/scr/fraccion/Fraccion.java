package entregas.paguagaJavier.scr.fraccion;

public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        assert this.denominador != 0 : "El denominador no puede ser cero";
    }

    public Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    public Fraccion(Fraccion fraccion) {
        numerador = fraccion.numerador;
        denominador = fraccion.denominador;
    }

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion clonar() {
        return new Fraccion(this);

    }

    public void sumar(Fraccion fraccion) {
        int numerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        int denominador = this.denominador * fraccion.denominador;
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void restar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    public void multiplicar(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    public void dividir(Fraccion fraccion) {
        int nuevoNumerador = this.numerador * fraccion.denominador;
        int nuevoDenominador = this.denominador * fraccion.numerador;
        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
    }

    public void potenciar(int exponente) {
        this.numerador = (int) Math.pow(this.numerador, exponente);
        this.denominador = (int) Math.pow(this.denominador, exponente);
    }

    public boolean esMayor(Fraccion fraccion) {
        int producto1 = this.numerador * fraccion.denominador;
        int producto2 = fraccion.numerador * this.denominador;
        return producto1 > producto2;
    }

    public boolean esMenor(Fraccion fraccion) {
        int producto1 = this.numerador * fraccion.denominador;
        int producto2 = fraccion.numerador * this.denominador;
        return producto1 < producto2;
    }

    public boolean equals(Fraccion fraccion) {
        return !this.esMayor(fraccion) && !this.esMenor(fraccion);
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public void invertir() {
        int temp = this.numerador;
        this.numerador = this.denominador;
        this.denominador = temp;
    }

    public void oponer() {
        this.numerador = -this.numerador;
    }

    public double aDecimal() {
        return (double) this.numerador / this.denominador;
    }

}
