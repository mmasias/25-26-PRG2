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

    private void mezclar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta temp = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = temp;
        }
    }

    public Carta sacar() {
        assert !vacia();
        ultima--;
        return cartas[ultima];
    }

    public boolean vacia() {
        return ultima == 0;
    }

    public Baraja() {
        // ...
        mezclar(); // añade esta línea
    }
}
