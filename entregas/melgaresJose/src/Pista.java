class Pista {
    private int longitud;
    private Caballo[] competidores;
    private int[] posiciones;

    public Pista(int longitud, Caballo[] competidores) {
        this.longitud = longitud;
        this.competidores = competidores;
        colocarEnSusMarcas();
    }
    private void colocarEnSusMarcas() {
        posiciones = new int[competidores.length];
        for(int i = 0; i < competidores.length; i++) {
            posiciones[i] = 0;
        }
    }

    public void dibujar() {
        final String bordePista = "+";
        System.out.println(bordePista.repeat(longitud + 3));
        dibujarCompetidores();
        System.out.println(bordePista.repeat(longitud + 3));

    }

    public void avanzarCompetidores() {
        for(int i = 0; i < competidores.length; i++) {
            posiciones[i] += competidores[i].moverse();
        }
    }

    private void dibujarCompetidores() {
        for(int i = 0; i < competidores.length; i++) {
            competidores[i].dibujar(posiciones[i]);
        }
    }

    public boolean hayGanador() {
        for(int i = 0; i < competidores.length; i++) {
            if(posiciones[i] >= longitud) {
                return true;
            }
        }
        return false;
    }
}
