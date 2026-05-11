class BlackJack {

    private Baraja baraja;
    private Mano mano;
    private Console console;

    public BlackJack() {
        baraja = new Baraja();
        mano = new Mano();
        console = new Console();
    }

    private void jugar() {
        Menu menu = new Menu();
        prepararPartida();

        boolean salir = false;
        do {
            mostrarTapete();
            int opcion = menu.pedirOpcion();
            switch (opcion) {
                case 1 -> pedirCarta();
                case 2 -> prepararPartida();
                case 3 -> salir = true;
            }
        } while (!salir);
    }

    private void prepararPartida() {
        baraja = new Baraja();
        mano = new Mano();
        mano.poner(baraja.sacar());
        mano.poner(baraja.sacar());
    }

    private void pedirCarta() {
        if (mano.puedeSeguir()) {
            mano.poner(baraja.sacar());
        } else {
            console.writeln("No puedes pedir más cartas.");
        }
    }

    private void mostrarTapete() {
        console.writeln("--------------------");
        mano.mostrar();
        console.writeln("--------------------");
    }

    public static void main(String[] args) {
        new BlackJack().jugar();
    }
}