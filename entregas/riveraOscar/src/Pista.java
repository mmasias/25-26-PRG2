public class Pista {
    private int largoPista;
    private int distanciaMeta;
    private String dibujoCaballo;

    public Pista() {
        this.largoPista = 44;
        this.distanciaMeta = 40;
        this.dibujoCaballo = ";-;'";
    }

    public void mostrarPista(Caballo[] caballos) {
        System.out.println("-".repeat(largoPista));

        for (Caballo caballo : caballos) {
            for (int j = 0; j < caballo.obtenerPosicion(); j++) {
                System.out.print(" ");
            }
            System.out.println(dibujoCaballo);
        }

        System.out.println("-".repeat(largoPista));
        System.out.println();
    }

    public boolean existeGanador(Caballo[] caballos) {
        for (Caballo caballo : caballos) {
            if (caballo.obtenerPosicion() >= distanciaMeta) {
                return true;
            }
        }
        return false;
    }

    public boolean existeEmpate(Caballo[] caballos) {
        int contadorGanadores = 0;
        for (Caballo caballo : caballos) {
            if (caballo.obtenerPosicion() >= distanciaMeta) {
                contadorGanadores++;
            }
        }
        return contadorGanadores > 1;
    }
}