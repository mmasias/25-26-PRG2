public class Dealer {
    private Baraja baraja;
    private Mano mano;
    private Console console;
    private Menu menu;

    public Dealer() {
        console = new Console();
        menu = new Menu();
    }

    public void jugar() {
        boolean jugando = true;
        this.reiniciar();

        do {
            mano.mostrar();
            menu.mostrar();
            
            switch (menu.pedirOpcion()) {
                case 1 -> this.pedir();
                case 2 -> this.reiniciar();
                case 3 -> jugando = false;
            }
        } while (jugando);
    }

    private void reiniciar() {
        baraja = new Baraja();
        mano = new Mano();
        this.pedir();
        this.pedir();
    }

    private void pedir() {
        if (mano.puedeJugar()) {
            Carta carta = baraja.sacar();
            mano.recibir(carta);
        } else {
            console.writeln("No puedes pedir más cartas, tu turno se acabó");
        }
    }

    public static void main(String[] args) {
        new Dealer().jugar();
    }
}