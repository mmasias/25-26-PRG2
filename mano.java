import java.util.ArrayList;
import java.util.List;

public class Mano {

    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void mostrarManoInicial() {

        System.out.println("\n===== TU MANO =====");

        for (Carta carta : cartas) {
            System.out.println(carta);
        }

        System.out.println("Puntos: " + calcularPuntos());
        System.out.println("===================\n");
    }

    public void pedirCarta(Baraja baraja) {

        Carta carta = baraja.sacarCarta();

        if (carta != null) {
            cartas.add(carta);
            System.out.println("Has robado: " + carta);
        }
    }

    public int calcularPuntos() {

        int total = 0;
        int cantidadAses = 0;

        for (Carta carta : cartas) {

            total += carta.getPuntos();

            if (carta.getValor().equals("A")) {
                cantidadAses++;
            }
        }

        while (total > 21 && cantidadAses > 0) {
            total -= 10;
            cantidadAses--;
        }

        return total;
    }

    public void plantarse() {
        System.out.println("Te has plantado.");
    }

    public void volverAJugar() {
        cartas.clear();
        System.out.println("Nueva partida iniciada.");
    }
}