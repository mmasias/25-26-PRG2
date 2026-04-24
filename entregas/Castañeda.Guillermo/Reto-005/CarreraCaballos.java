public class CarreraCaballos {
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        carrera.jugar();
    }
}

class Carrera {
    public void jugar() {
        Caballo c1 = new Caballo(1);
        c1.avanzar(2);
        System.out.println(c1.getPosicion());
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