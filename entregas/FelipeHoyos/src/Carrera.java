public class Carrera {

    private Pista pista;
    private Caballo[] caballos;
    private Turno turno;
    private Console console;

    public Carrera() {
        pista = new Pista();
        caballos = new Caballo[2];
        caballos[0] = new Caballo(1);
        caballos[1] = new Caballo(2);
        turno = new Turno();
        console = new Console();
    }

    public void jugar()


}
    
