package entregas.lopezYago;

public class Turno {
    private int valor;

    public Turno() {
        valor = (int) (Math.random() * 2);
    }

    public int toca() {
        return valor;
    }

    public void cambiar() {
        valor = (valor + 1) % 2;
    }
}
