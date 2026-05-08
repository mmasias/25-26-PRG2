public class Mano {
    private static final int MAX_CARTAS_MANO = 11;
    private static final int NUMERO_MAXIMO_PUNTOS = 21;
    private final Console console;
    Carta[] cartas = new Carta[MAX_CARTAS_MANO];
    int indiceSiguienteCarta = 0;

    Mano(Console console) {
        this.console = console;
    }

    public void agregarCarta(Carta carta) {
        cartas[indiceSiguienteCarta] = carta;
        indiceSiguienteCarta++;
    }

    public void mostrarMano() {
        console.writeln("puntaje: " + calcularValor() + " de " + NUMERO_MAXIMO_PUNTOS);
        console.write("Tu mano: ");
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            console.write(cartas[i].toString() + " ");
        }
        console.writeln();
    }

    public int calcularValor() {
        int valorTotal = 0;
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            valorTotal += valorCarta(cartas[i]);
        }
        return valorTotal;
    }

       private int valorCarta(Carta carta) {
        if (carta.esAs()) {
            return 11;
        }
        String valor = carta.getValor();
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return 10;
        }
        return Integer.parseInt(valor);
    }

 
}