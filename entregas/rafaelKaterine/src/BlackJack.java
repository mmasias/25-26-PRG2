class BlackJack {

    private Baraja baraja;
    private Carta[] misCartas;
    private int puntiaje;
    private Console console;

    public BlackJack() {
        baraja = new Baraja();
        console = new Console();
        misCartas = new Carta[52]; 
        puntiaje = 0;
    }
    private void iniciarNuevaPartida() {
            this.baraja = new Baraja();
            this.puntiaje = 0;
            this.recibirCarta();
            this.recibirCarta();
        }

    
}