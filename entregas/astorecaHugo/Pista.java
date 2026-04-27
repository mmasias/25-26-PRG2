
class Pista {

    

        private int longitud;
        private Console console;

        Pista(int longitud) {
            this.longitud = longitud;
            console = new Console();

        }

    void mostrar(Caballo[] caballos) {
            for (int i = 0; i < caballos.length; i++) {
                for (int j = 0; j < longitud; j++) {
                    if (j == caballos[i].getPosicion()) {
                        console.write(";--;'");
                    } else {
                        console.write("-");
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

    public void mostrarResultadoFinal() {
        Caballo ganador = obtenerGanador(caballos);
        if (ganador != null) {
            console.writeln("El ganador es: " + ganador.getNumero());
        }
    }

}
