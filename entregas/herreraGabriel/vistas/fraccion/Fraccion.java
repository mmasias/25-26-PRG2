package vistas.fraccion;

class Fraccion {
    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador no puede ser cero";
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public Fraccion(int entero) {
        this(entero, 1);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion(Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }

    public Fraccion clone() {
        return new Fraccion(this);
    }

    private void simplificar() {
        int mcd = this.calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public void mostrar() {
        Console console = new Console();
        if (denominador == 1) {
            console.writeln(String.valueOf(numerador));
        } else {
            console.writeln(numerador + "/" + denominador);
        }
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public void recoger() {
        Console console = new Console();
        boolean valido = false;
        do {
            numerador = console.readInt("Numerador?");
            denominador = console.readInt("Denominador?");
            valido = denominador != 0;
            if (!valido) console.writeln("Error: El denominador no puede ser cero.");
        } while (!valido);
        this.simplificar();
    }
}