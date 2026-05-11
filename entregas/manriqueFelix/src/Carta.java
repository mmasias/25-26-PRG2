public class Carta {
    private final Rango rango;
    private final Palo palo;

    public Carta(Rango rango, Palo palo) {
        this.rango = rango;
        this.palo = palo;
    }

    public Rango getRango() { 
        return rango; 
    }

    @Override
    public String toString() {
        return "[" + rango.etiqueta + " " + palo.simbolo + "]";
    }
}