public class Caballo {
    private int numero;
    private int posicion;

    public Caballo(int numero){
        this.numero = numero;
        this.posicion = 0;
    }

    public void avanzar(){
        posicion = (int) (Math.random() * 3) + this.posicion;
    }
    public int obtenerPosicion(){
        return this.posicion;
    }
    public int obtenerNumero(){
        return this.numero;
    }
}