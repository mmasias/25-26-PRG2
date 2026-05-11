public class Mano {
    private Carta[] cartas;
    private int ultima;
    private Console console;

    final private int PUNTAJE_GANADOR = 21;
    final private int MAXIMO_CARTAS = 11;

    public Mano() {
        cartas = new Carta[MAXIMO_CARTAS];
        ultima = 0;
        console = new Console();
    }

    public void recibir(Carta carta) {
        carta.voltear();
        this.poner(carta);
    }

    private void poner(Carta carta) {
        assert ultima < MAXIMO_CARTAS : "Superó el limite de cartas en la mano";
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        console.writeln("-".repeat(20));
        console.write("Mano: ");
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
        String estado = this.haGanado() ? "Ganó" : (this.haPerdido() ? "Perdió" : "Sigue jugando");

        console.writeln(" - Puntaje: " + this.obtenerPuntaje() + " ==> " + estado);
        console.writeln("-".repeat(20));
    }

    public boolean haGanado() {
        return this.obtenerPuntaje() == PUNTAJE_GANADOR;
    }

    public boolean haPerdido() {
        return this.obtenerPuntaje() > PUNTAJE_GANADOR;
    }

    public boolean puedeJugar() {
        return !this.haGanado() && !this.haPerdido();
    }

    private int obtenerPuntaje() {
        int puntaje = 0;
        int ases = 0;

        for (int i = 0; i < ultima; i++) {
            Carta carta = cartas[i];
            int valor = carta.getNumero() + 1;
            
            if (valor >= 10) {
                valor = 10;
            } else if (valor == 1) {
                ases++;
                valor = 11;
            }
            puntaje = puntaje + valor;
        }

        for (; puntaje > PUNTAJE_GANADOR && ases > 0; ases--) {
            puntaje = puntaje - 10;
        }

        return puntaje;
    }

}