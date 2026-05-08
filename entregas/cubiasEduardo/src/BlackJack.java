class BlackJack {
    private Mano mano;

    public BlackJack() {
        mano = new Mano();

    }

    private void jugar() {
        Menu menu = new Menu();
        Dealer dealer = new Dealer(mano);

        boolean estaJugando = true;
        boolean haGanado = true;

       do {
            
        } while (estaJugando && !haGanado);
        console.writeln((!haGanado ? "NO " : "") + "GANASTE");
    }

    public static void main(String[] args) {
        new BlackJack().jugar();
    }
}