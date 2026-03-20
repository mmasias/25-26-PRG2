public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador de una fraccion no puede ser cero";
        
        this.numerador = numerador;
        this.denominador = denominador;
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
        return new Fraccion(this.numerador, this.denominador);
    }


        public void sumar(Fraccion fraccion) {
        int numeradorResultado = (this.numerador * fraccion.denominador) + (fraccion.numerador * this.denominador);
        int denominadorResultado = this.denominador * fraccion.denominador;
        
        this.numerador = numeradorResultado;
        this.denominador = denominadorResultado;
    }

    public void restar(Fraccion fraccion) {
        int numeradorResultado = (this.numerador * fraccion.denominador) - (fraccion.numerador * this.denominador);
        int denominadorResultado = this.denominador * fraccion.denominador;
        
        this.numerador = numeradorResultado;
        this.denominador = denominadorResultado;
    }

        public void multiplicar(Fraccion fraccion) {
        this.numerador = this.numerador * fraccion.numerador;
        this.denominador = this.denominador * fraccion.denominador;
    }

    public void dividir(Fraccion fraccion) {
        assert fraccion.numerador != 0 : "No se puede dividir por una fraccion con numerador cero";
        
        int numeradorResultado = this.numerador * fraccion.denominador;
        int denominadorResultado = this.denominador * fraccion.numerador;

        this.numerador = numeradorResultado;
        this.denominador = denominadorResultado;
    }


       public boolean esMayor(Fraccion fraccion) {
        int valorIzquierda = this.numerador * fraccion.denominador;
        int valorDerecha = fraccion.numerador * this.denominador;
        
        return valorIzquierda > valorDerecha;
    }

    public boolean esMenor(Fraccion fraccion) {
        int valorIzquierda = this.numerador * fraccion.denominador;
        int valorDerecha = fraccion.numerador * this.denominador;
        
        return valorIzquierda < valorDerecha;
    }
    private int obtenerMaximoComunDivisor(int numeroA, int numeroB) {
        int temporal;
        int a = Math.abs(numeroA);
        int b = Math.abs(numeroB);
        
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        
        return a;
    }

    public boolean equals(Fraccion fraccion) {
        int valorIzquierda = this.numerador * fraccion.denominador;
        int valorDerecha = fraccion.numerador * this.denominador;
        
        return valorIzquierda == valorDerecha;
    }
        public Fraccion simplificar(Fraccion fraccion) {
        int maximoComunDivisor = obtenerMaximoComunDivisor(fraccion.numerador, fraccion.denominador);
        
        int nuevoNumerador = fraccion.numerador / maximoComunDivisor;
        int nuevoDenominador = fraccion.denominador / maximoComunDivisor;
        
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

      public double decimal(Fraccion fraccion) {
        return (double) fraccion.numerador / fraccion.denominador;
    }



    public String toString(){
       String mensaje = "Soy la fraccion " + numerador + " / " + denominador;
        return mensaje;
    } 
}



