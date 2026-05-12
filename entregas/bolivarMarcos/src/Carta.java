package entregas.bolivarMarcos.src;

import java.io.Console;

public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;
    private final int MIN_PARA_VALOR_DIEZ = 9;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
        console = new Console();
    }
    
}
