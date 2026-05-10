import java.util.*;

public class Mano {
    private List<Carta> cartas = new ArrayList<>();

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }


    public int calcularPuntaje() {
        int total = 0;
        int ases = 0;
        for (Carta carta : cartas) {
            String valor = carta.getValor();
            if (valor.equals("A")) {
                ases++;
                total += 11;
            } else if (valor.equals("K") || valor.equals("Q") || valor.equals("J")) {
                total += 10;
            } else {
                total += Integer.parseInt(valor);
            }
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas) {
            sb.append(carta.toString());
        }
        return sb.toString();
    }
}
