import java.util.Random;

public class Baraja {
    private Carta[] cartas;
    private int ultima;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[52];
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 0; numero < 13; numero++) {
                poner(new Carta(palo, numero));
            }
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }
}
