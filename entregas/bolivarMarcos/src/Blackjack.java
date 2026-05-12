package entregas.bolivarMarcos.src;

public class Blackjack {
    private Baraja baraja;
    private Jugador jugador;
    private Console console;
    private boolean jugando;

    public Blackjack() {
        this.console = new Console();
        this.jugador = new Jugador();
        this.jugando = false;
    }
    
}
