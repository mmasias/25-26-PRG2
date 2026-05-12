import java.util.Random;

public class Baraja {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Baraja(){
        ultima = 0;
        cartas = new Carta[52];
        for(int palo=0;palo<4;palo++){
            for(int numero=0;numero<13;numero++){
                this.poner(new Carta(palo, numero));
            }
        }
        this.mezclar();
        console = new Console();
    }

    private void mezclar() {
        Random aleatorio = new Random();
        for(int i = 0; i<1000; i++){
            int origen = aleatorio.nextInt(52);
            int destino = aleatorio.nextInt(52);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }        
    }

    public void poner(Carta carta) {
        cartas[ultima]=carta;
        ultima++;
    }

    public void mostrar() {
        console.write("BARAJA: ");
        if (vacia()) {
            console.writeln("La baraja está vacía!!!");
        } else {
            Carta carta = cima();
            carta.mostrar();
            console.writeln();
        }
    }

    private Carta cima() {
        return cartas[ultima-1];
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            console.writeln("No hay cartas!!!");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
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
}
