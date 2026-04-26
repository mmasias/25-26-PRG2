public class Pista {
    private int longitud;
    private Console console;

    public Pista(int i) {
        longitud = i;
        console = new Console();
    }

    public void mostrar(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < longitud; j++) {
                if (j == caballos[i].getPosicion()) {
                    console.write(";--;'");
                } else {
                    console.write("-");
                }
            }
            console.writeln("");
        }
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
        int contadorGanador = 0;
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                contadorGanador++;
            }
        }
        if (contadorGanador > 1) {
            return true;
        }
        return false;
    }

    public void mostrarResultadoFinal(Caballo[] caballos) {
        if (hayEmpate(caballos)) {
            console.writeln("EMPATE");
        } else {
            Caballo ganador = obtenerGanador(caballos);
            console.writeln("El caballo ganador es el dorsal " + ganador.getNumero());
        }
    }
}
