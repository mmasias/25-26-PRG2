import java.util 

public class Mano {

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

            switch (valor) {

                case "A":
                    puntos += 11;
                    ases++;
                    break;

                case "J":
                case "Q":
                case "K":
                    puntos += 10;
                    break;

                default:
                    puntos += Integer.parseInt(valor);
            }
        }
        
        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    @Override
    public String toString() {

        String texto = "";

        for (Carta carta : cartas) {
            texto += "[" + carta + "]";
        }

        return texto;
    }
}