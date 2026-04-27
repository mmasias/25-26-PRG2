public class Carrera {
    private Console console;
    private Caballo [] caballo;
    private Pista pista;
    private Tiempo tiempo;

    public Carrera() {
        this.caballo = new Caballo[] {new Caballo(), new Caballo()};
        this.pista = new Pista();
        this.tiempo = new Tiempo();
        this.console = new Console ();
    }

    public Carrera(Caballo [] caballo, Pista pista, Tiempo tiempo) {
        this.caballo = caballo;
        this.pista = pista;
        this.tiempo = tiempo;
    }


    public void jugar() {
       do {
        console.cleanScreen();
        tiempo.avanzar();
        for (int i = 0; i < caballo.length; i++) {
            caballo[i].avanzar();
        }
        
        pista.mostrar(caballo, tiempo);
        this.pausar();
       } while (!pista.hayGanador(caballo));

       pista.imprimirResultado(caballo);
    }

    private void pausar() {
        console.pause(1);
    }
}
