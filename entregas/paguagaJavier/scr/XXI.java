public class XXI {
    private Dealer dealer;
    private Jugador jugador;
    private Console console;
    private Menu menu;

    public static void main(String[] args) {
        new XXI().jugar();
    }

    public XXI() {
        this.dealer = new Dealer();
        this.jugador = new Jugador();
        this.console = new Console();
        this.menu = new Menu();
    }

    private void jugar() {
        prepararPartida();
        boolean salir = false;

        do {
            console.writeln("--------------------");
            jugador.mostrarEstado();
            imprimirEstadoJuego();
            console.writeln("--------------------");
            
            menu.mostrar();
            int opcion = menu.pedirOpcion();

            switch (opcion) {
                case 1 -> { // Pedir
                    if (jugador.getPuntaje() < 21) {
                        jugador.recibirCarta(dealer.repartir());
                    }
                }
                case 2 -> prepararPartida(); // Reiniciar
                case 3 -> salir = true;      // Salir
                default -> console.writeln("Opción no válida");
            }
        } while (!salir);
    }

    private void prepararPartida() {
        jugador.limpiarMano();
        dealer.nuevaBaraja();
        jugador.recibirCarta(dealer.repartir());
        jugador.recibirCarta(dealer.repartir());
    }

    private void imprimirEstadoJuego() {
        int puntaje = jugador.getPuntaje();
        if (puntaje == 21) console.write(" ==> Ganó");
        else if (puntaje > 21) console.write(" ==> Perdió");
        else console.write(" ==> Sigue jugando");
        console.writeln("");
    }
}
