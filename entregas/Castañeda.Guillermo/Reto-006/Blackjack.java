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
        int contadorAses = 0;
        int opcionUsuario = 1;

        for (int i = 0; i < 2; i++) {
            int posicion = aleatorio.nextInt(13);
            String valorCarta = valores[posicion];
            mano += "[" + valorCarta + " " + palos[aleatorio.nextInt(4)] + "]";
            if (valorCarta.equals("A")) { contadorAses++; puntos += 11; }
            else if (posicion >= 9) { puntos += 10; }
            else { puntos += Integer.parseInt(valorCarta); }
        }

        while (opcionUsuario == 1) {
            while (puntos > 21 && contadorAses > 0) {
                puntos -= 10;
                contadorAses--;
            }

            String estado = (puntos == 21) ? "Ganó" : (puntos > 21) ? "Perdió" : "Sigue jugando";
            System.out.println("Mano: " + mano + " - Puntaje: " + puntos + " ==> " + estado);

            if (puntos >= 21) break;

            System.out.println("1. Pedir\n2. Salir");
            opcionUsuario = teclado.nextInt();

            if (opcionUsuario == 1) {
                int posicion = aleatorio.nextInt(13);
                String valorCarta = valores[posicion];
                mano += "[" + valorCarta + " " + palos[aleatorio.nextInt(4)] + "]";
                if (valorCarta.equals("A")) { contadorAses++; puntos += 11; }
                else if (posicion >= 9) { puntos += 10; }
                else { puntos += Integer.parseInt(valorCarta); }
            }
        }
    }
}