public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int entero) {
        this.numerador = entero;
        this.denominador = 1;
    }


    public void sumar(Fraccion fraccion) {
        numerador = numerador * fraccion.denominador + fraccion.numerador * denominador;
        denominador = denominador * fraccion.denominador;
    }
    public void restar(Fraccion fraccion){
        numerador = numerador * fraccion.denominador - fraccion.numerador * denominador;
        denominador = denominador * fraccion.denominador;
    }
    public void multiplicar(Fraccion fraccion){
        numerador = numerador * fraccion.numerador;
        denominador = denominador * fraccion.denominador;
    }
    public void dividir(Fraccion fraccion){
        numerador = numerador * fraccion.denominador;
        denominador = denominador * fraccion.numerador;
    }


    public boolean menorQue(Fraccion fraccion){
        return numerador * fraccion.denominador < fraccion.numerador * denominador;
    }
    public boolean mayorQue(Fraccion fraccion){
        return numerador * fraccion.denominador > fraccion.numerador * denominador;
    }


    public boolean equals(Fraccion fraccion){
        return numerador * fraccion.denominador == fraccion.numerador * denominador;
    }



    public void simplificar() {
        int mcd = calcularMCD(numerador, denominador);
        numerador = numerador / mcd;
        denominador = denominador / mcd;
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }
}