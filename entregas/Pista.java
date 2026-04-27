class Pista {
    private int longitud;
    private Console console;

    public Pista(int longitud) {
        this.longitud = longitud;
        console = new Console();
    }

    public void mostrar(Caballo[] caballos) {
        String separador = "-".repeat(longitud + 2);
        console.writeln(separador);
        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < longitud; j++) {
                if (j == caballos[i].getPosicion()) {
                    console.write(";-;'");
                } else {
                    console.write("-");
                }
            }
            console.writeln("");
        }
        console.writeln(separador);
    }

    public boolean hayGanadores(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                return true;
            }
        }
        return false;
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

    private Caballo obtenerGanador(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                return caballos[i];
            }
        }
        return null;
    }

    public void mostrarResultadoFinal(Caballo[] caballos) {
        mostrar(caballos);
        if (hayEmpate(caballos)) {
            console.writeln("¡Empate!");
        } else {
            Caballo ganador = obtenerGanador(caballos);
            console.writeln("Ganó el caballo " + ganador.getNumero());
        }
    }
}