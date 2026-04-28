public class Turno {
    public int ejecutar(Caballo caballo) {
        int avance = calcularAvance();
        caballo.recibirAvance(avance);
        return avance;
    }

    private int calcularAvance() {
        return (int) (Math.random() * 3);
    }
}
