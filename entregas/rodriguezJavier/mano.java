import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;
    
    public Mano() {
        this.cartas = new ArrayList<>();
    }
    
    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);
    }
    
    public int calcularPuntaje() {
        int suma = 0;
        int cantidadAses = 0;
        
        for (Carta c : this.cartas) {
            int valor = c.getValorNumerico();
            suma = suma + valor;
            if (c.getValor().equals("A")) {
                cantidadAses++;
            }
        }
        
        while (cantidadAses > 0 && suma + 10 <= 21) {
            suma = suma + 10;
            cantidadAses--;
        }
        
        return suma;
    }
    
    public void mostrar() {
        for (Carta c : this.cartas) {
            System.out.print(c);
        }
    }
    
    public int size() {
        return this.cartas.size();
    }
}