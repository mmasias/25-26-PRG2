public class Carrera {

    private Caballo[] caballos;
    private Pista pista;
    private Turno turno;
    private Console console;

    public Carrera() {
        caballos = new Caballo[5];
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i + 1);
        }
        turno = new Turno(caballos.length);
        pista = new Pista(caballos);
        console = new Console();
    }

    public void jugar() {
        do {
            pista.mostrar();
            for (int i = 0; i < caballos.length; i++) {
                caballos[turno.toca()].avanzar();
                turno.cambiar();
            }

            console.pause(1);
            console.writeln("(...)");

        } while (!pista.hayGanador() && !pista.hayEmpate());

        pista.mostrar();

        if (pista.hayEmpate()) {
            System.out.println("Hubo un empate!");
        } else {
            for (int i = 0; i < caballos.length; i++) {
                if (caballos[i].getPosicion() >= 40) {
                    caballos[i].celebrar();
                }
            }
        }

    }
   

}
