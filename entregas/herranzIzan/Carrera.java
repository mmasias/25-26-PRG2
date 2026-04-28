public class Carrera {

    private Pista pista;
    private Caballo[] caballos;
    private Console console;

    public Carrera() {
        pista = new Pista(40);
        caballos = new Caballo[2];
        caballos[0] = new Caballo(1);
        caballos[1] = new Caballo(2);
        console = new Console();
    }

    public void jugar() {
        pista.mostrar(caballos);

        do {
            for (int i = 0; i < caballos.length; i++) {
                caballos[i].mover();
            }

            pista.mostrar(caballos);
            console.readString();

        } while (!pista.hayGanadores(caballos));

        pista.mostrarResultadoFinal(caballos);
    }
}