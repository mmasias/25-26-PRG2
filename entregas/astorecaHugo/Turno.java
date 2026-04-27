
class Turno {
    private Caballo caballo;
    private Pista pista;
    private Console console;
    

    public int toca( Caballo caballo, Pista pista) {
        this.caballo = caballo;
        this.pista = pista;
        console = new Console();
        caballo.moverse(pista);
        return caballo.getPosicion();

    }

    public void cambiar( Caballo caballo, Pista pista) {
        this.caballo = caballo;
        this.pista = pista;
        console = new Console();
        caballo.moverse(pista);
    }

    int noToca( ) {
        
    }

}
