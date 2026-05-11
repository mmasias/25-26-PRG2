
class Mano {

    private Carta[] cartas;
    private int contador;
    private Console console;

    public Mano() {
        cartas = new Carta[10];
        contador = 0;
        console = new Console();

    }

    public void añadir(Carta carta) {
        cartas[contador] = carta;
        contador++;

    }

    boolean estaVacia() {
        return contador == 0;
    }

    boolean haGanado() {
        return this.getPuntuacion() == 21;

    }

    void mostrar() {
        for (int i = 0; i < contador; i++) {
            cartas[i].mostrar();
        }
    }

    int getPuntuacion() {
        int puntuacion = 0;
        for (int i = 0; i < contador; i++) {
            puntuacion += cartas[i].getValor();
        }
        return puntuacion;
    }

    void nuevaMano() {
        contador = 0;
    }

}
