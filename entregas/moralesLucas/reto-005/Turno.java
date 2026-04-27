public class Turno {

    public int siguienteTurno(int totalCaballos) {
        return (int)(Math.random() * totalCaballos);
    }
}