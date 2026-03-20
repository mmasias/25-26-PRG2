public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) throw new IllegalArgumentException("Denominador no puede ser 0");
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public Fraccion (int numero){
        this.numerador = numero;
        this.denominador = 1;
    } 

    public Fraccion(Fraccion fraccion){
        this.numerador = fraccion.numerador;
        this.denominador = fraccion.denominador;
    }

    public Fraccion(){
        this.numerador = 0;
        this.denominador = 1;
    }

    public Fraccion clonar(){
        return new Fraccion(this);
    }

    public void sumar (Fraccion fraccion){
        this.numerador = this.numerador * fraccion.denominador + fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        simplificar();
    }

    public void restar(Fraccion fraccion){
        this.numerador = this.numerador * fraccion.denominador - fraccion.numerador * this.denominador;
        this.denominador = this.denominador * fraccion.denominador;
        simplificar();
    }

    public void multiplicar(Fraccion fraccion){
        this.numerador *= fraccion.numerador;
        this.denominador *= fraccion.denominador;
        simplificar();
    }

    public void dividir(Fraccion fraccion){
        if (fraccion.numerador == 0) throw new IllegalArgumentException("División por 0");
        this.numerador *= fraccion.denominador;
        this.denominador *= fraccion.numerador;
        simplificar();
    }

    public boolean esMayor (Fraccion fraccion){
        return this.numerador * fraccion.denominador > fraccion.numerador * this.denominador;
    }

    public boolean esMenor (Fraccion fraccion){
        return this.numerador * fraccion.denominador < fraccion.numerador * this.denominador;
    }

    public boolean equals(Fraccion fraccion){
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }

    public String toString(){
        return this.numerador + "/" + this.denominador;
    }

    public void Invertir(){
        if (this.numerador == 0) throw new IllegalArgumentException("No se puede invertir 0");
        int temp = this.numerador;
        this.numerador = this.denominador;
        this.denominador = temp;
    }