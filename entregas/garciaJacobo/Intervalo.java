
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

        puntoMedio = puntoMedio + desplazamiento;

    }

    public Intervalo desplazado(double desplazamiento) {

        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;

    }

    public boolean incluye(double punto) {

        return getInferior() <= punto && punto <= getSuperior();

    }

    private double getSuperior() {
        return puntoMedio + longitud / 2;
    }

    private double getInferior() {
        return puntoMedio - longitud / 2;
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;

        return this.incluye(intervalo.getInferior())
                && this.incluye(intervalo.getSuperior());

    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return this.puntoMedio == intervalo.puntoMedio && this.longitud == intervalo.longitud;

    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.getInferior()) ||
                this.incluye(intervalo.getSuperior()) ||
                intervalo.incluye(this);
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);
        if (this.incluye(intervalo)) {
            return intervalo.clone();
        } else if (intervalo.incluye(this)) {
            return this.clone();
        } else if (this.incluye(intervalo.getInferior())) {
            return new Intervalo(intervalo.getInferior(), getSuperior());
        } else {
            return new Intervalo(getInferior(), intervalo.getSuperior());
        }
    }

    public void oponer() {
        puntoMedio = -puntoMedio;
    }

    public void doblar() {

        longitud = longitud * 2;
    }

    public void mostrar() {
        Console console = new Console();

        console.writeln("[" + this.getInferior() + "," + this.getSuperior() + "]");
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
        double inferior = this.getInferior();
        double longitud = this.longitud() / trozos;
        for (int i = 0; i < trozos; i++) {
            intervalos[i] = new Intervalo(inferior, inferior + longitud);
            inferior = inferior + longitud;
        }
        return intervalos;
    }

    public Intervalo union(Intervalo intervalo) {
        double nuevoInferior = Math.min(this.getInferior(), intervalo.getInferior());
        double nuevoSuperior = Math.max(this.getSuperior(), intervalo.getSuperior());
        double nuevoPuntoMedio = (nuevoSuperior + nuevoInferior) / 2;
        double nuevaLongitud = nuevoSuperior - nuevoInferior;
        return new Intervalo(nuevoPuntoMedio, nuevaLongitud);
    }

    public double puntoMedio() {
        return puntoMedio;
    }

}