public class Pista {
    private int longitud;

    public Pista(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void mostrar(Caballo[] caballos) {
        System.out.println("----------------------------------------------");

        for (Caballo c : caballos) {
            int pos = Math.min(c.getPosicion(), longitud);

            for (int i = 0; i < pos; i++) {
                System.out.print(" ");
            }
            System.out.println(";-;'");
        }

        System.out.println("----------------------------------------------\n");
    }
}