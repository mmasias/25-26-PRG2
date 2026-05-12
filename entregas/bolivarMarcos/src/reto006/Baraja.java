public class Baraja {
    private Carta[] cartas;
    private int siguienteCarta;
    public Baraja() {
        cartas = new Carta[52]; 
        siguienteCarta = 0;     

        String[] palos = {"♥", "♣", "♦", "♠"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int posicionFisica = 0; 

        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                cartas[posicionFisica] = new Carta(valores[j], palos[i]);
                posicionFisica++;
            }
        }
    }
}