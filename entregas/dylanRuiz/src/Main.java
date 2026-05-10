import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            Baraja baraja = new Baraja();
            Mano jugador = new Mano();

            jugador.añadirCarta(baraja.darCarta());
            jugador.añadirCarta(baraja.darCarta());

            boolean jugandoMano = true;
            while (jugandoMano) {
                int puntos = jugador.calcularPuntaje();
                String estado = (puntos == 21) ? "Ganó" : (puntos > 21) ? "Perdió" : "Sigue jugando";

                System.out.println("--------------------");
                System.out.println("Mano: " + jugador.mostrarCartas() + " - Puntaje: " + puntos + " ==> " + estado);
                System.out.println("--------------------");
                System.out.println("1. Pedir");
                System.out.println("2. Empezar de nuevo");
                System.out.println("3. Salir");
                System.out.println("--------------------");

                String opcion = teclado.nextLine();

                if (opcion.equals("1")) {
                    if (puntos < 21) {
                        jugador.añadirCarta(baraja.darCarta());
                    } else {
                        System.out.println("No puedes pedir más cartas.");
                    }
                } else if (opcion.equals("2")) {
                    jugandoMano = false; 
                } else if (opcion.equals("3")) {
                    jugandoMano = false;
                    salir = true;
                    System.out.println("¡Gracias por jugar!");
                }
            }
        }
        teclado.close();
    }
}
