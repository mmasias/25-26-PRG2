import java.util.Random;
public class Caballo {
    private int numero;
    private int posicion;
    private Random random;

    public Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
        this.random = new Random();
    }

    public void avanzar() {
        this.posicion+= random.nextInt(3);
    }

    public int getPosicion() {return posicion;}
    public int getNumero() {return numero;}
    
}
