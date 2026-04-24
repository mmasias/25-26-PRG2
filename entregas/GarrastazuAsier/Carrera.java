
public class Carrera {
    private Caballo[] caballos;
    private Escenario escenario;
    private Carrera carrera;
    private Juego juego;
    private Turno turno;

    public Carrera() {
        caballos = new Caballo[5];
        escenario = new Escenario();
        carrera = new Carrera();
        juego = new Juego();
        turno = new Turno();
    }

    public void jugar(){
        do{
            escenario.mostrar();
            caballos[turno.toca()].moverCaballo();
            turno.siguiente();
            
        }while(!caballos.estaEnMeta());
    
        System.out.println("¡El caballo " + caballos[turno.toca()] + " ha ganado la carrera!");
    }
}
