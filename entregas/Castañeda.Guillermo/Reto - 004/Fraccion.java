public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            denominador = 1;
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public Fraccion(int numero) {
        this.numerador = numero;
        this.denominador = 1;
    }

    public Fraccion(Fraccion fraccion) {
        this.numerador = fraccion.numerador;
        this.denominador = fraccion.denominador;
    }

    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion clonar() {
        return new Fraccion(this);
    }

    private int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void simplificar() {
        int m = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= m;
        denominador /= m;
    }

    public void sumar(Fraccion fraccion) {
        numerador = numerador * fraccion.denominador + fraccion.numerador * denominador;
        denominador = denominador * fraccion.denominador;
        simplificar();
    }

    public void restar(Fraccion fraccion) {
        numerador = numerador * fraccion.denominador - fraccion.numerador * denominador;
        denominador = denominador * fraccion.denominador;
        simplificar();
    }

    public void multiplicar(Fraccion fraccion) {
        numerador = numerador * fraccion.numerador;
        denominador = denominador * fraccion.denominador;
        simplificar();
    }

    public void dividir(Fraccion fraccion) {
        numerador = numerador * fraccion.denominador;
        denominador = denominador * fraccion.numerador;
        simplificar();
    }

    public boolean esMayor(Fraccion fraccion) {
        return numerador * fraccion.denominador > fraccion.numerador * denominador;
    }

    public boolean esMenor(Fraccion fraccion) {
        return numerador * fraccion.denominador < fraccion.numerador * denominador;
    }

    public boolean equals(Fraccion fraccion) {
        return numerador == fraccion.numerador && denominador == fraccion.denominador;
    }

    public void mostrar() {
        System.out.println(numerador + "/" + denominador);
    }

    public void invertir() {
        int temp = numerador;
        numerador = denominador;
        denominador = temp;
    }
}