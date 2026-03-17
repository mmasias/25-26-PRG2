package vistas.intervalo;

class Intervalo {

    private double superior;
    private double inferior;

    public Intervalo(double inferior, double superior) {
        assert inferior <= superior;
        this.inferior = inferior;
        this.superior = superior;
    }

    public Intervalo(double superior) {
        this(0, superior);
    }

    public Intervalo() {
        this(0, 0);
    }

    public Intervalo(Intervalo intervalo) {
        this(intervalo.inferior, intervalo.superior);
    }

    public Intervalo clone() {
        return new Intervalo(this);
    }

    public double longitud() {
        return superior - inferior;
    }

    public void desplazar(double desplazamiento) {
        inferior = inferior + desplazamiento;
        superior = superior + desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento) {

        Intervalo intervalo = this.clone();
        intervalo.desplazar(desplazamiento);
        return intervalo;
    }

    public boolean incluye(double punto) {
        return inferior <= punto && punto <= superior;
    }

    public boolean incluye(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior) &&
                this.incluye(intervalo.superior);
    }

    public boolean equals(Intervalo intervalo) {
        assert intervalo != null;
        return inferior == intervalo.inferior &&
                superior == intervalo.superior;
    }

    public Intervalo interseccion(Intervalo intervalo) {
        assert this.intersecta(intervalo);

        if (this.incluye(intervalo)) {
            return intervalo.clone();
        } else if (intervalo.incluye(this)) {
            return this.clone();
        } else if (this.incluye(intervalo.inferior)) {
            return new Intervalo(intervalo.inferior, superior);
        } else {
            return new Intervalo(inferior, intervalo.superior);
        }
    }

    public boolean intersecta(Intervalo intervalo) {
        assert intervalo != null;
        return this.incluye(intervalo.inferior) ||
                this.incluye(intervalo.superior) ||
                intervalo.incluye(this);
    }

    public void oponer() {
        double superiorInicial = superior;

        superior = -inferior;
        inferior = -superiorInicial;
    }

    public void doblar() {
        double longitudInicial = this.longitud();

        inferior = inferior - longitudInicial / 2;
        superior = superior + longitudInicial / 2;
    }

    public void mostrar() {
        Console console = new Console();

        console.writeln("[" + inferior + "," + superior + "]");
    }

    public void recoger() {
        Console console = new Console();
        boolean valido = false;

        do {
            inferior = console.readDouble("Valor inferior?");
            superior = console.readDouble("Valor superior?");
            valido = superior >= inferior;
        } while (!valido);
    }

    public Intervalo[] trocear(int trozos) {
        assert trozos > 1;

        Intervalo[] intervalos = new Intervalo[trozos];
        double inferior = this.inferior;
        double longitud = this.longitud() / trozos;
        for (int i = 0; i < trozos; i++) {
            intervalos[i] = new Intervalo(inferior, inferior + longitud);
            inferior = inferior + longitud;
        }
        return intervalos;
    }

    public Intervalo union(Intervalo intervalo) {
        assert this.intersecta(intervalo);
        double nuevoInferior = Math.min(this.inferior, intervalo.inferior);
        double nuevoSuperior = Math.max(this.superior, intervalo.superior);
        return new Intervalo(nuevoInferior, nuevoSuperior);
    }

    public double puntoMedio() {
        return inferior + this.longitud() / 2;
    }
}