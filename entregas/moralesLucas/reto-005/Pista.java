public class Pista {

    private final int LONGITUD = 40;

    public void mostrar(Caballo[] caballos) {

        System.out.println("----------------------------------------------");

        for (int i = 0; i < caballos.length; i++) {

            int pos = caballos[i].getPosicion();

            for (int j = 0; j < pos; j++) {
                System.out.print(" ");
            }

            System.out.println(";-;'" + " (" + caballos[i].getNumero() + ")");
        }

        System.out.println("----------------------------------------------");
    }
}