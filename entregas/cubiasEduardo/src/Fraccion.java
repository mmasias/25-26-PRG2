class Fraccion {
    private int numerador;
    private int denominador;

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
        this(0);
    }

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

        int mcd = this.calcularMCD(numeradorTemporal, denominadorTemporal);

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

    private void multiplicarFracciones(int numerador, int denominador){
        assert denominador != 0 : "Denominador invalido";
        this.numerador = numerador * this.numerador;
        this.denominador = denominador * this.denominador;
        this.simplificar();
    }

    public void sumar(Fraccion otraFraccion) {
        this.sumarFracciones(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void restar(Fraccion otraFraccion) {
        this.sumarFracciones(-otraFraccion.numerador, otraFraccion.denominador);
    }

    public void multiplicar(Fraccion otraFraccion) {
        this.multiplicarFracciones(otraFraccion.numerador, otraFraccion.denominador);
    }

    public void dividir(Fraccion otraFraccion) {
        assert denominador != 0 : "Denominador invalido";
        assert numerador != 0 : "No se puede dividir por cero";
        this.multiplicarFracciones(otraFraccion.denominador, otraFraccion.numerador);
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
        int producto1 = numerador * otraFraccion.denominador;
        int producto2 = otraFraccion.numerador * denominador;
        return producto1 == producto2;
    }

    public Fraccion clone() {
        return new Fraccion(numerador, denominador);
    }

    public String compareTo(Fraccion otraFraccion) {
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
