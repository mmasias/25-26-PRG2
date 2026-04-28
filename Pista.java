public class Pista {
    private int longitud;

    public Pista(int longitud) {
        this.longitud = longitud;
    }

    public void mostrarEstado(Caballo c1, Caballo c2) {
        System.out.println("-------------------------------------------");
        imprimirCarril(c1.getPosicion());
        imprimirCarril(c2.getPosicion());
        System.out.println("-------------------------------------------");
    }

    private void imprimirCarril(int posicion) {
        for (int i = 0; i < posicion; i++) {
            System.out.print(" ");
        }
        System.out.println(";-;'");
    }

    public int getLongitud() {
        return longitud;
    }
}