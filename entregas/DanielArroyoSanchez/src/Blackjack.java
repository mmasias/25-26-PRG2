public class Blackjack {

    private Console console = new Console();
    private Mano mano;
    private Menu menu;
    private Dealer dealer;

    public Blackjack() {
        mano = new Mano();
        menu = new Menu();
        dealer = new Dealer();

    }

    private void jugar() {
        boolean estaJugando = true;

        dealer.repartirInicial(mano);
        mano.tieneBlackjack();

        do {
            console.cleanScreen();
            this.mostrarTapete();
            switch (menu.pedirOpcion()) {
                case 1:
                    this.pedirCarta();
                    break;
                case 2:
                    dealer.reiniciar();
                    this.mano = new Mano();
                    dealer.repartirInicial(mano);
                    break;
                case 3:
                    estaJugando = false;
                    break;
            }
        } while (estaJugando);

    }

    private void mostrarTapete() {
        this.linea();
        console.write("Mano: ");
        mano.mostrar();
        this.linea();
        menu.mostrar();
        this.linea();

    }

    private void linea() {
        console.writeln("------------------------------");
    }

    private void pedirCarta() {
        if (!mano.haGanado() && !mano.seHaPasado()) {
            dealer.darCarta(mano);
        } else if (mano.haGanado()) {
            console.writeln("Has Ganado!!, empieza una nueva partida o sal.");
        } else if (mano.seHaPasado()) {
            console.writeln("Has Perdido!!, empieza una nueva partida o sal.");

        } else {
            console.writeln("Has perdido, vuelve a empezar o sal.");
        }
    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }

}
