import java.util.Map;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Baraja baraja = new Baraja();
        Mano mano = new Mano();
        boolean jugando = true;

        while (jugando) {
            if (mano.estaVacia()) {
                for (int i = 0; i < 2; i++) {
                    Carta c = baraja.sacar();
                    c.voltear();
                    mano.añadir(c);
                }
            }

            int puntos = mano.getPuntuacion();
            System.out.println("\n--------------------");
            System.out.print("Mano: ");
            mano.mostrar();
            System.out.print(" - Puntaje: " + puntos);
            
            if (puntos == 21) System.out.println(" ==> ¡Ganó!");
            else if (puntos > 21) System.out.println(" ==> Perdió");
            else System.out.println(" ==> Sigue jugando");

            System.out.println("--------------------");
            System.out.println("1. Pedir\n2. Empezar de nuevo\n3. Salir");
            int opcion = sc.nextInt();

            if (opcion == 1 && puntos < 21) {
                Carta c = baraja.sacar();
                c.voltear();
                mano.añadir(c);
            } else if (opcion == 2) {
                mano.nuevaMano();
                if (baraja.vacia()) baraja = new Baraja();
            } else if (opcion == 3) {
                jugando = false;
            }
        }
    }
}