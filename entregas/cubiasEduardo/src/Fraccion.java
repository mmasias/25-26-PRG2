public class Fraccion {
    private int numerador;
    private int denominador;

    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    private void simplificar() {
        int numeradorTemporal = this.numerador;
        int denominadorTemporal = this.denominador;

        if (numeradorTemporal < 0) {
            numeradorTemporal = -numeradorTemporal;
        }
        if (denominadorTemporal < 0) {
            denominadorTemporal = -denominadorTemporal;
        }

        int mcd = calcularMCD(numeradorTemporal, denominadorTemporal);

        this.numerador = this.numerador / mcd;
        this.denominador = this.denominador / mcd;

        if (this.denominador < 0) {
            this.numerador = -this.numerador;
            this.denominador = -this.denominador;
        }
    }

    private void sumarFracciones(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        
        if (denominador == this.denominador) {
            this.numerador = this.numerador + numerador;
        } else {
            this.numerador = (this.numerador * denominador) + (numerador * this.denominador);
            this.denominador = this.denominador * denominador;
        }
        this.simplificar();
    }

    public Fraccion(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        this.numerador = numerador;
        this.denominador = denominador;
        this.simplificar();
    }
     
    public Fraccion(int numerador) {
        this(numerador, 1);
    }

    public Fraccion() {
        this(1, 1);
    }

    public void sumar(int numerador, int denominador) {
        this.sumarFracciones(numerador, denominador);
    }
    
    public void sumar(int numerador) {
        this.sumarFracciones(numerador, 1);
    }

    public void sumar(Fraccion otraFraccion) {
        this.sumarFracciones(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void restar(int numerador, int denominador) {
        this.sumarFracciones(-numerador, denominador);
    }

    public void restar(int numerador) {
        this.sumarFracciones(-numerador, 1);
    }

    public void restar(Fraccion otraFraccion) {
        this.sumarFracciones(-otraFraccion.numerador, otraFraccion.denominador);
    }

    public void multiplicar(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        this.numerador = this.numerador * numerador;
        this.denominador = this.denominador * denominador;
        this.simplificar();
    }

    public void multiplicar(int numerador) {
        this.multiplicar(numerador, 1);
    }

    public void multiplicar(Fraccion otraFraccion) {
        this.multiplicar(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void dividir(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        assert numerador != 0 : "No se puede dividir por cero"; 
        
        this.numerador = this.numerador * denominador;
        this.denominador = this.denominador * numerador;
        this.simplificar();
    }

    public void dividir(int numerador) {
        this.dividir(numerador, 1);
    }

    public void dividir(Fraccion otraFraccion) {
        this.dividir(otraFraccion.numerador, otraFraccion.denominador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-this.numerador, this.denominador);
    }

    public Fraccion inversa() {
        assert this.numerador != 0 : "La inversa generaria un denominador 0";
        return new Fraccion(this.denominador, this.numerador);
    }

    public double aDecimal() {
        return (double) this.numerador / this.denominador;
    }

    public String toString() {
        if (this.denominador == 1) {
            return "" + this.numerador;
        }
        return this.numerador + "/" + this.denominador;
    }

    public void mostrar() {
        System.out.println(this.toString());
    }

    public boolean equals(Fraccion otraFraccion) {
        if (otraFraccion == null) {
            return false;
        }
        int producto1 = this.numerador * otraFraccion.denominador;
        int producto2 = otraFraccion.numerador * this.denominador;
        return producto1 == producto2;
    }

    public Fraccion clone() {
        return new Fraccion(this.numerador, this.denominador);
    }

    public String compareTo(Fraccion otraFraccion) {
        if (otraFraccion == null) {
            return "Error: comparacion nula";
        }
        
        int producto1 = this.numerador * otraFraccion.denominador;
        int producto2 = otraFraccion.numerador * this.denominador;
        
        if (producto1 < producto2) {
            return "Menor";
        }
        if (producto1 > producto2) {
            return "Mayor";
        }
        return "Igual";
    }
}
