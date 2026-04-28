class Carrera {
    private Pista pista;
    private Caballo[] caballos;
    private Turno turno;
    private Console console;

    public Carrera(){
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
            caballos[turno.toca()].correr();
            turno.cambiar();
        } while (!pista.haTerminado(caballos) || !turno.esFinDeRonda());
        pista.mostrar(caballos);
        this.anunciarGanadores();
    }

    private void anunciarGanadores(){
        boolean gano1 = pista.haGanado(caballos[0]);
        boolean gano2 = pista.haGanado(caballos[1]);

        if (gano1 && gano2) {
            console.writeln("Empate de los caballos 1 y 2");
        } else if (gano1) {
            console.writeln("Ganó el caballo número 1");
        } else {
            console.writeln("Ganó el caballo número 2");
        }
    }

}