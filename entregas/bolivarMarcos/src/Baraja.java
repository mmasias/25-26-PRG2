package entregas.bolivarMarcos.src;

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
    
}
