import java.util.ArrayList;

class Mano {

    private ArrayList<Carta> cartas;

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
            String valor = carta.getValor();

            if (valor.equals("A")) {
                puntos += 11;
                ases++;
            } else if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
                puntos += 10;
            } else {
                puntos += Integer.parseInt(valor);
            }
        }
        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    public String toString() {
        String resultado = "";

        for (Carta carta : cartas) {
            resultado += "[" + carta.toValorPalo() + "]";
        }

        return resultado;
    }
    
}