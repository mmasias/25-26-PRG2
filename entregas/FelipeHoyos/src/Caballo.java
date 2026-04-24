public class Caballo {

    private int numero;
    private int posicion;
    
    public Caballo(int numero){
        assert numero > 0;

        this.numero = numero;
        posicion = 0;
    }

    public int numero() {
        return numero; 
    }

    public int posicion() {
        return posicion;
    }

    public void avanzar() {
        posicion = posicion + this.obtenerAvance();
    }

    public boolean haLlegado(Pista pista) {
        assert pista != null;

        return posicion >= pista.longitud();
    }

    private int obtenerAvance() {
        final int MAXIMO_AVANCE = 2;
        return (int) (Math.random() * (MAXIMO_AVANCE + 1));
    }
}
