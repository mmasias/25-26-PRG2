class CarreraDeCaballos {
    private Console console;
    private Caballo[] caballos;
    private Pista pista;
    private Turno turnos;

    public CarreraDeCaballos() {
        console = new Console();
        pista = new Pista(40);
        turnos = new Turno(); 
        caballos = new Caballo[4]; 
        caballos[0] = new Caballo("Rayo");
        caballos[1] = new Caballo("Secretariat");
        caballos[2] = new Caballo("Potooooooo");
        caballos[3] = new Caballo("WinkyWinky");
    }

    public void empezar() {
            boolean carreraTerminada = false;

            while (!carreraTerminada) {
                console.clear();
                turnos.ejecutar(caballos, pista);
                pista.mostrar(console); 
                
                for (Caballo caballo : caballos) {
                    caballo.mostrar(console);
                    
                    if (pista.haTerminado(caballo)) {
                        carreraTerminada = true;
                    }
                }
                pista.mostrar(console);
                console.writeln();

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            int cantidadDeGanadores = 0;
            for (Caballo caballo : caballos) {
                if (pista.haTerminado(caballo)) {
                    cantidadDeGanadores++;
                }
            }

            if (cantidadDeGanadores > 1) {
                console.writeln("Hubo un empate entre ");
                for (Caballo caballo : caballos) {
                    if (pista.haTerminado(caballo)) {
                        console.writeln("- " + caballo.alias());
                    }
                }
            } else {
                for (Caballo caballo : caballos) {
                    if (pista.haTerminado(caballo)) {
                        console.writeln("El ganador es: " + caballo.alias());
                    }
                }
            }
        }
}