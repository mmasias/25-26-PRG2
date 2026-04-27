
public class Pista {

    private int longitud;

    public Pista(int longitud) {
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void mostrar(Caballo caballo1, Caballo caballo2) {

        System.out.println("----------------------------------------------");

        for (int i = 0; i <= longitud; i++) {

            if (i == caballo1.getPosicion()) {
                System.out.print(";-;'");
            } else if (i == caballo2.getPosicion()) {
                System.out.print(";-;'");
            } else {
                System.out.print(" ");
            }
        }

        System.out.println();
        System.out.println("----------------------------------------------");
    }
}