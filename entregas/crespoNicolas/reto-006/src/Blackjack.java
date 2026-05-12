private Baraja baraja;
    private Jugador jugador;
    private Console console;
    private boolean jugando;

    public Blackjack () {}

    public void jugar () {}
    public void jugar () {
        
        do {
            
            this.repartirCartasIniciales();
            
            switch (jugando) {
                case 1 -> jugador.pedirCartas ();
                case 2 -> jugador.mostrarResultadoFinal();
                    break;
            
                default:
                    break;
            }

        } while (jugando);

    }

    private void prepararPartida () {}

    private void repartirCartasIniciales (
        
    ) {}

    private void gestionarTurno () {}

    private void mostrarResultadoFinal () {}
}
