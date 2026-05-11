import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Baraja baraja = new Baraja();
        Mano mano = new Mano();
        boolean jugando = true;

            mano.agregarCarta(baraja.repartir());
            mano.agregarCarta(baraja.repartir());

            while (jugando) {
                System.out.println("--------------------");
                System.out.println(mano);
                System.out.println("--------------------");
                System.out.println("1. Pedir");
                System.out.println("2. Empezar de nuevo");
                System.out.println("3. Salir");
                System.out.println("--------------------");

                String opcion = entrada.nextLine();
            }

            if (opcion.equals("1")) {
               
                if (mano.getEstado().equals("Sigue jugando")) {
                    mano.agregarCarta(baraja.repartir());
                
                    if (!mano.getEstado().equals("Sigue jugando")) {
                        System.out.println("--------------------");
                        System.out.println(mano);
                    }
                } else {
                    System.out.println("La partida terminó. Elige "Empezar de nuevo".");
                }

                } else if (opcion.equals("2")) {          
                baraja = new Baraja();
                mano = new Mano();
                mano.agregarCarta(baraja.repartir());
                mano.agregarCarta(baraja.repartir());

            } else if (opcion.equals("3")) {
                System.out.println("¡Gracias por jugar!");
                jugando = false;
            }
        }
        entrada.close();
    }
}
