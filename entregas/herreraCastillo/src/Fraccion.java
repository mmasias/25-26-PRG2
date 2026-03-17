    public class Fraccion {
        
        private int numerador;
        private int denominador;

        public Fraccion(int numerador, int denominador){
            this.numerador = numerador;
            this.denominador = denominador;     
        }
        public Fraccion (Fraccion fraccion){}
        public Fraccion(){}

        public Fraccion clonar(){
            
        }

        public void sumar(Fraccion fraccion){}
        public void restar(Fraccion fraccion){}
        public void multiplicar(Fraccion fraccion){}
        public void dividir(Fraccion fraccion){}

        public boolean esMayor(Fraccion fraccion){}
        public boolean esMenor(){Fraccion fraccion}
        
        public boolean equals(Fraccion fraccion){}

        public Fraccion simplificar (Fraccion fraccion){}

        public double decimal(Fraccion fraccion){}



    public String toString(){
       String mensaje = "Hola soy la fraccion " + numerador + " / " + denominador;
        return mensaje;
    }



}
