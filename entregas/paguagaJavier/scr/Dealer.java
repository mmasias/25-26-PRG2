public class Dealer extends Participante {
    private Baraja baraja;

    public Dealer() {
        super("Dealer");
        this.baraja = new Baraja();
    }

    public Carta repartir() {
        return baraja.extraerCarta();
    }

    public void nuevaBaraja() {
        baraja.mezclar();
    }
}
