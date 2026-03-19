public class Fraccion{
	private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        validarDenominador(denominador);
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }

    public Fraccion(int numero) {
        this(numero, 1);
    }

    public Fraccion(Fraccion fraccion) {
        this(fraccion.numerador, fraccion.denominador);
    }

    public Fraccion() {
        this(0, 1);
    }

    public Fraccion clonar(){
        return new Fraccion(this);
    }

    public void sumar(Fraccion fraccion){
        this.numerador = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void restar(Fraccion fraccion){
        this.numerador = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void multiplicar(Fraccion fraccion){
        this.numerador = this.numerador * fraccion.numerador;
        this.denominador = this.denominador * fraccion.denominador;
        this.simplificar();
    }

    public void dividir(Fraccion fraccion){
        validarDenominador(fraccion.numerador);
        this.numerador = this.numerador * fraccion.denominador;
        this.denominador = this.denominador * fraccion.numerador;
        this.simplificar();
    }

    public boolean esMayor(Fraccion fraccion){
        return (this.numerador * fraccion.denominador) > (fraccion.numerador * this.denominador);
    }

    public boolean esMenor(Fraccion fraccion){
        return (this.numerador * fraccion.denominador) < (fraccion.numerador * this.denominador);
    }

    public boolean equals(Fraccion fraccion){
        return this.numerador == fraccion.numerador && this.denominador == fraccion.denominador;
    }

    public void mostrar(){
        if (this.denominador == 1) {
            System.out.println(this.numerador);
        } else {
            System.out.println(this.numerador + "/" + this.denominador);
        }
    }

    private void validarDenominador(int posibleDenominador) {
        assert posibleDenominador != 0 : "El cero no puede ser el denominador";
    }

    public void invertir(){
        validarDenominador(this.numerador);
        int denominadorTemporal = this.numerador;
        this.numerador = this.denominador;
        this.denominador = denominadorTemporal;
        this.simplificar();
    }

    private int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private void simplificar() {
        int mcd = calcularMCD(this.numerador, this.denominador);
        this.numerador /= mcd;
        this.denominador /= mcd;
        
        if (this.denominador < 0) {
            this.numerador = -this.numerador;
            this.denominador = -this.denominador;
        }
    }
}