public class Pista {

    private int longitud;
    private Console console;

    public Pista(int longitud) {
        this.longitud = longitud;
        console = new Console();
    }

    public void mostrar(Caballo[] caballos) {
        console.writeln("----------------------------------------------");

        for (int i = 0; i < caballos.length; i++) {
            int posicion = caballos[i].getPosicion();

            if (posicion >= longitud) {
                posicion = longitud - 1;
            }

            for (int j = 0; j < posicion; j++) {
                console.write(" ");
            }

            console.writeln(";-;'");
        }

        console.writeln("----------------------------------------------");
        console.writeln();
    }

    public boolean hayGanadores(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                return true;
            }
        }

        return false;
    }

    private Caballo obtenerGanador(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                return caballos[i];
            }
        }

        return null;
    }

    private boolean hayEmpate(Caballo[] caballos) {
        int contadorGanadores = 0;

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                contadorGanadores++;
            }
        }

        return contadorGanadores > 1;
    }

    public void mostrarResultadoFinal(Caballo[] caballos) {
        if (hayEmpate(caballos)) {
            console.writeln("EMPATE");
        } else {
            Caballo ganador = obtenerGanador(caballos);
            console.writeln("Ganó el caballo " + ganador.getNumero());
        }
    }
}