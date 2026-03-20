public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador == 0;
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    public Fraccion(Fraccion fraccion) {
        assert fraccion.denominador == 0;
        this.numerador = fraccion.numerador;
        this.denominador = fraccion.denominador;
    }

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public Fraccion clonar() {
        return new Fraccion(this);
    }

    public void sumar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public void restar(Fraccion fraccion) {
        this.numerador = fraccion.numerador * this.denominador - this.numerador * fraccion.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public void multiplicar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.numerador;
        this.denominador = this.denominador * fraccion.denominador;
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public void dividir(Fraccion fraccion) {
        this.numerador = fraccion.numerador * this.denominador;
        this.denominador = fraccion.denominador * this.numerador;
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public void potenciar(int exponente) {
        this.numerador = (int) Math.pow(this.numerador, exponente);
        this.denominador = (int) Math.pow(this.denominador, exponente);
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public boolean esMayor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;

    }

    public boolean equals(Fraccion fraccion) {
        return this.numerador * fraccion.denominador == fraccion.numerador * this.denominador;
    }

    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public void mostrar() {
        Console console = new Console();
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = this.numerador/mcd;
        this.denominador= this.denominador/mcd;
        console.writeln(this.numerador + "/" + this.denominador);
    }

    public void invertir() {
        int temporal = this.numerador;
        this.numerador = this.denominador;
        this.denominador = temporal;
        int mcd = calcularMCD(Math.abs(this.numerador), Math.abs(this.denominador));
        this.numerador = numerador / mcd;
        this.denominador = this.denominador / mcd;
    }

    public void oponer() {
        this.numerador = this.numerador * (-1);
    }


}
