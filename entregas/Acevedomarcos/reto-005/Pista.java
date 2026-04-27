public class Pista<Caballo> {

    private int longitud;

    public Pista(int longitud) {
        this.longitud = longitud;
    }

    public void mostrar(Caballo[] caballos) {

        System.out.println("----------------------------------------------");

        for (int i = 0; i < caballos.length; i++) {

            for (int j = 0; j < longitud; j++) {

                if (j == caballos[i].getPosicion()) {
                    System.out.print(";-;'");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        System.out.println("----------------------------------------------");
        System.out.println();
    }

    public boolean hayGanador(Caballo[] caballos) {

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                return true;
            }
        }
        return false;
    }

    public void mostrarResultado(Caballo[] caballos) {

        int ganadores = 0;
        int numeroGanador = 0;

        for (int i = 0; i < caballos.length; i++) {
            if (caballos[i].getPosicion() >= longitud) {
                ganadores++;
                numeroGanador = caballos[i].getNumero();
            }
        }

        if (ganadores > 1) {
            System.out.println("Empate!");
        } else {
            System.out.println("Ganó el caballo " + numeroGanador);
        }
    }
}