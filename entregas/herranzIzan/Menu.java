public class Menu {
    private Console console;

    public Menu() {
        console = new Console();
    }

    public void mostrar() {
        console.writeln("1. Pedir Carta");
        console.writeln("2. Empezar de Nuevo");
        console.writeln("3. Salir");
    }

    public int pedirOpcion() {
        return console.readInt();
    }
}
