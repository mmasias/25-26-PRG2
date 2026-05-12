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

    public int contarPuntos() {
        int puntos = 0;
        int ases = 0;
        for (int i = 0; i < tamaño; i++) {
            if (cartas[i].esAs()) ases++;
            puntos += cartas[i].obtenerValor();
            if (puntos > 21 && ases > 0) {
                puntos -= 10;
                ases--;
            }
        }
        return puntos;
    }
}
