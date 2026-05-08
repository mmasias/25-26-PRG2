class BlackJack {

    private Baraja baraja;
    private Carta[] misCartas;
    private int numMisCartas;
    private Console console;

    public BlackJack() {
        baraja = new Baraja();
        console = new Console();
        misCartas = new Carta[52]; 
        numMisCartas = 0;
    }

}