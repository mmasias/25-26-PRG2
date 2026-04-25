public class Turno {

    private int valor;
    private int maximo;

    public Turno(int numeroCaballos){
        valor = (int) (Math.random() * numeroCaballos);
        maximo = numeroCaballos;
    }

    public void cambiar() {
        valor = this.noLeToca();
    }

    public int toca() {
        return valor;
    }

    public int noLeToca() {
        return (valor+1)% maximo;
    }
    
}
