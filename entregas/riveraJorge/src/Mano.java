import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<Carta> cartas;
    private int puntaje;

    public Mano() {
        this.cartas = new ArrayList<>();
        this.puntaje = 0;
    }

    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }

    private void calcularPuntaje() {
    int total = 0;
    int contadorAses = 0;

    for (Carta c : cartas) {
        total += c.getValorNumerico();
        if (c.getRango().equals("A")) {
            contadorAses++;
        }
    }

    while (total > 21 && contadorAses > 0) {
        total -= 10;
        contadorAses--;
    }
        this.puntaje = total;
    
    }

    
        public String toString() {
        String resultado = "Mano: ";
    
   
        for (Carta c : cartas) {
            resultado = resultado + c.toString(); 
        }
    
        resultado = resultado + " - Puntaje: " + this.puntaje + " ==> " + getEstado();
    
        return resultado;
    }
}