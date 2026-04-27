class Caballo {
    
    private final int AVANCE_MAXIMO = 3;
    private int posicion;
    private String nombre;

    public Caballo(String nombre) {
        posicion = 0;
        this.nombre = nombre;
    }
    public void dibujar(int avance) {
        String caballoASCII = ";-;`";
        String vacio = " ".repeat(avance);
        System.out.println(nombre + "|"+ vacio + caballoASCII);
    }
    public int moverse() {
        return determinarAvance();
    }

    private int determinarAvance() {
        return (int) (Math.random() * AVANCE_MAXIMO);
    }

}
