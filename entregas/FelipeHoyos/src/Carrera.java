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

    public void jugar(){
    
    do {
            pista.mostrar(caballos);
            this.avanzarCaballoEnTurno();
            turno.cambiar();
        } while (!this.hayGanador());

        pista.mostrar(caballos);
        this.mostrarResultado();
    }

    private void avanzarCaballoEnTurno() {
        caballos[turno.toca()].avanzar();
    }

    private boolean hayGanador() {
        return caballos[0].haLlegado(pista) ||
               caballos[1].haLlegado(pista);
    }

    private void mostrarResultado() {
        if (this.hayEmpate()) {
            console.writeln("Empate");
        } else {
            console.writeln("Ganó el caballo " + this.obtenerGanador().numero());
        }
    }
    
    private boolean hayEmpate() {
        return caballos[0].haLlegado(pista) &&
               caballos[1].haLlegado(pista);
    }
    private Caballo obtenerGanador() {}


 }


    
