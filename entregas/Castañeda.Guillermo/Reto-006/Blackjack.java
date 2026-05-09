import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();
        
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"♥", "♣", "♦", "♠"};

        int posicion = aleatorio.nextInt(13);
        String mano = "[" + valores[posicion] + " " + palos[aleatorio.nextInt(4)] + "]";
        
        System.out.println("Tu primera carta es: " + mano);
    }
}