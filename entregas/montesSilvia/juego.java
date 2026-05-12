import java.util;

public class Juego {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Baraja baraja = new Baraja();

        int opcion;

        do {
             Mano mano = new Mano();
            mano.agregarCarta(baraja.sacarCarta());
            mano.agregarCarta(baraja.sacarCarta());

            boolean jugando = true;

            while (jugando) {

                int puntos = mano.calcularPuntos();

                System.out.println("--------------------");
                System.out.println("Mano: " + mano +
                        " - Puntaje: " + puntos +
                        obtenerEstado(puntos));

                System.out.println("--------------------");
                System.out.println("1. Pedir");
                System.out.println("2. Empezar de nuevo");
                System.out.println("3. Salir");
                System.out.println("--------------------");

                opcion = sc.nextInt();

                switch (opcion) {

                    case 1:

                        if (puntos < 21) {
                            mano.agregarCarta(baraja.sacarCarta());
                        }

                        break;

                    case 2:
                        jugando = false;
                        break;

                    case 3:
                        System.out.println("Juego terminado");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                }
            }

        } while (true);
    }

    public static String obtenerEstado(int puntos) {

        if (puntos > 21) {
            return " ==> Perdió";
        } else if (puntos == 21) {
            return " ==> Ganó";
        } else {
            return " ==> Sigue jugando";
        }
    }
}