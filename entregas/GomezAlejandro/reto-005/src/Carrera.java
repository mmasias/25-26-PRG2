public class Carrera {
    private Console console;
    private Caballo[] caballos;
    private Pista pista;
    private Tiempo tiempo;

    public Carrera() {
        caballos = new Caballo[] { new Caballo(), new Caballo() };
        pista = new Pista();
        tiempo = new Tiempo();
        console = new Console();
    }

    public void jugar() {
        do {
            console.cleanScreen();
            tiempo.avanzar();

            for (int i = 0; i < caballos.length; i++) {
                caballos[i].avanzar();
            }

            pista.mostrar(caballos, tiempo);
            pausar();

        } while (!pista.hayGanador(caballos));

        pista.imprimirResultado(caballos);
    }

    private void pausar() {
        console.pause(1);
    }
}
