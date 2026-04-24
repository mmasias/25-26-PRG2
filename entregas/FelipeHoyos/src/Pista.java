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


}
