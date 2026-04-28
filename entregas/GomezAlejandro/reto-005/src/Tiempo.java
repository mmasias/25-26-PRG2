public class Tiempo {
    private int segundos;

    public Tiempo() {
        segundos = 0;
    }

    public void avanzar() {
        segundos++;
    }

    public int mostrar() {
        return segundos;
    }
}
