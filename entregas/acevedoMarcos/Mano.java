public class Mano {
    private Carta[] cartas;
    private int contador;

    public Mano() {
        this.cartas = new Carta[10];
        this.contador = 0;
    }

    public void añadir(Carta c) {
        cartas[contador] = c;
        contador++;
    }

    public int getPuntuacion() {
        int total = 0;
        int ases = 0;
        for (int i = 0; i < contador; i++) {
            total += cartas[i].getValor();
            if (cartas[i].esAs()) ases++;
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    public void mostrar() {
        for (int i = 0; i < contador; i++) {
            cartas[i].mostrar();
        }
    }

    public void nuevaMano() {
        contador = 0;
    }

    public boolean estaVacia() {
        return contador == 0;
    }
}