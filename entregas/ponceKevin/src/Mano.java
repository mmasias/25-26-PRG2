public class Mano {
    Carta[] cartas = new Carta[52];
    int indiceSiguienteCarta = 0;

    Mano() {
    }

    public void agregarCarta(Carta carta) {
        cartas[indiceSiguienteCarta] = carta;
        indiceSiguienteCarta++;
    }

    public void mostrarMano() {
        System.out.println("puntaje: " + calcularValor() + " de 21");
        System.out.print("Tu mano: ");
        for (int i = 0; i < indiceSiguienteCarta; i++) {
            System.out.print(cartas[i].toString() + " ");
        }
        System.out.println();
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