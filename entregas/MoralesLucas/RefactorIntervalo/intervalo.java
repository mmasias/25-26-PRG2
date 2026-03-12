package vistas.intervalo;

class Intervalo {

    private double puntoMedio;
    private double longitud;

    public Intervalo(double puntoMedio, double longitud) {
        this.puntoMedio = puntoMedio;
        this.longitud = longitud;
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

    public double puntoMedio() {
        return puntoMedio;
    }

    public void desplazar(double desplazamiento) {
        puntoMedio = puntoMedio + desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {
        return new Intervalo(puntoMedio + desplazamiento, longitud);
    }

    public boolean incluye(double punto) {
        double inferior = puntoMedio - longitud / 2;
        double superior = puntoMedio + longitud / 2;
        return inferior <= punto && punto <= superior;
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;

        double inferior = intervalo.puntoMedio - intervalo.longitud / 2;
        double superior = intervalo.puntoMedio + intervalo.longitud / 2;

        return this.incluye(inferior) && this.incluye(superior);
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return this.puntoMedio == intervalo.puntoMedio &&
               this.longitud == intervalo.longitud;
    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;

        double inferior = intervalo.puntoMedio - intervalo.longitud / 2;
        double superior = intervalo.puntoMedio + intervalo.longitud / 2;

        return this.incluye(inferior)
                || this.incluye(superior)
                || intervalo.incluye(this);
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);

        double inferior1 = this.puntoMedio - this.longitud / 2;
        double superior1 = this.puntoMedio + this.longitud / 2;

        double inferior2 = intervalo.puntoMedio - intervalo.longitud / 2;
        double superior2 = intervalo.puntoMedio + intervalo.longitud / 2;

        double inferior = Math.max(inferior1, inferior2);
        double superior = Math.min(superior1, superior2);

        double nuevoPuntoMedio = (inferior + superior) / 2;
        double nuevaLongitud = superior - inferior;

        return new Intervalo(nuevoPuntoMedio, nuevaLongitud);
    }

    public void oponer() {
        puntoMedio = -puntoMedio;
    }

    public void doblar() {
        longitud = longitud * 2;
    }

    public void mostrar() {
        Console console = new Console();

        double inferior = puntoMedio - longitud / 2;
        double superior = puntoMedio + longitud / 2;

        console.writeln("[" + inferior + "," + superior + "]");
    }

    public void recoger() {
        Console console = new Console();
        boolean valido;

        do {
            puntoMedio = console.readDouble("Punto medio?");
            longitud = console.readDouble("Longitud?");
            valido = longitud > 0;
        } while (!valido);
    }

    public Intervalo[] trocear(int trozos) {
        assert trozos > 1;

        Intervalo[] intervalos = new Intervalo[trozos];

        double inferior = puntoMedio - longitud / 2;
        double nuevaLongitud = longitud / trozos;

        for (int i = 0; i < trozos; i++) {
            double nuevoPuntoMedio = inferior + nuevaLongitud / 2;
            intervalos[i] = new Intervalo(nuevoPuntoMedio, nuevaLongitud);
            inferior = inferior + nuevaLongitud;
        }

        return intervalos;
    }

    public Intervalo union(Intervalo intervalo) {
        assert this.intersecta(intervalo);

        double inferior1 = this.puntoMedio - this.longitud / 2;
        double superior1 = this.puntoMedio + this.longitud / 2;

        double inferior2 = intervalo.puntoMedio - intervalo.longitud / 2;
        double superior2 = intervalo.puntoMedio + intervalo.longitud / 2;

        double inferior = Math.min(inferior1, inferior2);
        double superior = Math.max(superior1, superior2);

        double nuevoPuntoMedio = (inferior + superior) / 2;
        double nuevaLongitud = superior - inferior;

        return new Intervalo(nuevoPuntoMedio, nuevaLongitud);
    }
}