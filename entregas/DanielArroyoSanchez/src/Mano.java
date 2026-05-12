public class Mano {

    private Carta[] cartas;
    private Console console;
    private int ultima;

    public Mano() {
        this.cartas = new Carta[20];
        this.ultima = 0;
        this.console = new Console();
    }

    public void poner(Carta carta) {
        if (ultima < cartas.length) {
            cartas[ultima] = carta;
            ultima++;
        }
    }

    public int getPuntaje() {
        int total = 0;
        int ases = 0;
        for (int i = 0; i < ultima; i++) {
            total += cartas[i].getValor();
            if (cartas[i].esAs()) {
                ases++;
            }
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }
