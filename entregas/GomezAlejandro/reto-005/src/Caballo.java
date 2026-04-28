public class Caballo {
    private int distancia;
    private int ultimoAvance;

    public Caballo() {
        distancia = 0;
        ultimoAvance = 0;
    }

    public void avanzar() {
        ultimoAvance = (int) (Math.random() * 3);
        distancia += ultimoAvance;
    }

    public int distancia() {
        return distancia;
    }
}
