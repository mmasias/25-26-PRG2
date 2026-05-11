public enum Rango {
    DOS("2", 2), TRES("3", 3), CUATRO("4", 4), CINCO("5", 5),
    SEIS("6", 6), SIETE("7", 7), OCHO("8", 8), NUEVE("9", 9),
    DIEZ("10", 10), JOTA("J", 10), REINA("Q", 10), REY("K", 10),
    AS("A", 11); 
    
    public final String etiqueta;
    public final int valor;
    
    Rango(String etiqueta, int valor) {
        this.etiqueta = etiqueta;
        this.valor = valor;
    }
}