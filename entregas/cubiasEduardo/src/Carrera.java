class Carrera{
    private Caballo[] caballos;
    public Carrera(String[] identificadores){
        this.crearParticipantes(identificadores);
    }

    public void jugar(){

    }

    private void crearParticipantes(String[] identificadores){
        for(int i = 0; i <= identificadores.lenght; i++) {caballos[i] = new Caballo(identificadores[i]);}
    }
}