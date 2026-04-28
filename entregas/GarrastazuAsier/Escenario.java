public class Escenario {

    public void mostrar(Caballo[] caballos) {

        System.out.println("----------------------------------------------");

        for (int i = 0; i < caballos.length; i++) {

            for (int j = 0; j < caballos[i].getPosicionActual(); j++) {
                System.out.print(" ");
            }

            System.out.println(caballos[i].getNombre());
        }

        System.out.println("----------------------------------------------");
    }
}