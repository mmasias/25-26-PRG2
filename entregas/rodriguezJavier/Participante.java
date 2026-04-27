package entregas.rodriguezJavier;

public class Participante {
    private int numero;
    private int avance;
    
    public Participante(int numero) {
        this.numero = numero;
        this.avance = 0;
    }
    
    public void mover(Ruta camino) {
        int pasos = (int) (Math.random() * 3);
        this.avance = this.avance + pasos;
        
        if (this.avance > 40) {
            this.avance = 40;
        }
    }
    
    public int getAvance() {
        return this.avance;
    }
    
    public int getNumero() {
        return this.numero;
    }
}