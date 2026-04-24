public class Pista {

    private final int LONGITUD = 40;
    private Console console;
    
    public Pista() {
        console = new Console();
    }

    public int longitud() {
        return LONGITUD;
    }


    public void mostrar(Caballo[] caballos) {
        assert caballos != null;

        this.mostrarBorde();

        for (int i = 0; i < caballos.length; i++) {
            this.mostrarCaballo(caballos[i]);
        }

        this.mostrarBorde();
        console.writeln("");
    }

    private void mostrarBorde() {
        for (int i = 0; i < LONGITUD; i++) {
            console.write("-");
        }

        console.writeln("");
    }

    private void mostrarCaballo(Caballo caballo) {
        assert caballo != null;

        int posicion = this.obtenerPosicionVisible(caballo);

        for (int i = 0; i < posicion; i++) {
            console.write(" ");
        }

        console.writeln(";-;'");
    }

    private int obtenerPosicionVisible(Caballo caballo) {
        if (caballo.posicion() >= LONGITUD) {
            return LONGITUD - 1;
        }

        return caballo.posicion();
    }


}
