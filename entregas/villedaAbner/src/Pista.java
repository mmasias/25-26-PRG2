public class Pista {
    final private int NUMEROCASILLAS = 40;
    final private String BORDE = "-";
    final private String VACIO = " ";
    final private String CABALLO = ";-;'";
    private Caballo[] caballos;
    private Console console;

    public Pista(Caballo[] caballos) {
        this.caballos = caballos;
        console = new Console();
    }

    public void mostrar() {
        for (int i = 0; i < NUMEROCASILLAS; i++) {
            console.write(BORDE);
        }
        console.writeln(VACIO);
        for (int i = 0; i < caballos.length; i++) {
            for (int j = 0; j < caballos[i].getPosicion(); j++) {
                console.write(VACIO);
            }
            console.writeln(CABALLO);
        }
        for (int i = 0; i < NUMEROCASILLAS; i++) {
            console.write(BORDE);
        }
        console.writeln(VACIO);
        console.writeln(VACIO);

    }

    public boolean hayGanador() {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= NUMEROCASILLAS) {
                return true;
            }
        }
        return false;
    }

    public boolean hayEmpate() {
        int contadorGanadores = 0;
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= NUMEROCASILLAS) {
                contadorGanadores++;
            }
        }
        return contadorGanadores >= 2;
    }

}
