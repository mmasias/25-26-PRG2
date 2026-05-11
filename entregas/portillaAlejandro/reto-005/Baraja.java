import java.util.Random;

public class Baraja {

    private Carta[] mazo;
    private int cantidadCartas;

    public Baraja() {

        mazo = new Carta[52];
        cantidadCartas = 0;

        for (int palo = 0; palo < 4; palo++) {

            for (int valor = 0; valor < 13; valor++) {

                mazo[cantidadCartas] = new Carta(palo, valor);
                cantidadCartas++;
            }
        }

        barajar();
    }

    private void barajar() {

        Random random = new Random();

        for (int i = 0; i < mazo.length; i++) {

            int posicionAleatoria = random.nextInt(mazo.length);

            Carta auxiliar = mazo[i];
            mazo[i] = mazo[posicionAleatoria];
            mazo[posicionAleatoria] = auxiliar;
        }
    }

    public Carta robarCarta() {

        if (estaVacia()) {
            return null;
        }

        cantidadCartas--;
        return mazo[cantidadCartas];
    }

    public boolean estaVacia() {
        return cantidadCartas == 0;
    }
}