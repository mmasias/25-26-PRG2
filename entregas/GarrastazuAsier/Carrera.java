public class Carrera {
    private Caballo[] caballos;
    private Escenario escenario;
    private Turno turno;
    int caballoActual;

    public Carrera() {
        caballos = new Caballo[5];

        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(i);
        }

        escenario = new Escenario();
        turno = new Turno(caballos.length);
    }

    public void jugar() {

        do {
            escenario.mostrar(caballos);

            caballoActual = turno.toca();

            caballos[caballoActual].moverCaballo();

            turno.siguiente();

        } while (!caballos[caballoActual].estaEnMeta());

        escenario.mostrar(caballos);

        System.out.println("\nRESULTADO FINAL:");

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].estaEnMeta()) {
                System.out.println(caballos[i].getNombre() + " ha ganado");
            }
        }
    }
}