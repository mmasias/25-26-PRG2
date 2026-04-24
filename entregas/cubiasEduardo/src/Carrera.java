class Carrera{
    private Caballo[] caballos;
    private Pista pista;
    public Carrera(String[] identificadores){
        pista = new Pista(30.20); 
        this.crearParticipantes(identificadores);
    }

    public void jugar(){

    }

    private void crearParticipantes(String[] identificadores){
        for(int i = 0; i <= identificadores.lenght; i++) {caballos[i] = new Caballo(identificadores[i]);}
    }
}