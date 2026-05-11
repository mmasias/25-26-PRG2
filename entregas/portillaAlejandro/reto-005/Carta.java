public class Carta {

    private int tipoPalo;
    private int valorCarta;
    private boolean visible;

    private final String[] PALOS = {"♠", "♥", "♦", "♣"};
    private final String[] VALORES = {"A", "2", "3", "4", "5", "6", "7","8", "9", "10", "J", "Q", "K"};

    private Console console;

    public Carta(int tipoPalo, int valorCarta) {

        this.tipoPalo = tipoPalo;
        this.valorCarta = valorCarta;
        this.visible = false;

        console = new Console();
    }

    public void mostrar() {

        String palo = "?";
        String valor = "?";

        if (visible) {

            palo = PALOS[tipoPalo];
            valor = VALORES[valorCarta];
        }

        console.write("[" + valor + " " + palo + "]");
    }

    public void voltear() {

        visible = !visible;
    }

    public boolean esAs() {

        return valorCarta == 0;
    }

    public int obtenerValor() {

        if (valorCarta == 0) {

            return 11;
        }

        if (valorCarta >= 10) {

            return 10;
        }

        return valorCarta + 1;
    }
}