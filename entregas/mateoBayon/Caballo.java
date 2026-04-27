class Juego {
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        carrera.jugar();
    }
}

public class Caballo {
    private int posicion;
    private String modelo = ";-;'";

    public Caballo(){
        this.posicion = 0;
    }

    public void caballoAvanza(){
        this.posicion += (int)(Math.random() * 3);
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public String obtenerModelo() {
        return modelo;
    }
}

public class Carrera {
    private Caballo caballo1 = new Caballo();
    private Caballo caballo2 = new Caballo();
}