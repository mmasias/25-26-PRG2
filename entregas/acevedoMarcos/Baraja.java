import java.util.Random;

public class Baraja {
    private Carta[] cartas;
    private int ultima;

    public Baraja() {
        this.cartas = new Carta[52];
        this.ultima = 0;
        for (int p = 0; p < 4; p++) {
            for (int n = 0; n < 13; n++) {
                this.poner(new Carta(p, n));
            }
        }
        this.mezclar();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta temporal = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = temporal;
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public boolean vacia() {
        return ultima == 0;
    }
}