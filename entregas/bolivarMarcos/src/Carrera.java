public class Carrera {
    private Caballo[] caballos;
    private Pista pista;
    
    public Carrera(int cantidadCaballos, int longitudPista) {
        this.pista = new Pista(longitudPista);
        this.caballos = new Caballo[cantidadCaballos];
        for (int i = 0; i < cantidadCaballos; i++) {
            caballos[i] = new Caballo(i + 1);
        }
    }
    
    public void jugar() {
        boolean hayGanador= false;

        while(!hayGanador) {
            for (int i = 0; i < caballos.length; i++) {
                caballos[i].avanzar();
                if(caballos[i].getPosicion()>=pista.getLongitud()) {
                    hayGanador=true;
                }
            }
            pista.dibujar(caballos);
            Utilidad.pausar(1);   
        }
        anunciarResultados();
    }

    private void anunciarResultados() {
        System.out.println("\n¡LA CARRERA HA TERMINADO!");
        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= pista.getLongitud()) {
                System.out.println("Ha ganado el caballo " + caballos[i].getNumero() + "!");
            }
        }
    }
 }
