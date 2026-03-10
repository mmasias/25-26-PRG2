package visas.intervalo;

class Intervalo {

    private double puntoMedio;
    private double longitud;


    public Intervalo (double puntoMedio, double longitud) {
        this.puntoMedio = puntoMedio;
        this.longitud = longitud;
    };

    public Intervalo (double longitud) {
        this(0, longitud);
    };

    public Intervalo (){
        this(0,0);
    };

    public Intervalo (Intervalo intervalo){
        this(intervalo.puntoMedio, intervalo.longitud);
    };

    public Intervalo clone(){
        return new Intervalo(this);
    };

    public double longitud() {
        return this.longitud;
    };

    public double puntoMedio(){
        return puntoMedio;
    };

    public void desplazar (double desplazamiento){
        puntoMedio = puntoMedio + desplazamiento;
    }

    public Intervalo desplazado(double desplazamiento){
        return new Intervalo(puntoMedio + desplazamiento, longitud);
    }

    public boolean incluye(double punto)

    public boolean incluye(Intervalo intervalo)

    public boolean equals(Intervalo intervalo)

    public Intervalo interseccion(Intervalo intervalo)

    public boolean intersecta(Intervalo intervalo)

    public void oponer()

    public void doblar()

    public void mostrar()

    public void recoger()

}