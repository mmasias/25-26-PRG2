public class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0;
        this.numerador = numerador;
        this.denominador = denominador;
        normalizarSigno();
        simplificar();
    }

    public Fraccion(int numerador) {
    this(numerador, 1);
    }


    public Fraccion(Fraccion otra) {
        assert otra != null;
        this(otra.numerador, otra.denominador);
    }


    public String toString() {
        return numerador + "/" + denominador;
    }


    public double toDecimal() {
        return (double) numerador / denominador;
    }


    public int calcularMCD(int a, int b) {
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

    public boolean esIgual(Fraccion fraccion) {
        assert fraccion != null : "La fracción no puede ser nula";
        return this.numerador * fraccion.denominador == this.denominador * fraccion.numerador;
    }


    public Fraccion sumar(Fraccion fraccion) {
        assert fraccion != null;
        int mcm = calcularMCM(this.denominador, fraccion.denominador);
        int sumaNumerador = this.numerador * (mcm / this.denominador)
                           + fraccion.numerador * (mcm / fraccion.denominador);
        return new Fraccion(sumaNumerador, mcm);
    }

    public Fraccion restar(Fraccion fraccion) {
        assert fraccion != null;
        int mcm = calcularMCM(this.denominador, fraccion.denominador);
        int restaNumerador = this.numerador * (mcm / this.denominador)
                            - fraccion.numerador * (mcm / fraccion.denominador);
        return new Fraccion(restaNumerador, mcm);
    }

     public Fraccion multiplicar(Fraccion fraccion) {
        assert fraccion != null;
        return new Fraccion(this.numerador * fraccion.numerador,
                            this.denominador * fraccion.denominador);
    }

     public Fraccion dividir(Fraccion fraccion) {
        assert fraccion != null && fraccion.numerador != 0 : "No se puede dividir por 0";
        return new Fraccion(this.numerador * fraccion.denominador,
                            this.denominador * fraccion.numerador);
    }


    public double inversa() {
        assert numerador != 0 : "No se puede invertir una fracción con numerador 0";
        return (double) denominador / numerador;

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public boolean esPropia() {
        return Math.abs(numerador) < denominador;
    }

        private void normalizarSigno() {
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private void simplificar() {
        int mcd = calcularMCD(Math.abs(numerador), denominador);
        numerador /= mcd;
        denominador /= mcd;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private int calcularMCM(int a, int b) {
        return (a * b) / calcularMCD(a, b);
    }
}