public class Menu {

    private Console console;

    public Menu(){
        console = new Console();
    }

    public void mostrar() {
        console.writeln("1. Mover Baraja a Descarte");
        console.writeln("2. Mover Descarte a Palo");
        console.writeln("3. Mover Descarte a Columna");
        console.writeln("4. Mover de Palo a Columna");
        console.writeln("5. Mover de Columna a Palo");
        console.writeln("6. Mover de Columna a Columna");
        console.writeln("7. Voltear Descarte en Baraja");
        console.writeln("8. Voltear carta de Columna");
        console.writeln("9. Salir");
    }

    public int pedirOpcion() {
        return console.readInt();
    }
}
