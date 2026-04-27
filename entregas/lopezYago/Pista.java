package entregas.lopezYago;

public class Pista {
    private int[] posiciones;
    private final int META = 40;

    public Pista(int numeroCaballos) {
        posiciones = new int[numeroCaballos];
        for (int i = 0; i < numeroCaballos; i++) {
            posiciones[i] = 0;
        }
    }

    public void mover(int caballo, int avance) {
        posiciones[caballo] = posiciones[caballo] + avance;
        if (posiciones[caballo] > META) {
            posiciones[caballo] = META;
        }
    }

    public void mostrarResultadoFinal() {
        System.out.println("Resultado final:");
        for (int i = 0; i < posiciones.length; i++) {
            if (posiciones[i] >= META) {
                System.out.println("Ganó el caballo " + (i + 1));
            }
        }
    }

    public boolean hayGanador(int caballo) {
        return posiciones[caballo] >= META;
    }

    public boolean hayGanadores() {
        for(int i = 0; i < posiciones.length; i++) {
            if (this.hayGanador(i)) {
                return true;
            }
        }
        return false;
    }

    public void mostrar() {
        for (int i = 0; i < META; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < posiciones.length; i++) {
            for (int j = 0; j < posiciones[i]; j++) {
                System.out.print(" ");
            }
            System.out.println(";-;'");
        }
        for (int i = 0; i < META; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
