public class Mano {

    private Carta[] cartas;
    private int numCartas;
    private Console console;

    public Mano() {
        cartas = new Carta[11];
        numCartas = 0;
        console = new Console();
    }

    public void poner(Carta carta) {
        cartas[numCartas] = carta;
        numCartas++;
    }

    public int obtenerPuntaje() {
        int puntos = 0;
        int ases = 0;

        for (int i = 0; i < numCartas; i++) {
            if (cartas[i].esAs()) {
                ases++;
                puntos += 11;
            } else if (cartas[i].esFigura()) {
                puntos += 10;
            } else {
                puntos += cartas[i].getValor();
            }
        }

        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }

        return puntos;
    }

    public void mostrar() {
        console.write("Mano: ");
        for (int i = 0; i < numCartas; i++) {
            cartas[i].mostrar();
        }
        int puntaje = obtenerPuntaje();
        console.write(" - Puntaje: " + puntaje + " ==> ");
        if (puntaje < 21) {
            console.writeln("Sigue jugando");
        } else if (puntaje == 21) {
            console.writeln("Ganó");
        } else {
            console.writeln("Perdió");
        }
    }

    public boolean puedeSeguir() {
        return obtenerPuntaje() < 21;
    }
}