class Fraccion {
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
        int numeradorTemporal = numerador;
        int denominadorTemporal = denominador;

        if (numeradorTemporal < 0) {
            numeradorTemporal = -numeradorTemporal;
        }
        if (denominadorTemporal < 0) {
            denominadorTemporal = -denominadorTemporal;
        }

        int mcd = calcularMCD(numeradorTemporal, denominadorTemporal);

        numerador = numerador / mcd;
        denominador = denominador / mcd;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
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
        sumarFracciones(numerador, denominador);
    }
    
    public void sumar(int numerador) {
        sumarFracciones(numerador, 1);
    }

    public void sumar(Fraccion otraFraccion) {
        sumarFracciones(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void restar(int numerador, int denominador) {
        sumarFracciones(-numerador, denominador);
    }

    public void restar(int numerador) {
        sumarFracciones(-numerador, 1);
    }

    public void restar(Fraccion otraFraccion) {
        sumarFracciones(-otraFraccion.numerador, otraFraccion.denominador);
    }

    public void multiplicar(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        this.numerador = this.numerador * numerador;
        this.denominador = this.denominador * denominador;
        simplificar();
    }

    public void multiplicar(int numerador) {
        multiplicar(numerador, 1);
    }

    public void multiplicar(Fraccion otraFraccion) {
        multiplicar(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void dividir(int numerador, int denominador) {
        assert denominador != 0 : "Denominador invalido";
        assert numerador != 0 : "No se puede dividir por cero"; 
        
        this.numerador = this.numerador * denominador;
        this.denominador = this.denominador * numerador;
        simplificar();
    }

    public void dividir(int numerador) {
        dividir(numerador, 1);
    }

    public void dividir(Fraccion otraFraccion) {
        dividir(otraFraccion.numerador, otraFraccion.denominador);
    }

    public Fraccion opuesta() {
        return new Fraccion(-numerador, denominador);
    }

    public Fraccion inversa() {
        assert numerador != 0 : "La inversa generaria un denominador 0";
        return new Fraccion(denominador, numerador);
    }

    public double aDecimal() {
        return (double) numerador / denominador;
    }

    public String toString() {
        if (denominador == 1) {
            return "" + numerador;
        }
        return numerador + "/" + denominador;
    }

    public void mostrar() {
        System.out.println(toString());
    }

    public boolean equals(Fraccion otraFraccion) {
        if (otraFraccion == null) {
            return false;
        }
        int producto1 = numerador * otraFraccion.denominador;
        int producto2 = otraFraccion.numerador * denominador;
        return producto1 == producto2;
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }

    public String compareTo(Fraccion otraFraccion) {
        assert otraFraccion != null : "La fraccion es null";
        
        int producto1 = numerador * otraFraccion.denominador;
        int producto2 = otraFraccion.numerador * denominador;
        
        if (producto1 < producto2) {
            return "Menor";
        }
        if (producto1 > producto2) {
            return "Mayor";
        }
        return "Igual";
    }
}
