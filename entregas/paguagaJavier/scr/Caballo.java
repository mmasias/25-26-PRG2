import java.util.Random;

class Caballo {
    private int distanciaRecorrida;
    private int id;
    private Random random;

    public Caballo(int id) {
        this.id = id;
        this.distanciaRecorrida = 0;
        this.random = new Random();
    }

    public void moverCaballos() {
        int avance = random.nextInt(3);
        this.distanciaRecorrida += avance;
        
        System.out.println("El Caballo " + id + " ha avanzado " + avance + " metros.");
    }

    public int DistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public int Id() {
        return id;
    }
}
