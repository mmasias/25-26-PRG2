public class BlackJack {
    private Baraja baraja;
    private Mano mano;
    private Console console;
    private boolean haGanado;
    private boolean estaJugando = true;

    private final int NUMERO_PALOS = 4;

    public BlackJack() {
        baraja = new Baraja();
        console = new Console();
        mano = new Mano();
    }

    private void jugar() {
        Menu menu = new Menu();
        mano.roboInicial(baraja);
        do {

            mano.mostrar();
            menu.mostrar();
            int opcion = menu.pediropcion();
            switch (opcion) {
                case 1:
                    mano.agarrar(baraja);
                    break;
                case 2:
                    mano.reiniciar(baraja);
                    break;
                case 3:
                    estaJugando = false;
                    break;
                default:
                    console.writeln("Opcion inavlidaa");
            }
            haGanado = this.validarFinal();

        } while (!haGanado && estaJugando);
        mano.mostrar();

    }

    private boolean validarFinal() {
        return mano.getPuntaje() >= 21;
    }

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.jugar();
    }
}
