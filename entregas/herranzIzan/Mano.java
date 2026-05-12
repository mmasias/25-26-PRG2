public class Mano {
    private Carta[] cartas;
    private int tamaño;
    private final int MAXIMO_DE_CARTAS = 11;
    private Console console;

    public Mano() {
        cartas = new Carta[MAXIMO_DE_CARTAS];
        tamaño = 0;
        console = new Console();
    }

    public void pedirCarta(Baraja baraja) {
        cartas[tamaño] = baraja.sacar();
        tamaño++;
    }

    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            cartas[i].mostrar();
        }
    }
}
