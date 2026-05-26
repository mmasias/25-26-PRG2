public class Mano {
    private Carta[] cartas;
    private int ultima;
    private Console console;
    final int PUNTAJE_GANADOR = 21;
    final int MAXIMO_CARTAS = 11;

    public Mano() {
        this.cartas = new Carta[MAXIMO_CARTAS];
        this.ultima = 0;
        this.console = new Console();
    }

    public void recibir(Carta carta) {
        if (ultima < MAXIMO_CARTAS) {
            cartas[ultima] = carta;
            ultima++;
        }
    }

    public void limpiar() {
        this.ultima = 0;
    }

    public int obtenerPuntaje() {
        int puntaje = 0;
        int contadorAses = 0;

        for (int i = 0; i < ultima; i++) {
            Carta carta = cartas[i];
            if (carta.esAs()) {
                puntaje += 11;
                contadorAses++;
            } else if (carta.esFigura()) {
                puntaje += 10;
            } else {
                puntaje += (carta.getNumero() + 1);
            }
        }

        while (puntaje > 21 && contadorAses > 0) {
            puntaje -= 10;
            contadorAses--;
        }

        return puntaje;
    }

    public void mostrar() {
        console.write("Mano: ");
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
        int puntaje = obtenerPuntaje();
        console.write(" - Puntaje: " + puntaje);
    }

    public boolean haGanado() {
        return obtenerPuntaje() == PUNTAJE_GANADOR;
    }

    public boolean haPerdido() {
        return obtenerPuntaje() > PUNTAJE_GANADOR;
    }

    public boolean puedeJugar() {
        return obtenerPuntaje() < PUNTAJE_GANADOR;
    }
}
