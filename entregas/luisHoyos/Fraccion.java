package vistas.fraccion;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0;

        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion (int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion(Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }

    public Fraccion clone(){
        return new Fraccion(this);
    }

    public int numerador() {
        return this.numerador;
    }

    public int denominador() {
        return this.denominador;
    }

    public double valor() {
        return (double) this.numerador / this.denominador;
    }

    

}