import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"♥", "♣", "♦", "♠"};

        String mano = "";
        int puntos = 0;

        for (int i = 0; i < 2; i++) {
            int posicion = aleatorio.nextInt(13);
            String valorCarta = valores[posicion];
            mano += "[" + valorCarta + " " + palos[aleatorio.nextInt(4)] + "]";
            
            if (valorCarta.equals("A")) {
                puntos += 11;
            } else if (posicion >= 9) {
                puntos += 10;
            } else {
                puntos += Integer.parseInt(valorCarta);
            }
        }

        System.out.println("Mano: " + mano + " - Puntaje: " + puntos);
    }
}