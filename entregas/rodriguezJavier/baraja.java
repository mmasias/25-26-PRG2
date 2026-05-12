import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Carta> cartas;
    private int indiceActual;
    
    public Baraja() {
        this.cartas = new ArrayList<>();
        this.indiceActual = 0;
        this.construirBaraja();
        this.mezclar();
    }
    
    private void construirBaraja() {
        String[] valores = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        String[] palos = {"♥","♦","♣","♠"};
        
        for (String palo : palos) {
            for (String valor : valores) {
                this.cartas.add(new Carta(valor, palo));
            }
        }
    }
    
    private void mezclar() {
        Collections.shuffle(this.cartas);
    }
    
    public Carta repartirCarta() {
        if (this.indiceActual < this.cartas.size()) {
            return this.cartas.get(this.indiceActual++);
        }
        return null;
    }
    
    public void reiniciar() {
        this.indiceActual = 0;
        this.mezclar();
    }
}