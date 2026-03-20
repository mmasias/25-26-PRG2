class Fraccion {
    private double numerador;
    private double denominador;

    public Fraccion(double numerador, double denominador) {
        assert denominador != 0 : "El denominador no puede ser 0!";
        this.denominador = denominador;
        this.numerador = numerador;
    }

    public Fraccion(double racional) {
        this(racional, 1);
    }

    public Fraccion clonar() {
        return new Fraccion(numerador,denominador);
    }
    public void mostrar() {
        Console.writeln(numerador);
        Console.writeln("--------");
        Console.writeln(denominador);
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        return new Fraccion(
            numerador * fraccion.numerador,
            denominador * fraccion.denominador
        );
    }
    public Fraccion multiplicar(double numero) {
        return new Fraccion(numerador * numero, denominador);
    }
    public Fraccion dividir(Fraccion fraccion) {
        return new Fraccion(
            numerador * fraccion.denominador,
            denominador * fraccion.numerador
        );
    }
    public Fraccion sumar(Fraccion fraccion) {
        double denominador = calcularMCD(this.denominador, fraccion.denominador);
        double numerador = denominador * (this.numerador + fraccion.numerador);
        return new Fraccion(numerador,denominador); 
    }
    public Fraccion restar(Fraccion fraccion) {
        return this.sumar(fraccion.oponer());
    }

    double calcularMCD(double  a, double b) {
        while (b != 0) {
            double temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }
    public void invertir() {
        numerador = denominador + numerador;
        denominador = numerador - denominador;
        numerador = numerador - denominador;
    }

    public void oponer() {
        numerador = numerador * -1;
    }
}