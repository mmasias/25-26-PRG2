public class Mano {
    private static final int MAX_CARTAS = 10;

    private Carta[] cartasEnMano;
    private int totalCartas;

    public Mano() {
        cartasEnMano = new Carta[MAX_CARTAS];
        totalCartas = 0;
    }

    public void agregarCarta(Carta carta) {
        cartasEnMano[totalCartas] = carta;
        totalCartas++;
    }

    public int getPuntuacion() {
        int total = 0;
        int asesFlexibles = 0;

        for (int i = 0; i < totalCartas; i++) {
            total += cartasEnMano[i].getValor();
            if (cartasEnMano[i].esAs()) {
                asesFlexibles++;
            }
        }

        while (total > 21 && asesFlexibles > 0) {
            total -= 10;
            asesFlexibles--;
        }
        return total;
    }

    public void mostrar() {
        for (int i = 0; i < totalCartas; i++) {
            cartasEnMano[i].mostrar();
        }
    }

    public boolean haGanado() {
        return this.getPuntuacion() == 21;
    }

    public void nuevaMano() {
        totalCartas = 0;
    }

    public boolean estaVacia() {
        return totalCartas == 0;
    }
}
