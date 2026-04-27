public class Pista {
    
    private int meta;
    private Caballo[] caballos;

    public Pista(int longitudMeta, int cantidadCaballos) {
        this.meta = longitudMeta;
        this.caballos = new Caballo[cantidadCaballos];
        
        this.caballos[0] = new Caballo(1);
        this.caballos[1] = new Caballo(2);
    }

    public void avanzarCaballo(int indiceCaballo) {
        this.caballos[indiceCaballo].avanzar();
    }

    public boolean hayCaballoEnMeta() {
        return this.caballos[0].posicion() >= this.meta || this.caballos[1].posicion() >= this.meta;
    }

    public void mostrar() {
        System.out.println("----------------------------------------------");
        this.caballos[0].dibujar();
        this.caballos[1].dibujar();
        System.out.println("----------------------------------------------");
    }

    public void anunciarGanador() {
        boolean gana1 = this.caballos[0].posicion() >= this.meta;
        boolean gana2 = this.caballos[1].posicion() >= this.meta;
        
        if (gana1 && gana2) {
            System.out.println("¡Empate épico!");
        } else if (gana1) {
            System.out.println("Ganó el caballo 1");
        } else {
            System.out.println("Ganó el caballo 2");
        }
    }
}