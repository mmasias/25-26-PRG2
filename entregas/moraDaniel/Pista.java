package entregas.moraDaniel;

public class Pista {
    private static final int LONGITUD = 40;

    public void dibujar(Caballo caballo1, Caballo caballo2) {
        for (int i = 0; i < LONGITUD; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < LONGITUD; i++) {
            if (caballo1.getPosicion() == i) {
                System.out.print(caballo1.getSimbolo());
            } else if (caballo2.getPosicion() == i) {
                System.out.print(caballo2.getSimbolo());
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < LONGITUD; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
