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

    public static void main(String[] args) {
        Blackjack juego = new Blackjack();
        juego.jugar();
    }

    public void jugar() {
        this.prepararPartida();
        this.repartirCartasIniciales();
        this.mostrarEstadoInicial();
        if (!this.jugador.tiene21() && !this.jugador.seHaPasado()) {
            this.gestionarTurno();
        }
        this.mostrarResultadoFinal();
    }

    private void prepararPartida() {
        this.baraja = new Baraja();
        this.jugador = new Jugador();
        jugando = true;
    }

    private void repartirCartasIniciales() {
        baraja.darA(jugador);
    }

    private void gestionarTurno() {
        while (jugando) {
            int decisionJugador = console.readInt("Pedir carta (1) o parar (2): ");

            switch (decisionJugador) {
                case 1 -> {
                    jugador.agarrar(baraja.sacar());
                    jugador.mostrarMano();
                    if (jugador.seHaPasado() || jugador.tiene21()) {
                        jugando = false;
                    }
                }
                case 2 -> jugando = false;
                default -> console.writeln("Opcion no valida");
            }
        }
    }

    private void mostrarEstadoInicial() {
        console.writeln("Mano inicial:");
        jugador.mostrarMano();

        if (jugador.consultarPuntaje() == 21) {
            console.writeln("¡Blackjack!");
        }
    }

    private void mostrarResultadoFinal() {
        console.writeln("Puntaje final: " + jugador.consultarPuntaje());

        if (jugador.seHaPasado()) {
            console.writeln("Te has pasado.");
        } else if (jugador.tiene21()) {
            console.writeln("¡Has conseguido 21!");
        }
    }
}
