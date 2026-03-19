public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion() {
        this.numerador = 1;
        this.denominador = 1;
    }

    public Fraccion(int numerador, int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("No se permite la división entre 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Fraccion(int numerador) {

        this.numerador = numerador;
        this.denominador = 1;
    }

    public String toString() {
        System.out.println(numerador/denominador);
        if (numerador*1.0 / denominador >= 0)
            return  Math.abs(numerador) + (Math.abs(denominador) == 1 ? "" : "/" + Math.abs(denominador));
        else
            return "-" + Math.abs(numerador) + (Math.abs(denominador) == 1 ? "" : "/" + Math.abs(denominador));
    }

    public Fraccion inversa() {
        return new Fraccion(this.denominador, this.numerador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion sumar(Fraccion f){
        return new Fraccion(this.numerador*f.denominador+this.denominador*f.numerador,this.denominador*f.denominador).simplificar();
    }

    private int calcularMCD(int a, int b) {
    while (b != 0) {
        int temporal = b;
        b = a % b;
        a = temporal;
    }
    return a;
}

    public Fraccion simplificar(){
        int mcd=calcularMCD(this.numerador, this.denominador);
        return new Fraccion(this.numerador/mcd,this.denominador/mcd);
    }
    public Fraccion restar(Fraccion f){
        return new Fraccion(this.numerador*f.denominador-this.denominador*f.numerador,this.denominador*f.denominador).simplificar();
    }

    protected Fraccion clone() {
        return new Fraccion(this.numerador,this.denominador);
    }

    public Fraccion multiplicar(Fraccion f){
        return new Fraccion(this.numerador*f.numerador,this.denominador*f.denominador).simplificar();
    }

    public Fraccion dividir(Fraccion f){
        return new Fraccion(this.numerador*f.denominador,this.denominador*f.numerador).simplificar();
    }

    public double decimal(){
        return 1.0*numerador/denominador;
    }
    
}
