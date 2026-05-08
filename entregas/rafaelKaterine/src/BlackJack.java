class BlackJack {

    private Baraja baraja;
    private Carta[] misCartas;
    private int puntuaje;
    private Console console;
    private int PUNTUAJE_GANADOR = 21;

    public BlackJack() {
        baraja = new Baraja();
        console = new Console();
        misCartas = new Carta[52]; 
        puntuaje = 0;
    }
    private void iniciarNuevaPartida() {
            this.baraja = new Baraja();
            this.puntuaje = 0;
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
                    if (this.obtenerPuntaje() > PUNTUAJE_GANADOR) {
                        estaJugando = false;
                    }
                }
                case 2 -> { this.iniciarPartida(); }
                case 3 -> { estaJugando = false; }
                default -> console.writeln("Opción no válida");
            }

            haGanado = (this.obtenerPuntaje() == PUNTUAJE_GANADOR);

        } while (estaJugando && !haGanado);

        this.mostrarEstado();
        if (haGanado) {
            console.writeln("¡GANASTE! (Blackjack)");
        } else if (this.obtenerPuntaje() > PUNTUAJE_GANADOR) {
            console.writeln("TE PASASTE... NO GANASTE");
        } else {
            console.writeln("TE PLANTASTE CON " + this.obtenerPuntaje() + " PUNTOS");
        }
    }

    private void mostrarEstado() {
        console.writeln("Tus cartas:");
        for (int i = 0; i < puntuaje; i++) {
            misCartas[i].mostrar();
        }
        console.writeln("Puntaje actual: " + this.obtenerPuntaje());
    }

    private int obtenerPuntaje() {
        int total = 0;
        int contadorAses = 0;
        for (int i = 0; i < this.puntuaje; i++) {
            int indiceCarta = misCartas[i].obtenerValor();

            if (indiceCarta == 0) { 
                contadorAses++;
                total += 11;
            } else if (indiceCarta >= 9) { 
                total += 10;
            } else {
                total += (indiceCarta + 1);
            }
        }

        while (total > PUNTUAJE_GANADOR && contadorAses > 0) {
            total -= 10;
            contadorAses--;
        }

        return total;
    }

        
    
}