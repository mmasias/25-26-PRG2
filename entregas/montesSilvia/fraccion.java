package vistas.fraccion;
public class Fraccion {
    private int numerador;
    private int denominador;


    public Fraccion (int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = (denominador == 0) ? 1 : denominador; 
        simplificar();
    }
    public Fraccion (int numero) {
        this(numero, 1);
    }
    public Fraccion ( Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }
    public Fraccion () {
        this(0, 1);
    }

    private void simplificar() {
        int mcd = maximoComunDivisor(Math.abs(numerador), Math.abs(denominador));
        numerador= mcd;
        denominador= mcd;
        
        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int maximoComunDivisor(int a, int b) {
        return (b == 0) ? a : maximoComunDivisor(b, a % b);
    }


    public Fraccion clonar () {
        return new Fraccion(this);
    }
    public void sumar (Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        simplificar();
    }
    public void restar (Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        simplificar();
    }
    public void multiplicar (Fraccion fraccion) {
        this.numerador *= fraccion.numerador;
        this.denominador *= fraccion.denominador;
        simplificar();
    }
    public void dividir (Fraccion fraccion) {
        if (fraccion.numerador != 0) {
            this.numerador *= fraccion.denominador;
            this.denominador *= fraccion.numerador;
            simplificar();
        }
    }
    public void potenciar (int exponente) {
        if (exponente < 0) {
            invertir();
            exponente = Math.abs(exponente);
        }
        this.numerador = (int) Math.pow(this.numerador, exponente);
        this.denominador = (int) Math.pow(this.denominador, exponente);
        simplificar();
    }
    public boolean esMayor (Fraccion fraccion) {
        return (this.numerador * fraccion.denominador) > (fraccion.numerador * this.denominador);
    }
    public boolean esMenor (Fraccion fraccion) {
        return (this.numerador * fraccion.denominador) < (fraccion.numerador * this.denominador);
    }
    public boolean equals (Fraccion fraccioN) {
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }
    public void mostrar () {
        if (denominador == 1) {
            System.out.println(numerador);
        } else {
            System.out.println(numerador + "/" + denominador);
        }
    }
    public void invertir () {
        if (numerador != 0) {
            int aux = numerador;
            numerador = denominador;
            denominador = aux;
            simplificar();
        }
    }
    public void oponer () {
        this.numerador = -this.numerador;
    }
    
    
    
    



}