import java.util.Scanner;

public class JuegoBlackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a Blackjack XXI");
        boolean salir = false;
        while (!salir) {
            System.out.println("--------------------");
            System.out.println("1. Empezar juego");
            System.out.println("2. Salir");
            System.out.println("--------------------");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    jugarPartida(scanner);
                    break;
                case "2":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    private static void jugarPartida(Scanner scanner) {
        Baraja baraja = new Baraja();
        baraja.barajar();
        Mano mano = new Mano();
        mano.agregarCarta(baraja.sacarCarta());
        mano.agregarCarta(baraja.sacarCarta());
        boolean jugando = true;
        while (jugando) {
            System.out.println("--------------------");
            System.out.println("Mano: " + mano.mostrar() + " - Puntaje: " + mano.calcularPuntaje() + mostrarEstado(mano));
            System.out.println("--------------------");
            System.out.println("1. Pedir");
            System.out.println("2. Empezar de nuevo");
            System.out.println("3. Salir");
            System.out.println("--------------------");
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    mano.agregarCarta(baraja.sacarCarta());
                    if (mano.calcularPuntaje() > 21) {
                        System.out.println("--------------------");
                        System.out.println("Mano: " + mano.mostrar() + " - Puntaje: " + mano.calcularPuntaje() + " ==> Perdió");
                        System.out.println("--------------------");
                        jugando = false;
                    } else if (mano.calcularPuntaje() == 21) {
                        System.out.println("--------------------");
                        System.out.println("Mano: " + mano.mostrar() + " - Puntaje: 21 ==> Ganó");
                        System.out.println("--------------------");
                        jugando = false;
                    }
                    break;
                case "2":
                    jugarPartida(scanner);
                    return;
                case "3":
                    jugando = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static String mostrarEstado(Mano mano) {
        int puntaje = mano.calcularPuntaje();
        if (puntaje < 21) {
            return " ==> Sigue jugando";
        } else if (puntaje == 21) {
            return " ==> Ganó";
        } else {
            return " ==> Perdió";
        }
    }
}
