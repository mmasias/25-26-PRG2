class Pista {
    private int longitud;
    private Console console;

    public Pista(int longitud) {
        this.longitud = longitud;
        this.console = new Console();
    }

    public void mostrar(Caballo[] caballos) {
        String dibujoCaballo = ";=;^";
        int anchoCaballo = dibujoCaballo.length();
        console.writeln("-".repeat(longitud + anchoCaballo + 4));
        for (Caballo caballo : caballos) {
            int posicion = caballo.DistanciaRecorrida();
            if (posicion > longitud)
                posicion = longitud;
            console.write("   |");
            console.write(" ".repeat(posicion));
            console.write(dibujoCaballo);
            int espaciosRestantes = longitud - posicion;
            console.write(" ".repeat(espaciosRestantes));
            console.writeln("|");
        }
        console.writeln("-".repeat(longitud + anchoCaballo + 4));
    }

    public boolean hayGanadores(Caballo[] caballos) {
        for (Caballo caballo : caballos) {
            if (caballo.DistanciaRecorrida() >= longitud) {
                return true;
            }
        }
        return false;
    }

    public void mostrarResultadoFinal(Caballo[] caballos) {
        this.mostrar(caballos);
        console.writeln("\n¡TENEMOS UN GANADOR!");
        for (Caballo caballo : caballos) {
            if (caballo.DistanciaRecorrida() >= longitud) {
                console.writeln("El Caballo " + caballo.Id() + " ha cruzado la meta.");
            }
        }
        console.writeln("¡Gracias por participar!");
    }
}