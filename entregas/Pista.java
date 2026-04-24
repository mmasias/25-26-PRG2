public class Pista {
    private String Separador = "---+-----------+---------+---------+---------+---------+-----------+";
    private String Camino1 = "[1]";
    private String Camino2 = "[2]";
    private int turno = 0;

    public void mostrar(Caballos caballo1, Caballos caballo2) {
        Console console = new Console();
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
