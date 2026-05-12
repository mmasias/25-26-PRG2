package entregas.riveraOscar;
import java.util.Random;

public class Baraja{
    private Carta[] cartas;
    private int siguienteCarta;

    public Baraja(){
        this.cartas = new Carta[52];
        this.siguienteCarta = 0;
        
        String[] palos = {"♥️", "♦️", "♣️", "♠️"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        
        int posicion = 0;
        for (int i = 0; i < palos.length; i++) {
            for (int c = 0; c < valores.length; c++) {
                this.cartas[posicion] = new Carta(valores[c], palos[i]);
                posicion++;
            }
        }
    }

    public void barajar(){
        Random random = new Random();
        for (int i = 0; i < cartas.length; i++) {
            int nuevaPosicion = random.nextInt(52);
            Carta carta1 = cartas[nuevaPosicion];
            Carta carta2 = cartas[i];
            cartas[i] = carta1;
            cartas[nuevaPosicion] = carta2;
        }
    }
    public Carta darCarta(){
        siguienteCarta++;
        return cartas[siguienteCarta - 1];
    }
}