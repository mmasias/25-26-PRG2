public class Mano {

    private Carta[] mano;
    private int cantidadCartas;
    private Console console;

    public Mano() {

        mano = new Carta[10];
        cantidadCartas = 0;

        console = new Console();
    }

    public void añadir(Carta carta) {

        mano[cantidadCartas] = carta;
        cantidadCartas++;
    }

    public int getPuntuacion() {

        int puntos = 0;
        int ases = 0;

        for (int i = 0; i < cantidadCartas; i++) {

            puntos += mano[i].obtenerValor();

            if (mano[i].esAs()) {

                ases++;
            }
        }

        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    public void mostrar() {

        for (int i = 0; i < cantidadCartas; i++) {

            mano[i].mostrar();
        }
    }

    public boolean blackjack() {

        return getPuntuacion() == 21;
    }

    public void reiniciar() {

        cantidadCartas = 0;
    }

    public boolean estaVacia() {

        return cantidadCartas == 0;
    }
}