public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "Error. No puedes declarar el denominador como 0";
        this.numerador = numerador;
        this.denominador = denominador;
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

    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";

        int nuevoNumerador = (this.numerador * fraccion.denominador) + (this.denominador * fraccion.numerador);
        int nuevoDenominador = this.denominador * fraccion.denominador;

        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;
        return this;
    }

    public Fraccion restar(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";

        fraccion.oponer();

        this.sumar(fraccion);

        fraccion.oponer();

        return this;
    }

    public Fraccion multiplicar(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";

        int nuevoNumerador = this.numerador * fraccion.numerador;
        int nuevoDenominador = this.denominador * fraccion.denominador;

        this.numerador = nuevoNumerador;
        this.denominador = nuevoDenominador;

        return this;
    }

    public Fraccion dividir(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        assert fraccion.numerador != 0 : "El numerador no puede ser cero";

        fraccion.invertir();

        this.multiplicar(fraccion);

        fraccion.invertir();

        return this;
    }

    private int compararFracciones(Fraccion fraccion) {
        return (this.numerador * fraccion.denominador) - (this.denominador * fraccion.numerador);
    }

    public boolean esMayorQueFraccion(Fraccion fraccion) {
        return compararFracciones(fraccion) > 0;
    }

    public boolean esMenorQueFraccion(Fraccion fraccion) {
        return compararFracciones(fraccion) < 0;
    }

    public boolean esMayorQueNumero(int numero) {
        return esMayorQueFraccion(new Fraccion(numero));
    }

    public boolean esMenorQueNumero(int numero) {
        return esMenorQueFraccion(new Fraccion(numero));
    }

    public boolean esIgualFraccion(Fraccion fraccion) {
        return compararFracciones(fraccion) == 0;
    }

    public boolean esIgualNumero(int numero) {
        return esIgualFraccion(new Fraccion(numero));
    }

    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    public Fraccion invertir() {
        assert this.numerador != 0 : "No se puede invertir una fracción con numerador 0";

        int auxiliar = this.numerador;
        this.numerador = this.denominador;
        this.denominador = auxiliar;

        return this;
    }

    public Fraccion oponer() {
        this.numerador *= -1;

        return this;
    }

    private int calcularMCD(int numerador, int denominador) {
        while (denominador != 0) {
            int temporal = denominador;
            denominador = numerador % denominador;
            numerador = temporal;
        }
        return numerador;
    }

    public Fraccion simplificar() {
        int maximoComunDivisor = calcularMCD(numerador, denominador);

        this.numerador /= maximoComunDivisor;
        this.denominador /= maximoComunDivisor;

        return this;
    }
}