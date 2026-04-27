public class Turno{
    private int turnoActual;
    private int cantidadCaballos;
    public Turno(int cantidadCaballos){
        this.cantidadCaballos = cantidadCaballos;
        this.turnoActual = (int) (Math.random() * cantidadCaballos);
    }

    public int toca(){
        return this.turnoActual;
    }
    public void cambiar(){
        this.turnoActual = (this.turnoActual + 1) % cantidadCaballos;
    }
}