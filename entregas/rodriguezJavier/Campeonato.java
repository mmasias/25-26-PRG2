package entregas.rodriguezJavier;

public class Campeonato {
    private Ruta ruta;
    private Participante[] participantes;
    private int turno;
    
    public Campeonato() {
        this.ruta = new Ruta(40);
        this.participantes = new Participante[2];
        this.participantes[0] = new Participante(1);
        this.participantes[1] = new Participante(2);
        this.turno = (int) (Math.random() * 2);
    }
    
    public void iniciar() {
        boolean enJuego = true;
        
        while (enJuego) {
            this.ruta.dibujar(this.participantes);
            
            Participante actual = this.participantes[this.turno];
            actual.mover(this.ruta);
            
            if (this.ruta.hayFinal(this.participantes)) {
                enJuego = false;
            }
            
            this.cambiarParticipante();
        }
        
        this.ruta.mostrarCampeones(this.participantes);
    }
    
    private void cambiarParticipante() {
        this.turno = (this.turno + 1) % this.participantes.length;
    }
}