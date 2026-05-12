import java.util.ArrayList;

class Mano {
    private final ArrayList<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public int calcularPuntos() {
        int puntos = 0;
        int ases = 0;

        for (Carta carta : cartas) {
            puntos += carta.getPuntos();
            if (carta.getValor().equals("A")) {
                ases++;
            }
        }

        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }
}