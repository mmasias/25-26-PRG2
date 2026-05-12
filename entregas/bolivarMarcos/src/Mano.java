package entregas.bolivarMarcos.src;

public class Mano {
    
    private Carta[] cartas;
    private int contador;
    private Console console;

    public Mano() {
        this.cartas = new Carta[21];  
        this.contador = 0;
        this.console = new Console();
    }
}
