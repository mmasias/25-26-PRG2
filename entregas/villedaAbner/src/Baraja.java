import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[52];
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 0; numero < 13; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.mezclar();
        console = new Console();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        console.writeln("BARAJA ");
        Carta carta = this.cima();
        carta.mostrar();
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public boolean estaVacia() {
        return ultima == 0;
    }

    public Carta sacar() {
        Carta donarCarta = this.cima();
        ultima--;

        return donarCarta;
    }

}
