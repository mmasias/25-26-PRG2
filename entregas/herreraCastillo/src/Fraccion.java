public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "El denominador de una fraccion no puede ser cero";
        
        this.numerador = numerador;
        this.denominador = denominador;
    }
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
}
        public void multiplicar(Fraccion fraccion){}
        public void dividir(Fraccion fraccion){}

        public boolean esMayor(Fraccion fraccion){}
        public boolean esMenor(Fraccion fraccion){ }
        
        public boolean equals(Fraccion fraccion){}

        public Fraccion simplificar (Fraccion fraccion){}

        public double decimal(Fraccion fraccion){}



    public String toString(){
       String mensaje = "Hola soy la fraccion " + numerador + " / " + denominador;
        return mensaje;
    }



}
