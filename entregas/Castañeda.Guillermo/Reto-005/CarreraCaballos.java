import java.util.Random;

public class CarreraCaballos {
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        carrera.jugar();
    }
}

class Carrera {
    private int meta = 40;
    private Random r = new Random();

    public void jugar() {
        Caballo c1 = new Caballo(1);
        Caballo c2 = new Caballo(2);

        int turno = r.nextInt(2);

        if (turno == 0) c1.avanzar(r.nextInt(3));
        else c2.avanzar(r.nextInt(3));

        mostrar(c1, c2);
    }

    private void mostrar(Caballo c1, Caballo c2) {
        System.out.println("----------------------------------------------");

        for (int i = 0; i < meta; i++) {
            if (i == c1.getPosicion()) System.out.print(";-;'");
            else System.out.print(" ");
        }
        System.out.println();

        for (int i = 0; i < meta; i++) {
            if (i == c2.getPosicion()) System.out.print(";-;'");
            else System.out.print(" ");
        }
        System.out.println();

        System.out.println("----------------------------------------------");
    }
}

class Caballo {
    private int numero;
    private int posicion;

    public Caballo(int numero) {
        this.numero = numero;
        this.posicion = 0;
    }

    public void avanzar(int pasos) {
        posicion += pasos;
    }

    public int getPosicion() {
        return posicion;
    }
}