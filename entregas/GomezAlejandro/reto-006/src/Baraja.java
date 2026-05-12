import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private int cartasDisponibles;

    public Baraja() {
        cartasDisponibles = 0;
        cartas = new Carta[52];

        for (int palo = 0; palo < 4; palo++) {
            for (int rango = 0; rango < 13; rango++) {
                this.poner(new Carta(palo, rango));
            }
        }
        this.mezclar();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for (int i = cartas.length - 1; i > 0; i--) {
            int posicionAzar = aleatorio.nextInt(i + 1);
            Carta temporal = cartas[i];
            cartas[i] = cartas[posicionAzar];
            cartas[posicionAzar] = temporal;
        }
    }

    public void poner(Carta carta) {
        cartas[cartasDisponibles] = carta;
        cartasDisponibles++;
    }

    public Carta sacar() {
        assert !vacia();
        cartasDisponibles--;
        return cartas[cartasDisponibles];
    }

    public boolean vacia() {
        return cartasDisponibles == 0;
    }
}
