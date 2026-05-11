import java.util.ArrayList;
import java.util.List;

public class Mano {

    private List<Carta> cartas;

    public Mano() {
        cartas = new ArrayList<>();
    }

    public void mostrarManoInicial() {

        System.out.println("\n===== TU MANO =====");

        if (cartas.isEmpty()) {
            System.out.println("No tienes cartas.");
        } else {

            for (Carta carta : cartas) {
                System.out.println(carta);
            }
        }

        System.out.println("===================\n");
    }

    public void pedirCarta(Baraja baraja) {

        Carta carta = baraja.sacarCarta();

        if (carta != null) {

            cartas.add(carta);
            System.out.println("Has robado: " + carta);

        } else {
            System.out.println("No quedan cartas en la baraja.");
        }
    }

    public int calcularPuntos() {

        int total = 0;
        int cantidadAses = 0;

        for (Carta carta : cartas) {

            int valor = carta.getValor();


            if (valor > 10) {
                total += 10;

            
            } else if (valor == 1) {
                total += 11;
                cantidadAses++;

            } else {
                total += valor;
            }
        }

        while (total > 21 && cantidadAses > 0) {
            total -= 10;
            cantidadAses--;
        }

        return total;
    }

    public void volverAJugar() {

        cartas.clear();
        System.out.println("Nueva partida iniciada.");
    }
}