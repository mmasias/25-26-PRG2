public class Fraccion implements Comparable<Fraccion>, Cloneable {

    private int numerador;
    private int denominador;

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        normalizar();
    }

    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion(Fraccion otra) {
        this(otra.numerador, otra.denominador);
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
        normalizar();
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser 0.");
        }
        this.denominador = denominador;
        normalizar();
    }

    public Fraccion sumar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador + otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restar(Fraccion otra) {
        int nuevoNumerador = this.numerador * otra.denominador - otra.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otra.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(this.numerador * otra.numerador, this.denominador * otra.denominador);
    }

    public Fraccion dividir(Fraccion otra) {
        if (otra.numerador == 0) {
            throw new ArithmeticException("No se puede dividir entre 0.");
        }
        return new Fraccion(this.numerador * otra.denominador, this.denominador * otra.numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion inversa() {
        if (this.numerador == 0) {
            throw new ArithmeticException("La fracción 0 no tiene inversa.");
        }
        return new Fraccion(this.denominador, this.numerador);
    }

    public double aDecimal() {
        return (double) this.numerador / this.denominador;
    }

    public boolean esCero() {
        return this.numerador == 0;
    }

    public int compareTo(Fraccion otra) {
        long izquierda = (long) this.numerador * otra.denominador;
        long derecha = (long) otra.numerador * this.denominador;
        return Long.compare(izquierda, derecha);
    }

    public boolean menorQue(Fraccion otra) {
        return this.compareTo(otra) < 0;
    }

    public boolean mayorQue(Fraccion otra) {
        return this.compareTo(otra) > 0;
    }

    public boolean menorOIgualQue(Fraccion otra) {
        return this.compareTo(otra) <= 0;
    }

    public boolean mayorOIgualQue(Fraccion otra) {
        return this.compareTo(otra) >= 0;
    }

    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador);
        }
        return numerador + "/" + denominador;
    }

    public Fraccion clone() {
        return new Fraccion(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraccion)) return false;
        Fraccion otra = (Fraccion) obj;
        return this.numerador == otra.numerador && this.denominador == otra.denominador;
    }

    public int hashCode() {
        int resultado = Integer.hashCode(numerador);
        resultado = 31 * resultado + Integer.hashCode(denominador);
        return resultado;
    }

    private void normalizar() {
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }

        if (numerador == 0) {
            denominador = 1;
            return;
        }

        int mcd = calcularMCD(Math.abs(numerador), Math.abs(denominador));
        numerador /= mcd;
        denominador /= mcd;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }
}
