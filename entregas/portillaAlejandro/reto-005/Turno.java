

public class Turno {

    public int obtenerTurno(int numeroCaballos) {
        return (int)(Math.random() * numeroCaballos);
    }
}