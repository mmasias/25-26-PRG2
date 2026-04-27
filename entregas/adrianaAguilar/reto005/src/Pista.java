public class Pista {
    private Console console;
    private int longitud = 40;

    public Pista() {
        this.console = new Console ();
    }

    public boolean hayGanador(Caballo[] caballo) {
        for (int i = 0; i < caballo.length; i++) {
            if (caballo[i].distancia() >= longitud) {
                return true;
            }
        }
        return false;
    }

    public void mostrar(Caballo[] caballo, Tiempo tiempo) {
        

        for (int i = 0; i < caballo.length; i++) {
            int posicion = caballo[i].distancia();

            if (posicion > longitud) {
                posicion = longitud;
            }

            String espacios = "";
            for (int j = 0; j < posicion; j++) {
                espacios += " ";
            }

            System.out.println(espacios + ";-;'");
        }

        System.out.println("----------------------------------------------");

    }


    public void imprimirResultado(Caballo[] caballo) {
        int ganadores = 0;
        int indiceGanador = -1;

        for (int i = 0; i < caballo.length; i++) {
            if (caballo[i].distancia() >= longitud) {
                ganadores++;
                indiceGanador = i;
            }
        }

        if (ganadores == 1) {
            System.out.println("Gano el caballo " + (indiceGanador + 1));
        } else if (ganadores > 1) {
            System.out.println("Empate");
        }
    }
}
