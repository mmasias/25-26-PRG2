public class Dealer {

    private Baraja baraja;
    private Console console;
    private Mano mano;

    public Dealer() {
        this.console = new Console();
        this.reiniciar();
    }

    public void reiniciar() {
        baraja = new Baraja();
        baraja.mezclar();
        mano = new Mano();
    }

    public void repartirInicial(Mano manoJugador) {

        this.darCarta(manoJugador);
        this.darCarta(manoJugador);
    }

    public void darCarta(Mano manoDestino) {
        if (baraja.vacia()) {
            console.writeln("¡No quedan cartas en la baraja!");
        } else {
            Carta carta = baraja.sacar();
            carta.voltear();
            manoDestino.poner(carta);
        }
    }
}
