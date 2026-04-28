public class Pista {
    private int longitud;

    public Pista(int longitud){
        this.longitud=longitud;
    }

    public void dibujar(Caballo[] caballos) {
        Utilidad.limpiarPantalla();
        System.out.println("==============================================");
        for(int i=0;i<caballos.length;i++){
            imprimirCarril(caballos[i]);
        }
        System.out.println("==============================================");

    }

    public void imprimirCarril(Caballo c) {
        int avance = Math.min(c.getPosicion(),longitud);
        for(int i = 0;i<avance;i++){
            System.out.print(" ");
        }
        System.out.println(";-;' (C" + c.getNumero() + ")");    
    }

    public int getLongitud() {
        return longitud;
    }
}
