class Blackjack {   
    private Console console;
    private int puntaje;
    private Baraja baraja;
    private Mano mano;
    private int CANTIDAD_INICIAL = 2;

    public Blackjack() {
        console = new Console();
        puntaje = 0;
        baraja = new Baraja();
        mano = new Mano();
        repartir();
    }

    private int obtenerPuntaje() {
        return mano.contarPuntos();
    }

    private void jugar() {
        Menu menu = new Menu();

        boolean estaJugando = true;
        boolean haPerdido = false;

        do {
            this.mostrarTapete();
            menu.mostrar();
            switch (menu.pedirOpcion()) {
                case 1 -> mano.pedirCarta(baraja);
                case 2 -> reiniciar();
                case 3 -> estaJugando = false;
            }
            puntaje = this.obtenerPuntaje();
            haPerdido = this.seHaPasado();
        } while (estaJugando && !haPerdido);
        console.writeln((haPerdido ? "NO " : "") + "GANASTE");
    }

    private void repartir() {
        for(int i = 0; i < CANTIDAD_INICIAL; i++) {
            mano.pedirCarta(baraja);
        }
    }

    private void reiniciar() {
        puntaje = 0;
        baraja = new Baraja();
        mano = new Mano();
        repartir();
    }

    private boolean seHaPasado() {
        return puntaje > 21;
    }

    
    private void mostrarTapete() {
        console.cleanScreen();
        mano.mostrar();
        this.linea();
        this.mostrarPuntaje();
        this.linea();
    }

    private void mostrarPuntaje() {
        console.writeln("Puntaje: " + puntaje);
    }
    private void linea() {
        console.writeln("-".repeat(30));
    }


    public static void main(String[] args) {
        new Blackjack().jugar();
    }
}
