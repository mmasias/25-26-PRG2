public class Tiempo {
    private int segundos;
    public Tiempo () {

    }

    public void avanzar () {
      segundos = segundos + 1;
    }
    public int mostrar () {
        return segundos;
    }
}
