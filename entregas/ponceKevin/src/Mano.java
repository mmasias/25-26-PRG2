public class Mano {
    private static final int MAX_CARTAS_MANO = 11;
    private static final int NUMERO_MAXIMO_PUNTOS = 21;
    private static final int VALOR_AS_UNICO = 1;
    private static final int VALOR_AS_DOBLE = 11;
    private static final int VALOR_FIGURA = 10;
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
        int cantidadAses = contarAses();
        int valorNoAs = sumarValoresNoAs();
        return valorNoAs + calcularValorAses(cantidadAses);
    }

    private int contarAses() {
        int cantidadAses = 0;
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            if (cartas[i].esAs()) {
                cantidadAses++;
            }
        }
        return cantidadAses;
    }

    private int sumarValoresNoAs() {
        int valorTotal = 0;
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            if (!cartas[i].esAs()) {
                valorTotal += valorCarta(cartas[i]);
            }
        }
        return valorTotal;
    }

    private int calcularValorAses(int cantidadAses) {
        if (cantidadAses == 1) {
            return VALOR_AS_UNICO;
        }
        if (cantidadAses >= 2) {
            return VALOR_AS_DOBLE + (cantidadAses - 2) * VALOR_AS_UNICO;
        }
        return 0;
    }

    private int valorCarta(Carta carta) {
        if (carta.esAs()) {
            return VALOR_AS_DOBLE;
        }
        String valor = carta.getValor();
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) {
            return VALOR_FIGURA;
        }
        return Integer.parseInt(valor);
    }

 
}