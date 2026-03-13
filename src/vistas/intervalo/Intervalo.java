package vistas.intervalo;

class Intervalo {

    private double puntoMedio;
    private double longitud;

    public Intervalo(double inferior, double superior) {
        assert inferior <= superior;
        longitud = (superior - inferior);
        puntoMedio = inferior + longitud / 2;
    }

    public Intervalo(double superior) {
        this(0, superior);
    }

    public Intervalo() {
        this(0, 0);
    }

    public Intervalo(Intervalo intervalo) {
        this();
        this.puntoMedio = intervalo.puntoMedio;
        this.longitud = intervalo.longitud;
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    private double getSuperior() {
        return puntoMedio + longitud / 2;
    }

    private double getInferior() {
        return puntoMedio - longitud / 2;
    }

    public double longitud() {
        return longitud;
    }

    public void desplazar(double desplazamiento) {
        this.puntoMedio += desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {

        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double punto) {
        return this.getInferior() <= punto && punto <= this.getSuperior();
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.getInferior()) &&
                this.incluye(intervalo.getSuperior());
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return this.getInferior() == intervalo.getInferior() &&
                this.getSuperior() == intervalo.getSuperior();
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

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.getInferior()) ||
                this.incluye(intervalo.getSuperior()) ||
                intervalo.incluye(this);
    }

    public void oponer() {
        this.puntoMedio = -this.puntoMedio;
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
        double inferior, superior;
        do {
            inferior = console.readDouble("Valor inferior?");
            superior = console.readDouble("Valor superior?");
            valido = superior >= inferior;
        } while (!valido);
        this.set(inferior, superior);
    }

    private void set(double inferior, double superior) {
        Intervalo intervalo = new Intervalo(inferior, superior);
        this.puntoMedio=intervalo.puntoMedio;
        this.longitud = intervalo.longitud;
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
        assert this.intersecta(intervalo);
        double nuevoInferior = Math.min(this.getInferior(), intervalo.getInferior());
        double nuevoSuperior = Math.max(this.getSuperior(), intervalo.getSuperior());
        return new Intervalo(nuevoInferior, nuevoSuperior);
    }

    public double puntoMedio() {
        return this.getInferior() + this.longitud() / 2;
    }

}