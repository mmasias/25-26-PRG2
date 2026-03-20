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