public class CarreraCaballos {
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        carrera.jugar();
    }
}

class Carrera {
    public void jugar() {
        Caballo c1 = new Caballo(1);
        Caballo c2 = new Caballo(2);
        System.out.println("Caballos: " + c1.getNumero() + ", " + c2.getNumero());
    }
}

class Caballo {
    private int numero;

    public Caballo(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}