import java.util.Random;
class Baraja{


    private String[] palos = {"♥", "♦", "♣", "♠"};

    private String[] valores = {
        "A", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "J", "Q", "K"
    };

    private Random random = new Random();

    public Carta sacarCarta(){
        String valor = valores[random.nextInt(valores.length)];
        String palo = palos[random.nextInt(palos.length)];

        return new Carta(valor, palo);
    }



}