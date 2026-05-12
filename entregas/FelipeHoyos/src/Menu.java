class Menu {
    private Console console;

    public Menu() {
        console = new Console();    
    }
    public int pedirOpcion() {
        console.writeln("1. Pedir");
        console.writeln("2. Empezar de nuevo");
        console.writeln("3. Salir");

        return console.readInt("Opcion: ");

    }
}
