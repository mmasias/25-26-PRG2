public class Turno {
    private int actual;
    private int total;

    public Turno(int total) {
        this.total = total;
        this.actual = (int)(Math.random() * total); // empieza aleatorio
    }

    public int toca() {
        return actual;
    }

    public void siguiente() {
        actual++;
        if (actual >= total) {
            actual = 0;
        }
    }
}


    

