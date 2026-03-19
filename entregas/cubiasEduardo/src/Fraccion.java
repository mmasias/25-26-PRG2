class Fraccion {
    private int numerador;
    private int denominador;
    
    public Fraccion(int numerador, int denominador)
    {
	validarDenominador(denominador);
        numerador = this.numerador;
        denominador = this.denominador;
    }
     
    public Fraccion(int numerador)
    {
        this(numerador, 1);
    }

    public Fraccion()
    {
        this(1,1);
    }

   private void validarDenominador(int denominador){
      assert denoniminador != 0 : "Denominador invalido"; 
  }

    public void sumar(int numerador, int denominador){
	
        this.sumarFracciones(numerador, denominador);
    }
    
    public void sumar(int numerador){
        this.sumarFracciones(numerador, 1);
    }


    private void sumarFracciones(int numerador, int denominador){
       validarDenominador(denominador);
        if(denominador == this.denominador){
            this.numerador = this.numerador + numerador;
            this.denominador = denominador;
        }
        else{
            this.numerador = (this.numerador * denominador) + (numerador * this.denominador);
            this.denominador = this.denominador * denominador;
        }
    }

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

   
}
