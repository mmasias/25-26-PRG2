public class Baraja {
    private Carta[] cartas;
    private int siguiente;

    public Baraja() {
        cartas = new Carta[52];
        siguiente = 0;
        this.inicializarCartas(); 
        this.barajar();           
    }

    private void inicializarCartas() {
        String[] palos = {"♥", "♣", "♦", "♠"};
        String[] rangos = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int indice = 0;

        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < rangos.length; j++) {
                cartas[indice] = new Carta(palos[i], rangos[j]);
                indice++;
            }
        }
    }

    private void barajar() {
        for (int i = 0; i < cartas.length; i++) {
            int posicionAzar = (int) (Math.random() * cartas.length);
            Carta temporal = cartas[i];
            cartas[i] = cartas[posicionAzar];
            cartas[posicionAzar] = temporal;
        }
    }

    public Carta repartir() {
        Carta cartaAEntregar = cartas[siguiente];
        siguiente++;
        return cartaAEntregar;
     
    }


}
