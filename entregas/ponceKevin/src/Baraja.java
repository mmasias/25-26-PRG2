public class Baraja {
    Carta[] cartas = new Carta[52];
    Baraja() {
        inicializarBaraja();

    }

    public Carta sacarCarta() {
        return new Carta();
    }

    private void mezclar() {

    }

private void inicializarBaraja() {
    String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
    String[] valores = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    int index = 0;
    for (String palo : palos) {
        for (String valor : valores) {
            cartas[index] = new Carta(palo, valor);
            index++;
        }
    }
}
}