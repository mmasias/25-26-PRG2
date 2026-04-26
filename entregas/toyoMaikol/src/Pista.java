    public class Pista {
        private int longitud;
    private int[] posiciones;

    public void avanzarCaballo(int numeroCaballo, int avance) {
        int i = numeroCaballo - 1;
        if (i >= 0 && i < posiciones.length) {
            posiciones[i] += avance;
            if (posiciones[i] > longitud - 1) {
                posiciones[i] = longitud - 1;
            }
        }
    }

    public void mostrarPista() {
        System.out.println("----------------------------------------------");
        for (int i = 0; i < posiciones.length; i++) {
            StringBuilder pista = new StringBuilder();
            for (int j = 0; j < longitud; j++) {
                if (j == posiciones[i]) {
                    pista.append(";-;'");
                } else {
                    pista.append(" ");
                }
            }
            System.out.println(pista.toString());
        }
        System.out.println("----------------------------------------------");
    }

    public boolean haSidoCompletada() {
        for (int pos : posiciones) {
            if (pos >= longitud - 1) {
                return true;
            }
        }
        return false;
    }

    public void mostrarResultadoFinal() {
        int max = -1;
        for (int pos : posiciones) {
            if (pos > max) max = pos;
        }
         StringBuilder ganadores = new StringBuilder();
        for (int i = 0; i < posiciones.length; i++) {
            if (posiciones[i] == max) {
                if (ganadores.length() > 0) ganadores.append(", ");
                ganadores.append("caballo ").append(i + 1);
            }
        }
         if (ganadores.toString().contains(",")) {
            System.out.println("Empate entre: " + ganadores);
        } else {
            System.out.println("Ganó el " + ganadores);
        }
    }

    public Pista(int longitud, int numeroJugadores){
        this.longitud = longitud;
        this.posiciones = new int[numeroJugadores];
        for (int i = 0; i < numeroJugadores; i++) {
            posiciones[i] = 0;
        }
    }

}
