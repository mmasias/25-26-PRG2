import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Baraja baraja = new Baraja();
        Mano mano = new Mano();
        boolean jugando = true;

        while (jugando) {
            if (mano.estaVacia()) {
                baraja = new Baraja();
                mano.agregarCarta(baraja.sacarCarta());
                mano.agregarCarta(baraja.sacarCarta());
            }

            int puntaje = mano.obtenerPuntaje();
            String estado;
            
            // Evaluar el estado del juego
            if (puntaje == 21) {
                estado = "Ganó";
            } else if (puntaje > 21) {
                estado = "Perdió";
            } else {
                estado = "Sigue jugando";
            }

            // Mostrar interfaz
            System.out.println("--------------------");
            System.out.println("Mano: " + mano + " - Puntaje: " + puntaje + " ==> " + estado);
            System.out.println("--------------------");
            System.out.println("1. Pedir");
            System.out.println("2. Empezar de nuevo");
            System.out.println("3. Salir");
            System.out.println("--------------------");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    if (puntaje < 21) {
                        mano.agregarCarta(baraja.sacarCarta());
                    } else {
                        System.out.println("Ya no puedes pedir más cartas (Puntaje: " + puntaje + "). Empieza de nuevo.");
                    }
                    break;
                case "2":
                    mano.limpiar();
                    break;
                case "3":
                    jugando = false;
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}