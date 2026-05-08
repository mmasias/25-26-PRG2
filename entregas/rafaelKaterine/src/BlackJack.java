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
    private void recibirCarta() {
            Carta carta = baraja.sacar();
            carta.voltear();
            misCartas[puntuaje] = carta;
            puntuaje++;
        }

    private void jugar() {
        Menu menu = new Menu();
        boolean estaJugando = true;
        boolean haGanado = false;

        this.iniciarPartida();

        do {
            this.mostrarEstado(); 
            menu.mostrar();

            switch (menu.pedirOpcion()) {
                case 1 -> { this.recibirCarta();
                    if (this.obtenerPuntaje() > 21) {
                        estaJugando = false;
                    }
                }
                case 2 -> { this.iniciarPartida(); }
                case 3 -> { estaJugando = false; }
                default -> console.writeln("Opción no válida");
            }

            haGanado = (this.obtenerPuntaje() == 21);

        } while (estaJugando && !haGanado);

        this.mostrarEstado();
        if (haGanado) {
            console.writeln("¡GANASTE! (Blackjack)");
        } else if (this.obtenerPuntaje() > 21) {
            console.writeln("TE PASASTE... NO GANASTE");
        } else {
            console.writeln("TE PLANTASTE CON " + this.obtenerPuntaje() + " PUNTOS");
        }
    }

    private void mostrarEstado() {
        console.writeln("Tus cartas:");
        for (int i = 0; i < puntiaje; i++) {
            misCartas[i].mostrar();
        }
        console.writeln("Puntaje actual: " + this.obtenerPuntaje());
    }



        
    
}