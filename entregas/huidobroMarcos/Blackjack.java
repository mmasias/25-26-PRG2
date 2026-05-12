import java.util.Scanner;

class Blackjack{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

         while (opcion != 3) {
            Baraja baraja = new Baraja();
            Mano mano = new Mano();

            // Repartir dos cartas iniciales
            mano.agregarCarta(baraja.sacarCarta());
            mano.agregarCarta(baraja.sacarCarta());

            boolean partidaTerminada = false;

            while (!partidaTerminada) {
                int puntos = mano.calcularPuntos();

                System.out.println("--------------------");
                System.out.println("Mano: " + mano +
                                   " - Puntaje: " + puntos +
                                   " ==> " + obtenerEstado(puntos));
                System.out.println("--------------------");
                System.out.println("1. Pedir");
                System.out.println("2. Empezar de nuevo");
                System.out.println("3. Salir");
                System.out.println("--------------------");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        if (puntos < 21) {
                            mano.agregarCarta(baraja.sacarCarta());
                        }
                        break;

                    case 2:
                        partidaTerminada = true;
                        break;

                    case 3:
                        partidaTerminada = true;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }

                if (mano.calcularPuntos() >= 21 && opcion == 1) {
                    // Mostrar el resultado final y esperar opción 2 o 3
                    puntos = mano.calcularPuntos();

                    System.out.println("--------------------");
                    System.out.println("Mano: " + mano +
                                       " - Puntaje: " + puntos +
                                       " ==> " + obtenerEstado(puntos));
                    System.out.println("--------------------");
                    System.out.println("1. Pedir");
                    System.out.println("2. Empezar de nuevo");
                    System.out.println("3. Salir");
                    System.out.println("--------------------");

                    opcion = teclado.nextInt();

                    if (opcion == 2 || opcion == 3) {
                        partidaTerminada = true;
                    }
                }
            }
        }

        teclado.close();
    }

    public static String obtenerEstado(int puntos) {
        if (puntos == 21) {
            return "Ganó";
        } else if (puntos > 21) {
            return "Perdió";
        } else {
            return "Sigue jugando";
        }

        }
}

    



