public class Menu {
    private Console console;

    public Menu() {
        console = new Console();
    }

    public void mostrar() {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");
        console.writeln("-".repeat(20));
    }

    public int pedirOpcion() {
        return console.readInt("Elige una opción: ");
    }
}