class carreraDeCaballos {
    public static void main(String[] args){
        Carrera carrera = new Carrera();
        carrera.jugar();
    }
}

class Carrera {
    private Caballo caballo1;
    private Caballo caballo2;
    private final int META = 40;
    private final String SEPARADOR = "----------------------------------------------";

    public Carrera() {
        caballo1 = new Caballo();
        caballo2 = new Caballo();
    }

    public void jugar() {
        boolean carreraFinalizada = false;
        
        System.out.println("¡Comienza la carrera de caballos!");
        
        int turnoInicial = (int) (Math.random() * 2) + 1;
        System.out.println("Por sorteo, el primer movimiento lo hace el caballo " + turnoInicial + "\n");

        while (!carreraFinalizada) {
            if (turnoInicial == 1) {
                caballo1.avanzar();
                caballo2.avanzar();
            } else {
                caballo2.avanzar();
                caballo1.avanzar();
            }

            System.out.println(SEPARADOR);
            caballo1.dibujar();
            caballo2.dibujar();
            System.out.println(SEPARADOR);
            System.out.println(); 

            if (caballo1.getPosicion() >= META || caballo2.getPosicion() >= META) {
                carreraFinalizada = true;
                anunciarGanador();
            }
        }
    }

    private void anunciarGanador() {
        if (caballo1.getPosicion() >= META && caballo2.getPosicion() >= META) {
            System.out.println("¡Es un EMPATE! Ambos cruzaron la meta al mismo tiempo.");
        } else if (caballo1.getPosicion() >= META) {
            System.out.println("¡Ganó el caballo 1!");
        } else {
            System.out.println("¡Ganó el caballo 2!");
        }
    }
}

class Caballo {
    private int posicion;
    private final String SIMBOLO = ";-;'";

    public Caballo() {
        this.posicion = 0; 
    }

    public void avanzar() {
        int pasos = (int) (Math.random() * 3);
        this.posicion += pasos;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public void dibujar() {
        String espacios = " ".repeat(this.posicion);
        System.out.println(espacios + SIMBOLO);
    }
}
