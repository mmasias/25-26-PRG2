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
    private int META_FINAL = 40;

    private void jugar(){
        while(caballo1.obtenerPosicion() < META_FINAL && caballo2.obtenerPosicion() < META_FINAL){
            caballo1.caballoAvanza();
            caballo2.caballoAvanza();
            mostrarPista();
        }
        mostrarGanador();
    }

    private void mostrarPista(){
        System.out.println("[][][][][][][][][][][][][][][][][][][][][][][]");
        System.out.println("".repeat(caballo1.obtenerPosicion()) + caballo1.obtenerModelo());
        System.out.println("".repeat(caballo2.obtenerPosicion()) + caballo2.obtenerModelo());
        System.out.println("----------------------------------------------");
    }
}