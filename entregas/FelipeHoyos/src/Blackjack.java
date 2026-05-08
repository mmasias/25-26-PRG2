import java.io.Console;

public class Blackjack {

    private Baraja baraja;
    private Descarte descarte;
    private Mano mano;
    private Menu menu;
    private Console console;

    public Blackjack() {
        baraja = new Baraja();
        descarte = new Descarte();
        mano = new Mano();
        menu = new Menu();
        console = new Console();
    }

    private void jugar() {
        int opcion;

        this.empezarDeNuevo();
        do {
            this.mostrarEstado();
            opcion = menu.pedirOpcion();
            this.procesar(opcion);
         } while (opcion != 3);
    }

    private void procesar(int opcion) {
        switch (opcion) {
            case 1:
                this.pedirCarta();
                return;
            case 2:
                this.empezarDeNuevo();
                return;
            case 3:
                this.salir();
                return;
            default:
                console.println("Opción no válida");
        }
    }

    private void pedirCarta() {
        if (baraja.hayCartas()) {
            baraja.moverA(descarte);
            descarte.moverA(mano);

            if (mano.haPerdido()) {
                console.writeln("Has perdido");
            }
        }
    }

    private void empezarDeNuevo() {
        baraja = new Baraja();
        descarte = new Descarte();
        mano = new Mano();

        this.pedirCarta();
        this.pedirCarta();
    }

    private void salir() {
        console.writeln("saliendo...");
    }

    private void mostrarEstado() {
        console.writeln("-------------------------------------");
        mano.mostyar();
        console.writeln("Puntaje: " + mano.puntaje());
        console.writeln("-------------------------------------");
    }
