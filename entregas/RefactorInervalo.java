package entregas;

class Intervalo {

    private double puntoMedio;
    private double longitud;

    public Intervalo(double inferior, double superior) {
        assert inferior <= superior;
        this.longitud = superior - inferior;
        this.puntoMedio = inferior + this.longitud / 2;
    }

    public Intervalo(double superior) {
        this(0, superior);
    }

    public Intervalo() {
        this(0, 0);
    }

    public Intervalo(Intervalo intervalo) {
        this.puntoMedio = intervalo.puntoMedio;
        this.longitud = intervalo.longitud;
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    public double longitud() {
        return longitud;
    }

    private double inferior() {
        return puntoMedio - longitud / 2;
    }

    private double superior() {
        return puntoMedio + longitud / 2;
    }

    public void desplazar(double desplazamiento) {
        puntoMedio = puntoMedio + desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {
        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double punto) {
        return inferior() <= punto && punto <= superior();
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior()) &&
            this.incluye(intervalo.superior());
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return this.puntoMedio == intervalo.puntoMedio &&
            this.longitud == intervalo.longitud;
    }

    public void oponer() {
        puntoMedio = -puntoMedio;
    }

    public void doblar() {
        longitud = longitud * 2;
    }

    public double puntoMedio() {
        return puntoMedio;
    }

}

