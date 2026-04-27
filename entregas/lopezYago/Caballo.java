package entregas.lopezYago;

public class Caballo {
    private int numero;

    public Caballo(int numero) {
        this.numero = numero;
    }

    public void moverse(Pista pista) {
        int avance = (int) (Math.random() * 3);
        pista.mover(numero - 1, avance); 
    }
    
}
