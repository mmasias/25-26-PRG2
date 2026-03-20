public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero.";
        this.numerador = numerador;
        this.denominador = denominador;
    }
    public Fraccion(Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }
    public Fraccion(int numerador) {
            this(numerador, 1);
    }
    public Fraccion(){
        this(0, 1);
    }

    public Fraccion clonar(){
        return new Fraccion(this);
    }
    public Fraccion valorAbsoluto(){
        return new Fraccion(Math.abs(numerador), Math.abs(denominador));
    }

    public void mostrar() {
        Console console = new Console();
        console.writeln(numerador + "/" + denominador);
    }
    
    public void invertir() {
        int auxiliar = this.numerador;
        this.numerador = this.denominador;
        this.denominador = auxiliar;
    }
    public void oponer() {
        this.numerador = -this.numerador;
    }

    public Fraccion sumar(Fraccion fraccion) {
        int numerador = (this.numerador * fraccion.denominador) + (this.denominador * fraccion.numerador);
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
    }
    public Fraccion restar(Fraccion fraccion) {
        int numerador = (this.numerador * fraccion.denominador) - (this.denominador * fraccion.numerador);
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
    }
    public Fraccion multiplicar(Fraccion fraccion) {
        int numerador = this.numerador * fraccion.numerador;
        int denominador = this.denominador * fraccion.denominador;
        return new Fraccion(numerador, denominador);
    }
    public Fraccion dividir(Fraccion fraccion) {
        int numerador = this.numerador * fraccion.denominador;
        int denominador = this.denominador * fraccion.numerador;
        return new Fraccion(numerador, denominador);
    }
    public Fraccion exponenciar(int exponente) {
        int numerador = (int) Math.pow(this.numerador, exponente);
        int denominador = (int) Math.pow(this.denominador, exponente);
        return new Fraccion(numerador, denominador);
    }
    public boolean equals(Fraccion fraccion) {
        return !this.esMayor(fraccion) && !this.esMenor(fraccion);
    }
    public boolean esMayor(Fraccion fraccion) {
        return (this.numerador * fraccion.denominador) > (this.denominador * fraccion.numerador);
    }
    public boolean esMenor(Fraccion fraccion) {
        return (this.numerador * fraccion.denominador) < (this.denominador * fraccion.numerador);
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

} 