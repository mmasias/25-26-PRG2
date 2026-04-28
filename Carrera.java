import java.util.Random;

public class Carrera {
    private Caballo caballo1;
    private Caballo caballo2;
    private Pista pista;
    private Random random;

    public Carrera() {
        this.caballo1 = new Caballo("Caballo 1");
        this.caballo2 = new Caballo("Caballo 2");
        this.pista = new Pista(40);
        this.random = new Random();
    }

public void jugar() {
        int turno = random.nextInt(2);
        
        while (caballo1.getPosicion() < pista.getLongitud() && 
               caballo2.getPosicion() < pista.getLongitud()) {
            
            if (turno == 0) caballo1.mover();
            else caballo2.mover();
            
            pista.mostrarEstado(caballo1, caballo2);
            turno = (turno == 0) ? 1 : 0;

            try { Thread.sleep(150); } catch (InterruptedException e) {}
        }
        
        determinarGanador();
    }

    private void determinarGanador() {
        if (caballo1.getPosicion() >= pista.getLongitud() && 
            caballo2.getPosicion() >= pista.getLongitud()) {
            System.out.println("Empate");
        } else if (caballo1.getPosicion() >= pista.getLongitud()) {
            System.out.println("Ganó el caballo 1");
        } else {
            System.out.println("Ganó el caballo 2");
        }
    }
}