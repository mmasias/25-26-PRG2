package entregas.rodriguezJavier;

public class Ruta {
    private int distancia;
    
    public Ruta(int distancia) {
        this.distancia = distancia;
    }
    
    public void dibujar(Participante[] corredores) {
        for (int i = 0; i < this.distancia; i++) {
            System.out.print("=");
        }
        System.out.println();
        
        for (Participante p : corredores) {
            for (int i = 0; i < p.getAvance(); i++) {
                System.out.print(" ");
            }
            System.out.println(">-=<");
        }
        
        for (int i = 0; i < this.distancia; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.println();
    }
    
    public boolean hayFinal(Participante[] corredores) {
        for (Participante p : corredores) {
            if (p.getAvance() >= this.distancia) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarCampeones(Participante[] corredores) {
        System.out.println("---- CARRERA TERMINADA ----");
        for (Participante p : corredores) {
            if (p.getAvance() >= this.distancia) {
                System.out.println("Caballo " + p.getNumero() + " es campeon!");
            }
        }
    }
}