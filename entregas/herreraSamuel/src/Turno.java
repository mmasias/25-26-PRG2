public class Turno {
    
    private int valorActual;
    private int turnoInicial; 

    public Turno() {

        this.valorActual = (int) (Math.random() * 2);

        this.turnoInicial = this.valorActual; 
    }

    public int leToca() {
        return this.valorActual;
    }

    public void cambiar() {
        if (this.valorActual == 0) {
            this.valorActual = 1;
        } else {
            this.valorActual = 0;
        }
    }

    public boolean esRondaCompleta() {
        return this.valorActual == this.turnoInicial;
    }
}