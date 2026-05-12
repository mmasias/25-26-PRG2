public class Mano {
    private Carta[] cartas;
    private int contador;
    private Console console;

    public Mano() {
        cartas = new Carta[10];
        contador = 0;
        console = new Console();
    }

    public void añadir(Carta carta1) {
        cartas[contador] = carta1;
        contador++;
    }

    public int getPuntuacion() {
        int total = 0;
        int contadorAses = 0;
        for (int i = 0; i < contador; i++) {
            total = total + cartas[i].getValor();
            if (cartas[i].esAs()) {
                contadorAses++;
            }
        }
        while (total > 21 && contadorAses > 0) {
            total = total - 10;
            contadorAses--;
        }
        return total;

    }

    public void mostrar() {
        for (int i = 0; i < contador; i++) {
            cartas[i].mostrar();
        }
    }

    public boolean haGanado() {
        return this.getPuntuacion() == 21;
    }

    public void nuevaMano() {
        contador = 0;
    }

    public boolean estaVacia() {
        return contador == 0;
    }

}