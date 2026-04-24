public class Turno {

    private int valor;
       
    public Turno() {
    valor = (int) (Math.random() * 2);
    }

    public int toca() {
        return valor;
    }

    public int noLeToca() {}

    public void cambiar() {}
}
