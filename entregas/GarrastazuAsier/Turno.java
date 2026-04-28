public class Turno {
    private int actual;
    private int totalCaballos;

    public Turno(int totalCaballos) {
        this.totalCaballos = totalCaballos;
        this.actual = (int)(Math.random() * totalCaballos);
    }

    public int toca() {
        return actual;
    }

    public void siguiente() {
        actual++;
        if (actual >= totalCaballos) {
            actual = 0;
        }
    }
}

