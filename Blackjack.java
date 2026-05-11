class Blackjack {

    private Baraja baraja;
    private Mano mano;
    private Console console;
    private Menu menu;

    private final int NUMERO_GANADOR = 21;

    public Blackjack() {
        baraja = new Baraja();
        mano = new Mano();
        console = new Console();
        menu = new Menu();
    }

    public void jugar() {

        boolean finJuego = false;

        while (!finJuego) {

            menu.mostrar();
            mano.mostrarManoInicial();

            int opcion = console.leerOpcion();

            switch (opcion) {

                case 1 -> mano.pedirCarta(baraja);

                case 2 -> {
                    System.out.println("Te has plantado.");
                    finJuego = true;
                }

                case 3 -> {
                    mano.volverAJugar();
                    baraja = new Baraja();
                }

                default -> System.out.println("Opción inválida");
            }

            finJuego = validarFinal();
        }
    }

    private boolean validarFinal() {

        int puntos = mano.calcularPuntos();

        if (puntos == NUMERO_GANADOR) {
            System.out.println("¡Has ganado!");
            return true;

        } else if (puntos > NUMERO_GANADOR) {
            System.out.println("¡Has perdido!");
            return true;

        } else {
            System.out.println("Llevas " + puntos + " puntos.");
            return false;
        }
    }
}