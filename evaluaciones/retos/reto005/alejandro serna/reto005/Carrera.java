public class Carrera {
    private Console console;
    private int turno = 0;
    private static final int PISTA_LENGTH = 40;

    public void jugar() {
        console = new Console();
        Caballo caballo1 = new Caballo(1);
        Caballo caballo2 = new Caballo(2);

        do {
            // Mostrar la pista
            console.writeln("----------------------------------------------");
            caballo1.mostrar(console);
            caballo2.mostrar(console);
            console.writeln("----------------------------------------------");
            
            // Avanzar caballos
            caballo1.avanzar();
            caballo2.avanzar();
            
            console.pause(500);
            
            turno++;
        } while (!caballo1.haLlegado() && !caballo2.haLlegado());

        // Mostrar resultado final
        console.writeln("----------------------------------------------");
        caballo1.mostrar(console);
        caballo2.mostrar(console);
        console.writeln("----------------------------------------------");

        if (caballo1.haLlegado() && caballo2.haLlegado()) {
            console.writeln("Empate! Ambos caballos llegaron al final");
        } else if (caballo1.haLlegado()) {
            console.writeln("Ganó el caballo 1");
        } else {
            console.writeln("Ganó el caballo 2");
        }
    }
}