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
    };

    public Intervalo desplazado(double desplazamiento){
        return new Intervalo(puntoMedio + desplazamiento, longitud);
    };

    public boolean incluye(double punto){
        return punto >= puntoMedio - longitud / 2 &&
               punto <= puntoMedio + longitud / 2;
    };

    public boolean incluye(Intervalo intervalo){
        return this.incluye(intervalo.puntoMedio - intervalo.longitud / 2) &&
               this.incluye(intervalo.puntoMedio + intervalo.longitud / 2);
    };

    public boolean equals(Intervalo intervalo){
           return puntoMedio == intervalo.puntoMedio &&
               longitud == intervalo.longitud;
    }

    public Intervalo interseccion(Intervalo intervalo){
           if (!this.intersecta(intervalo)) {
        return null;
    }

    double inf1 = puntoMedio - longitud/2;
    double sup1 = puntoMedio + longitud/2;

    double inf2 = intervalo.puntoMedio - intervalo.longitud/2;
    double sup2 = intervalo.puntoMedio + intervalo.longitud/2;

    double nuevoInferior = Math.max(inf1, inf2);
    double nuevoSuperior = Math.min(sup1, sup2);

    return new Intervalo((nuevoInferior + nuevoSuperior)/2,
    
    };

    public boolean intersecta(Intervalo intervalo){
             return this.incluye(intervalo.puntoMedio - intervalo.longitud / 2) ||
               this.incluye(intervalo.puntoMedio + intervalo.longitud / 2) ||
               intervalo.incluye(this.puntoMedio - this.longitud / 2) ||
               intervalo.incluye(this.puntoMedio + this.longitud / 2);
    };

    public void oponer(){
        puntoMedio = -puntoMedio;
    }

    public void doblar(){
        longitud = longitud * 2;
    }

    public void mostrar(){
        System.out.println("[" + (puntoMedio - longitud / 2) + ", " + (puntoMedio + longitud / 2) + "]");
    }

    public void recoger(){
        if (longitud < 0) {
            longitud = -longitud;
        }
    }

}