public class Blackjack {
    private Baraja baraja;
    private Mano mano;
    private Menu menu;

    public Blackjack() {
        this.baraja = new Baraja();
        this.menu = new Menu();
        this.mano = new Mano();
    }

    public void jugar() {
        boolean salir = false;
        this.repartirManoInicial();

        while (!salir) {
            mano.mostrar();
            int opcion = menu.obtenerOpcion();

            switch (opcion) {
                case 1 -> {
                    if (mano.puedeSeguir()) {
                        mano.recibirCarta(baraja.repartir());
                    } else {
                        System.out.println("Acción no permitida: Ya no puedes pedir más cartas.");
                    }
                }
                case 2 -> this.repartirManoInicial();
                case 3 -> salir = true;
                default -> {

                    assert false : "Error crítico: Opción no gestionada: " + opcion;
                }
            }
        }
        System.out.println("Fin de la sesión. ¡Hasta la próxima!");
    }

    private void repartirManoInicial() {
        mano.limpiar();
        for (int i = 0; i < 2; i++) {
            mano.recibirCarta(baraja.repartir());
        }
    }
}
