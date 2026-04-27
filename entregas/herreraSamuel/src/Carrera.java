public class Carrera {
    
    private Pista pista; 
    private Turno turno;
    

    public Carrera() {
        this.pista = new Pista(40, 2); 
        this.turno = new Turno();
    }

    public void jugar() {
        this.pista.mostrar(); 
        
        do {
            this.pista.avanzarCaballo(this.turno.leToca());
            this.turno.cambiar();
            
            if (this.turno.esRondaCompleta()) { 
                this.pista.mostrar();
            }
            
        } while (!this.pista.hayCaballoEnMeta());
        
        this.pista.anunciarGanador();
    }
}