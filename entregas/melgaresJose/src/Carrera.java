class Carrera {
    final int NUMERO_PARTICIPANTES = 3;
    private final int LONGITUD_CARRERA = 40;

    Pista pistaJuego;
    Caballo[] competidores;
    boolean hayGanador;    
    int turno;

    public Carrera() {
        prepararCompetidores();
        pistaJuego = new Pista(LONGITUD_CARRERA, competidores);
        turno = 0;
        hayGanador = false;
    }
    
    public void jugar() {
        do {
            mostrarTurno();
            pistaJuego.avanzarCompetidores();
            pistaJuego.dibujar();
            hayGanador = pistaJuego.hayGanador();
            avanzarTurno();
        } while(!hayGanador);    
    }
    
    private void  prepararCompetidores() {
        String[] nombres = {"Huevo", "Queso", "Leche"};
        competidores = new Caballo[NUMERO_PARTICIPANTES];
        for(int i = 0; i < NUMERO_PARTICIPANTES ; i++) {
            competidores[i] = new Caballo(nombres[i]);
        }
    }

    private void mostrarTurno() {
        System.out.println("Turno #" + turno + "!!!");
    }

    private void avanzarTurno() {
        turno++;
    } 
}