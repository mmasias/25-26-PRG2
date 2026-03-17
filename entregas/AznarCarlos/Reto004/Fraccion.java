package entregas.AznarCarlos.Reto004;

class Fraccion {

    private int numerador;
    private int denominador;

    Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    int getNumerador() {
        return numerador;
    }

    void setNumerador(int numerador) {
        this.numerador = numerador;
        simplificar();
    }

    int getDenominador() {
        return denominador;
    }

    void setDenominador(int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.denominador = denominador;
        simplificar();
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void simplificar() {
        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    Fraccion inversa() {
        if (this.numerador == 0) {
            throw new ArithmeticException("No se puede invertir una fracción con numerador cero.");
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    Fraccion sumar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    Fraccion restar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    Fraccion multiplicar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.numerador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    Fraccion dividir(Fraccion otra) {
        if (otra.numerador == 0) {
            throw new ArithmeticException("No se puede dividir por una fracción con numerador cero.");
        }
        int nuevoNumerador = this.numerador * otra.denominador;
        int nuevoDenominador = this.denominador * otra.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    double aDecimal() {
        return (double) numerador / denominador;
    }

    int compararCon(Fraccion otra) {
        double valor1 = this.aDecimal();
        double valor2 = otra.aDecimal();

        if (valor1 < valor2) {
            return -1;
        } else if (valor1 > valor2) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraccion)) return false;
        Fraccion fraccion = (Fraccion) obj;
        return numerador == fraccion.numerador && denominador == fraccion.denominador;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + numerador;
        result = 31 * result + denominador;
        return result;
    }

    Fraccion copiar() {
        return new Fraccion(this.numerador, this.denominador);
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    static void main(String[] args) {
        Fraccion f1 = new Fraccion(1, 2);
        Fraccion f2 = new Fraccion(1, 4);

        System.out.println("Fracción 1: " + f1);
        System.out.println("Fracción 2: " + f2);

        Fraccion suma = f1.sumar(f2);
        System.out.println("Suma: " + suma);

        Fraccion producto = f1.multiplicar(f2);
        System.out.println("Producto: " + producto);

        double decimal = f1.aDecimal();
        System.out.println("Decimal: " + decimal);
    }
}