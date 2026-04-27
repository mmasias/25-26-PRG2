
public class Carrera {
    private Caballo[] caballos;
    private Escenario escenario;
    private Carrera carrera;
    private Juego juego;
    private Turno turno;
    int caballoActual;

    public Carrera() {
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo();
        }
        escenario = new Escenario();
        carrera = new Carrera();
        juego = new Juego();
        turno = new Turno();
    }

    public void jugar(){
        do{
            escenario.mostrar();
            
            caballoActual= turno.toca();
            caballos[caballoActual].moverCaballo();
            turno.siguiente();
            
        }while(!caballos[caballoActual].estaEnMeta());
    
        System.out.println("¡El caballo " + caballos[caballoActual] + " ha ganado la carrera!");
    }
}
