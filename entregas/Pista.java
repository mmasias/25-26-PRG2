public class Pista {
    private String Separador = "---+-----------+---------+---------+---------+---------+-----------+";
    private String Camino1 = "[1]";
    private String Camino2 = "[2]";
    private int turno = 0;

    public void mostrar() {
        Console console = new Console();
        Caballos caballo1 = new Caballos(console);
        Caballos caballo2 = new Caballos(console);

        console.writeln("Turno: " + turno);
        console.write(Camino1);
        caballo1.mostrar();
        console.write(Camino2);
        caballo2.mostrar();
        console.writeln(Separador);

        caballo1.movimientoCaballo();
        caballo2.movimientoCaballo();
        console.writeln(Separador);
        turno++;

    }


}
