public class Turno {

    private int valor;
       
    public Turno() {
    valor = (int) (Math.random() * 2);
    }

    public int toca() {
        return valor;
    }

    public int noLeToca() {
        return (valor + 1) % 2;
    }

    public void cambiar() {
        valor = (valor + 1) % 2;
    }
}
