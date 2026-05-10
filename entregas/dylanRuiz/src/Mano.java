import java.util.ArrayList;

public class Mano {
    ArrayList<Carta> misCartas;

    public Mano() {
        misCartas = new ArrayList<>();
    }

    public void añadirCarta(Carta c) {
        misCartas.add(c);
    }

    public int calcularPuntaje() {
        int puntos = 0;
        int ases = 0;

        for (Carta c : misCartas) {
            if (c.valor.equals("J") || c.valor.equals("Q") || c.valor.equals("K")) {
                puntos += 10;
            } else if (c.valor.equals("A")) {
                ases++;
                puntos += 11;
            } else {
                puntos += Integer.parseInt(c.valor);
            }
        }
        
        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }
        return puntos;
    }

    public String mostrarCartas() {
        String texto = "";
        for (Carta c : misCartas) {
            texto += c.toString();
        }
        return texto;
    }
}
