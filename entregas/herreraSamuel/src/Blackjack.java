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

        do {
            mano.mostrar(); 
            int opcion = menu.obtenerOpcion();

            switch (opcion) {
                case 1 -> {
                    if (mano.puedeSeguir()) {
                        mano.recibirCarta(baraja.repartir());
                    }
                }
                case 2 -> this.repartirManoInicial();
                case 3 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        } while (!salir);
    }

    private void repartirManoInicial() {
        mano = new Mano();
        mano.recibirCarta(baraja.repartir());
        mano.recibirCarta(baraja.repartir());
    }
}
