package vistas.intervalo;

class Intervalo {

    private double puntoMedio;
    private double longitud;

    public Intervalo(double puntoMedio, double longitud) {
        this.longitud = longitud;
        this.puntoMedio = puntoMedio;

    }

    public Intervalo(double longitud) {
        this(0, longitud);
    }

    public Intervalo() {
        this(0, 0);
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.puntoMedio, intervalo.longitud);
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    public double longitud() {
        return longitud;
    }

    public void desplazar(double desplazamiento) {

        double inferior = puntoMedio - longitud / 2;
        double superior = puntoMedio + longitud / 2;

        inferior = inferior + desplazamiento;
        superior = superior + desplazamiento;

    }

    public Intervalo desplazado(double desplazamiento) {

        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;

        return new Intervalo(puntoMedio + desplazamiento, longitud);
    }

    public boolean incluye(double punto) {

        return puntoMedio - longitud / 2 <= punto && punto <= puntoMedio + longitud / 2;

    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;

        return this.incluye(intervalo.puntoMedio - intervalo.longitud / 2)
                && this.incluye(intervalo.puntoMedio + intervalo.longitud / 2);

    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return this.puntoMedio == intervalo.puntoMedio && this.longitud == intervalo.longitud;

    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.puntoMedio - longitud / 2)
                || this.incluye(intervalo.puntoMedio + longitud / 2)
                || intervalo.incluye(this);
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);
        double inferior = this.puntoMedio - this.longitud / 2;
        double superior = this.puntoMedio + this.longitud / 2;
        double intervaloInferior = intervalo.puntoMedio - longitud / 2;
        double intervaloSuperior = intervalo.puntoMedio + longitud / 2;

        if (this.incluye(intervalo)) {
            return intervalo.clone();
        } else if (intervalo.incluye(this)) {
            return this.clone();
        } else if (this.incluye(intervaloInferior)) {
            return new Intervalo(intervaloInferior, superior);
        } else {
            return new Intervalo(inferior, intervaloSuperior);
        }
    }

    public void oponer() {
        double inferior = this.puntoMedio - this.longitud / 2;
        double superior = this.puntoMedio + this.longitud / 2;
        double superiorInicial = superior;

        superior = -inferior;
        inferior = -superiorInicial;
    }

    public void doblar() {

        longitud = longitud * 2;
    }

    public void mostrar() {
        Console console = new Console();
        double inferior = this.puntoMedio - this.longitud / 2;
        double superior = this.puntoMedio + this.longitud / 2;

        console.writeln("[" + inferior + "," + superior + "]");
    }

    public void recoger() {
        Console console = new Console();
        boolean valido = false;

        do {
            puntoMedio = console.readDouble("Punto medio?");
            longitud = console.readDouble("longitud?");
            valido = longitud > 0;
        } while (!valido);
    }

    public Intervalo[] trocear(int trozos) {
        assert trozos > 1;

        Intervalo[] intervalos = new Intervalo[trozos];
        double inferior = this.puntoMedio - longitud / 2;
        double longitud = this.longitud() / trozos;
        for (int i = 0; i < trozos; i++) {
            intervalos[i] = new Intervalo(inferior, inferior + longitud);
            inferior = inferior + longitud;
        }
        return intervalos;
    }

    public Intervalo union(Intervalo intervalo) {
        assert this.intersecta(intervalo) && !intervalo.incluye(this);
        return this.interseccion(intervalo);
    }

    public double puntoMedio() {
        return puntoMedio;
    }

}
