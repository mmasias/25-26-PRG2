public class Pista {
    private Console console;
    private int longitud;

    public Pista() {
        console = new Console();
        longitud = 40;
    }

    public boolean hayGanador(Caballo[] caballos) {
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].distancia() >= longitud) {
                return true;
            }
        }
        return false;
    }

    public void mostrar(Caballo[] caballos, Tiempo tiempo) {
        for (int i = 0; i < caballos.length; i++) {
            int pos = caballos[i].distancia();
            if (pos > longitud) {
                pos = longitud;
            }

            String linea = "";
            for (int j = 0; j < pos; j++) {
                linea += " ";
            }

            System.out.println(linea + ";-;'");
        }

        System.out.println("----------------------------------------");
    }

    public void imprimirResultado(Caballo[] caballos) {
        int ganadores = 0;
        int indice = -1;

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].distancia() >= longitud) {
                ganadores++;
                indice = i;
            }
        }

        if (ganadores == 1) {
            System.out.println("Ganó el caballo " + (indice + 1));
        } else {
            System.out.println("Empate");
        }
    }
}
