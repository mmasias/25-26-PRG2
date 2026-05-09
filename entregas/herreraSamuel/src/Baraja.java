public class Baraja {
    private Carta[] cartas;
    private int siguiente;

    public Baraja() {
        cartas = new Carta[52];
        siguiente = 0;
        this.inicializarCartas(); 
        this.barajar();           
    }

    public Carta repartir() {
     
    }


}
